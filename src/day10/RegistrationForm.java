package day10;
import javax.swing.*;
import java.awt.*;

public class RegistrationForm {

    public static void main(String[] args) {

        JFrame f = new JFrame("Registration Form");

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("Email:");
        JLabel l3 = new JLabel("Address:");
        JLabel l4 = new JLabel("Gender:");
        JLabel l5 = new JLabel("Hobbies:");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextArea ta = new JTextArea();

        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JCheckBox c1 = new JCheckBox("Reading");
        JCheckBox c2 = new JCheckBox("Sports");
        JCheckBox c3 = new JCheckBox("Music");

        JButton b = new JButton("Register");

        ImageIcon img = new ImageIcon("logo.png");
        JLabel imageLabel = new JLabel(img);

        l1.setBounds(50,50,100,30);
        t1.setBounds(150,50,150,30);

        l2.setBounds(50,100,100,30);
        t2.setBounds(150,100,150,30);

        l3.setBounds(50,150,100,30);
        ta.setBounds(150,150,150,60);

        l4.setBounds(50,230,100,30);
        r1.setBounds(150,230,70,30);
        r2.setBounds(220,230,80,30);

        l5.setBounds(50,270,100,30);
        c1.setBounds(150,270,80,30);
        c2.setBounds(230,270,80,30);
        c3.setBounds(310,270,80,30);

        b.setBounds(150,320,100,30);

        imageLabel.setBounds(350,50,150,150);

        // Add components
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(ta);
        f.add(l4); f.add(r1); f.add(r2);
        f.add(l5); f.add(c1); f.add(c2); f.add(c3);
        f.add(b);
        f.add(imageLabel);

        f.setSize(550,450);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}