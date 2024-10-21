import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    JButton deposit,fastcash,pinchange,cashwithdaw,minis,balance,exit;
    String pinno;
    transaction(String pinno){
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1200,800);
        add(image);

        JLabel heading=new JLabel("Please Select Your Transaction");
        heading.setBounds(255,255,350,25);
        heading.setFont(new Font("Railway",Font.BOLD,22));
        heading.setForeground(Color.white);
        image.add(heading);

        deposit=new JButton("DEPOSIT");
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.setBounds(230,330,220,25);
        deposit.setFont(new Font("Railway",Font.BOLD,15));
        deposit.addActionListener(this::actionPerformed);
        image.add(deposit);
        fastcash=new JButton("FAST CASH");
        fastcash.setBackground(Color.white);
        fastcash.setForeground(Color.black);
        fastcash.setBounds(230,365,220,25);
        fastcash.setFont(new Font("Railway",Font.BOLD,15));
        fastcash.addActionListener(this::actionPerformed);
        image.add(fastcash);
        pinchange=new JButton("PIN CHANGE");
        pinchange.setBackground(Color.white);
        pinchange.setForeground(Color.black);
        pinchange.setBounds(230,400,220,25);
        pinchange.setFont(new Font("Railway",Font.BOLD,15));
        pinchange.addActionListener(this::actionPerformed);
        image.add(pinchange);

        cashwithdaw=new JButton("CASH WITHDRAWL");
        cashwithdaw.setBackground(Color.white);
        cashwithdaw.setForeground(Color.black);
        cashwithdaw.setBounds(450,330,220,25);
        cashwithdaw.setFont(new Font("Railway",Font.BOLD,15));
        cashwithdaw.addActionListener(this::actionPerformed);
        image.add(cashwithdaw);
        minis=new JButton("MINI STATEMENT");
        minis.setBackground(Color.white);
        minis.setForeground(Color.black);
        minis.setBounds(450,365,220,25);
        minis.setFont(new Font("Railway",Font.BOLD,15));
        minis.addActionListener(this::actionPerformed);
        image.add(minis);
        balance=new JButton("BALANCE ENQUIRY");
        balance.setBackground(Color.white);
        balance.setForeground(Color.black);
        balance.setBounds(450,400,220,25);
        balance.setFont(new Font("Railway",Font.BOLD,15));
        balance.addActionListener(this::actionPerformed);
        image.add(balance);
        exit=new JButton("EXIT");
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setBounds(450,430,220,25);
        exit.setFont(new Font("Railway",Font.BOLD,15));
        exit.addActionListener(this::actionPerformed);
        image.add(exit);


        setSize(1200,800);
        setLocation(170,0);
        setUndecorated(true);//to remove the upper header of frame
        setVisible(true);
        //setTitle("Automated Teller Machine");


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);//to exit the running of program
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new deposit(pinno).setVisible(true);
        } else if (ae.getSource()==cashwithdaw) {
            setVisible(false);
            new withdrawl(pinno).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new fastcash(pinno).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new pinchange(pinno).setVisible(true);
        } else if (ae.getSource()==balance) {
            setVisible(false);
            new balanceEnquiry(pinno).setVisible(true);
        } else if (ae.getSource()==minis) {
            new ministatement(pinno).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new transaction("");
    }
}
