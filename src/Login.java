import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signIn,clear,signUp;
    JTextField cardTextFeild;
    JPasswordField pinTextField;
    Login(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//to get the image
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//to set the dimensions of image inside frame.
        //but image class is a part of awt package,

        ImageIcon i3=new ImageIcon(i2);//to put the resized image on ImageIcon object
        JLabel label=new JLabel(i3);//to put the to put the resized image on frame
        /*we cannot pass the object of Image class in JLabel class. hence we first pass the object of Image class(after changing the dimensions) to ImageIcon . after that we pass the object of ImageIcon to the JLabel */
        add(label);
        label.setBounds(70,10,100,100);//to change the position of label(hence image)
        setLayout(null);//so that the default layout becomes null so that the setBounds function(providing custom layout) could work
        getContentPane().setBackground(Color.white);//to change the color of frame//getContentPane() is to get the whole frame.

        JLabel text=new JLabel("welcome to ATM");//to add the text
        text.setFont(new Font("osward",Font.BOLD,40));//to set the font of added text
        text.setBounds(200,40,400,40);//to define the dimensions of text
        add(text);//to add the text to frame

        JLabel cardno=new JLabel("Card No. :");//adding the text
        cardno.setBounds(120,150,200,40);
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        add(cardno);
        cardTextFeild=new JTextField();//to add a textfield to the frame where user can enter text
        //these text fields are also to be declared globally to be used by actionPerformed () method
        cardTextFeild.setBounds(300,155,200,30);//setting the dimensions of text field
        add(cardTextFeild);//adding the text field


        JLabel pin=new JLabel("PIN :");//adding the text
        pin.setBounds(120,220,200,40);
        pin.setFont(new Font("Railway",Font.BOLD,28));
        add(pin);
        pinTextField=new JPasswordField();//adding the text field for pin
        pinTextField.setBounds(300,225,200,30);
        add(pinTextField);

        signIn=new JButton("SIGN IN");//adding signin button to the frame
        //these buttons were locally declared and cannot be used outside the constructor.
        //hence we will have to declare them globally
        signIn.setBounds(300,300,90,25);
        signIn.setBackground(Color.black);
        signIn.setForeground(Color.white);
        add(signIn);
        signIn.addActionListener(this::actionPerformed);//to acknowledge the pressing of button

        clear=new JButton("CLEAR");//adding clear button to frame
        clear.setBounds(405,300,90 ,25);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        add(clear);
        clear.addActionListener(this::actionPerformed);

        signUp=new JButton("SIGN UP");//adding signup button to frame
        signUp.setBounds(350,340,100,25);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        add(signUp);
        signUp.addActionListener(this::actionPerformed);

        setTitle("Automated Teller Machine");//to set the title of the frame
        setSize(800,500);
        setVisible(true);//we have to set this function to make the frame visible because by default visibility of frame is false;
        setLocation(350,150);//by default location of frame opening is top-left.to change this opening location,we use this function
    }
    //after clicking the button what action is to performed is defined in this function.
    //this actionevent class is used to handle the components with which the action is to be performed
    //ae is the variable
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == this.clear){
            //getSource() is a method of ActionEvent class which compares the component to deal with
            cardTextFeild.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == this.signIn) {
            //here if signin button is pressed,then we have to fetch data from database(login)
            //therefore we have to establish the connection
            connect c=new connect();
            String cardno=cardTextFeild.getText();
            String pinno=pinTextField.getText();
            //now we fetch the data and compare these values with the values of the database
            String query="select * from login where card_no='"+cardno+"' and pin='"+pinno+"'";
            //in the above query,card_no is the variable of database and cardno is the variable used here.
            //similarly for the pin. this query is a ddl command.queries that we have used in signup tables are dml commands
            try{
                c.s.executeQuery(query);//with dml command we use executeUpdate() method but with ddl commands we use this method
                //here this query will fetch data and then will return data which can be stored in the object of resultset class
                ResultSet rs=c.s.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new transaction(pinno).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }

            
        }
        else if (ae.getSource() == this.signUp) {
            setVisible(false);
            new signup1().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
