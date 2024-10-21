import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    JRadioButton saving,current,fd_acc,rec_dep_acc;
    String formno;
    signup3(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel heading=new JLabel("Page 3 : Account Details");
        heading.setBounds(300,40,400,35);
        heading.setFont(new Font("Railway",Font.BOLD,30));
        add(heading);

        JLabel accType=new JLabel("Account Type");
        accType.setBounds(100,150,200,30);
        accType.setFont(new Font("Railway",Font.BOLD,25));
        add(accType);
        saving=new JRadioButton("Savings Account");
        saving.setBackground(Color.white);
        saving.setBounds(100,190,300,20);
        saving.setFont(new Font("Railway",Font.BOLD,15));
        add(saving);
        current=new JRadioButton("Current Account");
        current.setBackground(Color.white);
        current.setBounds(400,190,300,20);
        current.setFont(new Font("Railway",Font.BOLD,15));
        add(current);
        fd_acc=new JRadioButton("Fixed Deposit Account");
        fd_acc.setBackground(Color.white);
        fd_acc.setBounds(100,230,300,20);
        fd_acc.setFont(new Font("Railway",Font.BOLD,15));
        add(fd_acc);
        rec_dep_acc=new JRadioButton("Reccuring Deposit Account");
        rec_dep_acc.setBackground(Color.white);
        rec_dep_acc.setBounds(400,230,300,20);
        rec_dep_acc.setFont(new Font("Railway",Font.BOLD,15));
        add(rec_dep_acc);
        ButtonGroup accTypeGroup=new ButtonGroup();
        accTypeGroup.add(saving);
        accTypeGroup.add(current);
        accTypeGroup.add(fd_acc);
        accTypeGroup.add(rec_dep_acc);

        JLabel cardno=new JLabel("Card Number");
        cardno.setBounds(100,270,200,30);
        cardno.setFont(new Font("Railway",Font.BOLD,25));
        add(cardno);
        JLabel number=new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setBounds(400,270,400,30);
        number.setFont(new Font("Railway",Font.BOLD,25));
        add(number);
        JLabel cardnoLabel=new JLabel("Your 16 digit Card Number");
        cardnoLabel.setBounds(100,305,200,15);
        cardnoLabel.setFont(new Font("Railway",Font.BOLD,10));
        add(cardnoLabel);

        JLabel pin=new JLabel("PIN");
        pin.setBounds(100,340,200,30);
        pin.setFont(new Font("Railway",Font.BOLD,25));
        add(pin);
        JLabel number1=new JLabel("XXXX");
        number1.setBounds(400,340,200,30);
        number1.setFont(new Font("Railway",Font.BOLD,25));
        add(number1);
        JLabel pinLabel=new JLabel("Your 4 digit Card Password");
        pinLabel.setBounds(100,375,200,15);
        pinLabel.setFont(new Font("Railway",Font.BOLD,10));
        add(pinLabel);

        JLabel ser_req=new JLabel("Services Required");
        ser_req.setBounds(100,410,300,30);
        ser_req.setFont(new Font("Railway",Font.BOLD,25));
        add(ser_req);
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(100,450,300,20);
        c1.setFont(new Font("Railway",Font.BOLD,15));
        add(c1);
        c2=new JCheckBox("Mobile Banking");
        c2.setBackground(Color.white);
        c2.setBounds(100,490,300,20);
        c2.setFont(new Font("Railway",Font.BOLD,15));
        add(c2);
        c3=new JCheckBox("Cheque Book");
        c3.setBackground(Color.white);
        c3.setBounds(100,530,300,20);
        c3.setFont(new Font("Railway",Font.BOLD,15));
        add(c3);
        c4=new JCheckBox("Internet Banking");
        c4.setBackground(Color.white);
        c4.setBounds(400,450,300,20);
        c4.setFont(new Font("Railway",Font.BOLD,15));
        add(c4);
        c5=new JCheckBox("Email & SMS Alerts");
        c5.setBackground(Color.white);
        c5.setBounds(400,490,300,20);
        c5.setFont(new Font("Railway",Font.BOLD,15));
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(400,530,300,20);
        c6.setFont(new Font("Railway",Font.BOLD,15));
        add(c6);
        c7=new JCheckBox("I hereby declare that the above provided details are correct upto my knowledge");
        c7.setBackground(Color.white);
        c7.setBounds(100,580,750,20);
        c7.setFont(new Font("Railway",Font.BOLD,15));
        add(c7);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(300,640,150,30);
        submit.setFont(new Font("Railway",Font.BOLD,25));
        add(submit);
        submit.addActionListener(this::actionPerformed);

        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(500,640,150,30);
        cancel.setFont(new Font("Railway",Font.BOLD,25));
        add(cancel);
        cancel.addActionListener(this::actionPerformed);

        setSize(1000,820);
        setLocation(300,0);
        setVisible(true);
        setTitle("Bank Management System");
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String accountType=null;
            if (saving.isSelected()){
                accountType="Savings Account";
            } else if (current.isSelected()) {
                accountType="Current Account";
            } else if (fd_acc.isSelected()) {
                accountType="Fixed Deposite Account";
            } else if (rec_dep_acc.isSelected()) {
                accountType="Reccuring Deposite Account";
            }

            Random random=new Random();
            String cardno= "" + Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pin=""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility="";
            if (c1.isSelected()){
                facility=facility+" ATM Card";
            } else if (c2.isSelected()) {
                facility=facility+" Mobile Banking";
            }else if (c3.isSelected()) {
                facility=facility+" Cheque Book";
            }else if (c4.isSelected()) {
                facility=facility+" Internet Banking";
            }else if (c5.isSelected()) {
                facility=facility+" Email & SMS Alert";
            }else if (c6.isSelected()) {
                facility=facility+" E-Statement";
            }

            try {
                connect c=new connect();
                String query1="insert into signup3 values('"+formno+"','"+accountType+"','"+cardno+"','"+pin+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n"+"PIN : "+pin);

                setVisible(false);
                new deposit(pin).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }

        }
        else if (ae.getSource()==cancel) {
                setVisible(false);
                new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signup3("");
    }
}
