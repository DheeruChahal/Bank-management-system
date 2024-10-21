import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class fastcash extends JFrame implements ActionListener {
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,back;
    String pinno;
    fastcash(String pinno){
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

        hundred=new JButton("rs 100");
        hundred.setBackground(Color.white);
        hundred.setForeground(Color.black);
        hundred.setBounds(230,330,220,25);
        hundred.setFont(new Font("Railway",Font.BOLD,15));
        hundred.addActionListener(this::actionPerformed);
        image.add(hundred);
        fivehundred=new JButton("rs 500");
        fivehundred.setBackground(Color.white);
        fivehundred.setForeground(Color.black);
        fivehundred.setBounds(230,365,220,25);
        fivehundred.setFont(new Font("Railway",Font.BOLD,15));
        fivehundred.addActionListener(this::actionPerformed);
        image.add(fivehundred);
        thousand=new JButton("rs 1000");
        thousand.setBackground(Color.white);
        thousand.setForeground(Color.black);
        thousand.setBounds(230,400,220,25);
        thousand.setFont(new Font("Railway",Font.BOLD,15));
        thousand.addActionListener(this::actionPerformed);
        image.add(thousand);

        twothousand=new JButton("rs 2000");
        twothousand.setBackground(Color.white);
        twothousand.setForeground(Color.black);
        twothousand.setBounds(450,330,220,25);
        twothousand.setFont(new Font("Railway",Font.BOLD,15));
        twothousand.addActionListener(this::actionPerformed);
        image.add(twothousand);
        fivethousand=new JButton("rs 5000");
        fivethousand.setBackground(Color.white);
        fivethousand.setForeground(Color.black);
        fivethousand.setBounds(450,365,220,25);
        fivethousand.setFont(new Font("Railway",Font.BOLD,15));
        fivethousand.addActionListener(this::actionPerformed);
        image.add(fivethousand);
        tenthousand=new JButton("rs 10000");
        tenthousand.setBackground(Color.white);
        tenthousand.setForeground(Color.black);
        tenthousand.setBounds(450,400,220,25);
        tenthousand.setFont(new Font("Railway",Font.BOLD,15));
        tenthousand.addActionListener(this::actionPerformed);
        image.add(tenthousand);
        back=new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(450,430,220,25);
        back.setFont(new Font("Railway",Font.BOLD,15));
        back.addActionListener(this::actionPerformed);
        image.add(back);


        setSize(1200,800);
        setLocation(170,0);
        setUndecorated(true);//to remove the upper header of frame
        setVisible(true);
        //setTitle("Automated Teller Machine");


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new transaction(pinno).setVisible(true);
        } else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            try{
                connect c=new connect();
                //resultset object is used to get the value from database and store them
                ResultSet rs=c.s.executeQuery("select * from bank where pinno='"+pinno+"'");
                int balance=0;
                while (rs.next()){
                    //resultset.next() method is used to iterate through all the values from saved values in database
                    if (rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="Insert into bank values('"+pinno+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"rs "+amount+" has been debited successfully");
                setVisible(false);
                new transaction(pinno).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }
}

