import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinno;
    deposit(String pinno){
        this.pinno=pinno;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1200,800);
        add(image);

        JLabel text=new JLabel("Enter The Amount You Want To Enter");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(275,255,350,20);
        text.setForeground(Color.white);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(255,285,350,20);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(535,435,150,25);
        deposit.addActionListener(this::actionPerformed);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(535,462,150,25);
        back.addActionListener(this::actionPerformed);
        image.add(back);

        setSize(1200,800);
        setLocation(170,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if (number==""){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }else {
                try{
                    connect c=new connect();
                    String query="insert into bank values('"+pinno+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" deposited successfully");
                    setVisible(false);
                    new transaction(pinno).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
            
        } else if (ae.getSource()==back) {
            setVisible(false);
            new transaction(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
