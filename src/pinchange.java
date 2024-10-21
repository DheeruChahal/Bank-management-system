import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JPasswordField pintext,repintext;
    JButton change,back;
    String pinno;
    pinchange(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1200,800);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.BOLD,20));
        text.setBounds(340,255,300,25);
        image.add(text);
        JLabel newpin=new JLabel("New Pin : ");
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("Railway",Font.BOLD,15));
        newpin.setBounds(255,300,200,20);
        image.add(newpin);
         pintext=new JPasswordField();
        pintext.setBounds(440,300,200,20);
        image.add(pintext);

        JLabel repin=new JLabel("Re-Enter Pin : ");
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Railway",Font.BOLD,15));
        repin.setBounds(255,330,200,20);
        image.add(repin);
         repintext=new JPasswordField();
        repintext.setBounds(440,330,200,20);
        image.add(repintext);

         change=new JButton("CHANGE");
        change.setBounds(490,410,150,30);
        change.addActionListener(this::actionPerformed);
        image.add(change);
         back=new JButton("BACK");
        back.setBounds(490,450,150,30);
        back.addActionListener(this::actionPerformed);
        image.add(back);

        setSize(1200,800);
        setLocation(170,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change){
            try {
                String newpin=pintext.getText();
                String reenter=repintext.getText();
                if (!newpin.equals(reenter)){
                    JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                    return;
                }
                if (newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter new Pin");
                    return;
                }
                if (reenter.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-Enter new Pin");
                    return;
                }
                connect c=new connect();
                String query1="update bank set pinno ='"+reenter+"' where pinno='"+pinno+"'";
                String query2="update signup3 set pin='"+reenter+"' where pin='"+pinno+"'";
                String query3="update login set pin='"+reenter+"' where pin='"+pinno+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                setVisible(false);
                new transaction(reenter).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new transaction(pinno).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
}
