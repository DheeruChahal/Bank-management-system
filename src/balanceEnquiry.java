import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinno;
    balanceEnquiry(String pinno){
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1200,800);
        add(image);
        back=new JButton("BACK");
        back.setBounds(510,440,150,35);
        back.addActionListener(this::actionPerformed);
        image.add(back);

        connect c=new connect();
        int balance = 0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pinno = '"+pinno+"'");
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    //these variables here "type" and "Deposit" are variables in database and are case sensitive.
                    //this thing should be taken care of otherwise would produce unrecognised exception
                    balance=balance+Integer.parseInt(rs.getString("amount"));
                }else {
                    balance=balance-Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text=new JLabel("Your current account balance is : "+balance);
        text.setFont(new Font("System",Font.BOLD,15));
        text.setBounds(280,300,300,20);
        text.setForeground(Color.WHITE);
        image.add(text);

        setSize(1200,800);
        setLocation(170,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinno).setVisible(true);

    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
