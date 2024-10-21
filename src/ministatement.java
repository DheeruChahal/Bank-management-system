import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ministatement extends JFrame {
    ministatement(String pinno){
        setLayout(null);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            connect c=new connect();
            ResultSet rs = c.s.executeQuery("select * from login where pin='"+pinno+"'");
            while (rs.next()){
                card.setText("Card no. : "+rs.getString("card_no").substring(0,4)+"XXXXXX"+rs.getString("card_no").substring(9));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            connect c=new connect();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pinno='"+pinno+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

                if (rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Account Balance Is : "+bal);
        }catch(Exception e){
            System.out.println(e);
        }

        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ministatement("");
    }
}
