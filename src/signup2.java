import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup2 extends JFrame implements ActionListener {
    JComboBox religiondd,categorydd,incomedd,educationdd,occupationdd;
    JTextField pantextfield,adhartextfield;
    JRadioButton existingyes,existingno,senioryes,seniorno;
    JButton next;
    String formno;

    public signup2(String formno){
        this.formno = formno;//we need the formno in the signup two class as well because it will act as the primary key for both the tables.
        setLayout(null);
        JLabel heading=new JLabel("Page 2 : Additional Details");
        heading.setBounds(300,40,400,35);
        heading.setFont(new Font("Railway",Font.BOLD,30));
        add(heading);
        JLabel religion=new JLabel("Religion : ");
        religion.setBounds(150,100,200,30);
        religion.setFont(new Font("Railway",Font.BOLD,25));
        add(religion);
        String[] valReligion = {"Hindu","Muslim","Sikh","Christian","Other"};
        religiondd=new JComboBox<>(valReligion);
        religiondd.setBounds(450,100,400,30);
        religiondd.setBackground(Color.white);
        add(religiondd);

        JLabel category=new JLabel("category : ");
        category.setBounds(150,150,200,30);
        category.setFont(new Font("Railway",Font.BOLD,25));
        add(category);
        String[] valcategory = {"General","OBC","SC","ST","EWS"};
        categorydd=new JComboBox<>(valcategory);
        categorydd.setBounds(450,150,400,30);
        categorydd.setBackground(Color.white);
        add(categorydd);

        JLabel income=new JLabel("Income : ");
        income.setBounds(150,200,200,30);
        income.setFont(new Font("Railway",Font.BOLD,25));
        add(income);
        String[] valincome = {"Nil","<2,00,000","<5,00,000","<10,00,000",">10,00,000"};
        incomedd=new JComboBox<>(valincome);
        incomedd.setBounds(450,200,400,30);
        incomedd.setBackground(Color.white);
        add(incomedd);

        JLabel educational=new JLabel("Educational");
        educational.setBounds(150,250,200,30);
        educational.setFont(new Font("Railway",Font.BOLD,25));
        add(educational);
        JLabel qualification=new JLabel("Qualification : ");
        qualification.setBounds(150,285,200,30);
        qualification.setFont(new Font("Railway",Font.BOLD,25));
        add(qualification);
        String[] valeducation = {"< 12th grade","upto 12th grade","Graduate","PostGraduate","Doctorate","Other"};
        educationdd=new JComboBox<>(valeducation);
        educationdd.setBounds(450,285,400,30);
        educationdd.setBackground(Color.white);
        add(educationdd);

        JLabel occupation=new JLabel("Occupation : ");
        occupation.setBounds(150,335,200,30);
        occupation.setFont(new Font("Railway",Font.BOLD,25));
        add(occupation);
        String[] valoccupation = {"government","private"};
        occupationdd=new JComboBox<>(valoccupation);
        occupationdd.setBounds(450,335,400,30);
        occupationdd.setBackground(Color.white);
        add(occupationdd);

        JLabel pan=new JLabel("Pan No. : ");
        pan.setBounds(150,385,200,30);
        pan.setFont(new Font("Railway",Font.BOLD,25));
        add(pan);
        pantextfield=new JTextField();
        pantextfield.setBounds(450,385,400,30);
        add(pantextfield);

        JLabel adhar=new JLabel("Adhar No. : ");
        adhar.setBounds(150,435,200,30);
        adhar.setFont(new Font("Railway",Font.BOLD,25));
        add(adhar);
        adhartextfield=new JTextField();
        adhartextfield.setBounds(450,435,400,30);
        add(adhartextfield);

        JLabel senior=new JLabel("Senior Citizen : ");
        senior.setBounds(150,485,200,30);
        senior.setFont(new Font("Railway",Font.BOLD,25));
        add(senior);
        senioryes=new JRadioButton("Yes");
        senioryes.setBounds(450,485,150,30);
        senioryes.setBackground(Color.white);
        add(senioryes);
        seniorno=new JRadioButton("No");
        seniorno.setBounds(620,485,150,30);
        seniorno.setBackground(Color.white);
        add(seniorno);
        ButtonGroup seniorGroup=new ButtonGroup();
        seniorGroup.add(senioryes);
        seniorGroup.add(seniorno);

        JLabel existing=new JLabel("Existing Account : ");
        existing.setBounds(150,535,250,30);
        existing.setFont(new Font("Railway",Font.BOLD,25));
        add(existing);
        existingyes=new JRadioButton("Yes");
        existingyes.setBounds(450,535,150,30);
        existingyes.setBackground(Color.white);
        add(existingyes);
        existingno=new JRadioButton("No");
        existingno.setBounds(620,535,150,30);
        existingno.setBackground(Color.white);
        add(existingno);
        ButtonGroup existingGroup=new ButtonGroup();
        existingGroup.add(existingyes);
        existingGroup.add(existingno);

        next=new JButton("Next");
        next.setBounds(750,600,100,30);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.addActionListener(this::actionPerformed);
        add(next);

        setSize(1000,820);
        setLocation(300,0);
        setVisible(true);
        setTitle("Bank ManagementSystem");
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        String rel_str=(String) religiondd.getSelectedItem();//getSelectedItem() fn returns an object,so to store it into a string, we have to typecast,
        String category_str=(String) categorydd.getSelectedItem();
        String income_str=(String) incomedd.getSelectedItem();
        String edu_str=(String) educationdd.getSelectedItem();
        String occupation_str= (String) occupationdd.getSelectedItem();
        String pan=pantextfield.getText();
        String adhar=adhartextfield.getText();
        String senior=null;
        if(senioryes.isSelected()){
            senior="Yes";
        } else if (seniorno.isSelected()) {
            senior="No";
        }
        String existing=null;
        if(existingyes.isSelected()){
            existing="Yes";
        } else if (existingno.isSelected()) {
            existing="No";
        }
        try {
            connect c=new connect();
            String query="insert into signup2 values('"+formno+"','"+rel_str+"','"+category_str+"','"+income_str+"','"+edu_str+"','"+occupation_str+"','"+pan+"','"+adhar+"','"+senior+"','"+existing+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new signup3(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new signup2("");
    }
}
