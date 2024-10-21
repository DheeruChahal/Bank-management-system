import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class prototype extends JFrame implements ActionListener {
    JButton button;
    JTextField text;
    prototype(){

//        JLabel label=new JLabel();
//        add(label);


        setLayout(null);
        button=new JButton("button");
        button.setBounds(100,50,100,30);
        button.addActionListener(this::actionPerformed);
        add(button);

        text=new JTextField();
        text.setBounds(100,100,100,30);
        add(text);


        setSize(800,400);
        setVisible(true);
        setTitle("prototype");
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==this.button){
            text.setText("");
        }
    }
    public static void main(String[] args) {
        new prototype();
    }
}
