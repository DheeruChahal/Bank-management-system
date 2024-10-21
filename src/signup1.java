import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signup1 extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    signup1(){
        setLayout(null);
        //generating random number and converting it to 4 digit
        Random rand=new Random();
        random = Math.abs((rand.nextLong()%9000L)+1000L);

        JLabel formNO=new JLabel("Application Form No. "+random);
        formNO.setFont(new Font("Railway",Font.BOLD,38));
        formNO.setBounds(140,20,600,40);
        add(formNO);

        JLabel personalDetails=new JLabel("page1 : Personal Details");
        personalDetails.setFont(new Font("Railway",Font.BOLD,22));
        personalDetails.setBounds(160,80,400,25);
        add(personalDetails);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,130,100,20);
        add(name);
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,20));
        nameTextField.setBounds(350,130,300,30);
        add(nameTextField);

        JLabel fathername=new JLabel("Father's Name :");
        fathername.setFont(new Font("Railway",Font.BOLD,20));
        fathername.setBounds(100,170,250,20);
        add(fathername);
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,20));
        fnameTextField.setBounds(350,170,300,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100,210,200,20);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser .setBounds(350,210,200,30);
        dateChooser.setForeground(new Color(0,0,0));
        add(dateChooser);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,250,100,22);
        add(gender);

        male=new JRadioButton("Male");
        male.setFont(new Font("Railway",Font.BOLD,22));
        male.setBounds(350,250,100,30);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setFont(new Font("Railway",Font.BOLD,22));
        female.setBounds(500,250,200,30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100,290,200,20);
        add(email);
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,20));
        emailTextField.setBounds(350,290,300,30);
        add(emailTextField);

        JLabel marital=new JLabel("Marital Status :");
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100,330,200,20);
        add(marital);

        married=new JRadioButton("Married");
        married.setFont(new Font("Railway",Font.BOLD,22));
        married.setBounds(350,330,150,30);
        married.setBackground(Color.white);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Railway",Font.BOLD,22));
        unmarried.setBounds(500,330,200,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other=new JRadioButton("Other");
        other.setFont(new Font("Railway",Font.BOLD,22));
        other.setBounds(700,330,100,30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup marriedGroup=new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
        marriedGroup.add(other);

        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100,370,200,20);
        add(address);
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,20));
        addressTextField.setBounds(350,370,300,30);
        add(addressTextField);

        JLabel city=new JLabel("City :");
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100,410,200,20);
        add(city);
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,20));
        cityTextField.setBounds(350,410,300,30);
        add(cityTextField);

        JLabel state=new JLabel("State :");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100,450,200,20);
        add(state);
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,20));
        stateTextField.setBounds(350,450,300,30);
        add(stateTextField);

        JLabel pin=new JLabel("Pin Code :");
        pin.setFont(new Font("Railway",Font.BOLD,20));
        pin.setBounds(100,490,200,20);
        add(pin);
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Railway",Font.BOLD,20));
        pinTextField.setBounds(350,490,300,30);
        add(pinTextField);

        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(580,550,70,25);
        add(next);
        next.addActionListener(this::actionPerformed);

        setSize(1000,820);
        setLocation(350,0);
        setVisible(true);
        setTitle("Bank Management System");
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        //now getting the values from the form to save to database
        String formno=""+random;//random is a long type,so to convert it to string,we concatinate with an empty string
        String name=nameTextField.getText();
        String fathername=fnameTextField.getText();
        String gender=null;
        String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        if (male.isSelected()){
            //isSelected() is a method of the ActionEvent class to handle radio buttons
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if (married.isSelected()){
            marital="Married";
        } else if (unmarried.isSelected()) {
            marital="Unmarried";
        } else if (other.isSelected()) {
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pinTextField.getText();
        //now we hit the database, hence there are chances of runtime error.therefeore wrap in try catch block.
        try {
            //applying validation to the fields
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name is required");
                //JOptionPane.showMessageDialog() is used to show a popup message if the next button is clicked while the nameTextfield is empty
                //we can add such validation to every textfield.
            }
            else {
                connect c=new connect();
                String query="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+gender+"','"+dob+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signup2(formno).setVisible(true);//we need the formno in the signup two class as well because it will act as the primary key for both the tables.
                //hence we pass it into the calling of the object
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signup1();
    }
}
