package classwork.swing;
/*Design a user registration form for a Java application using Swing,
incorporating four common Swing components such as Label, TextBox, Button,
 RadioButton. The form should include fields for username, email, gender and
 contact number and upon clicking the button, the textbox should display “Submitted”.
 */
import javax.swing.*;
import java.awt.event.*;
public class UserRegistrationForm {
    public static void main(String[] args) {

        JFrame f = new JFrame("User Registration Form");

        // Labels
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 100, 30);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(50, 100, 100, 30);

        JLabel l3 = new JLabel("Gender:");
        l3.setBounds(50, 150, 100, 30);

        JLabel l4 = new JLabel("Contact No:");
        l4.setBounds(50, 200, 100, 30);

        // TextFields
        JTextField t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 100, 150, 30);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 200, 150, 30);

        // RadioButtons
        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(150, 150, 70, 30);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(220, 150, 80, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        // Button
        JButton b = new JButton("Submit");
        b.setBounds(150, 250, 100, 30);

        // Action
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display "Submitted" in username textbox
                t1.setText("Submitted");
            }
        });

        // Add components
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(r1); f.add(r2);
        f.add(l4); f.add(t3);
        f.add(b);

        // Frame settings
        f.setSize(400, 350);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
