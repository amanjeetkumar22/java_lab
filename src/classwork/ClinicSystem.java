package classwork;
/*Create 2 forms - Login form for Clinic staff to
login and a Patient Registration System where they
will record the Patient details.

Required Fields in a
Patient Registration System
Patient Name (JTextField)
Age (JTextField)
Gender (JRadioButton: Male / Female / Other)
Phone Number (JTextField)
Address (JTextArea)
Symptoms (JTextArea)
Blood Group (JComboBox)
Register Button
Clear Button
Logout Button*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Login Form
class LoginForm extends JFrame implements ActionListener {

    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    LoginForm() {
        setTitle("Clinic Login");
        setSize(300, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Username:"));
        userField = new JTextField(15);
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField(15);
        add(passField);

        loginBtn = new JButton("Login");
        add(loginBtn);

        loginBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        // Simple validation
        if (user.equals("admin") && pass.equals("123")) {
            new PatientForm();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login!");
        }
    }
}

// Patient Registration Form
class PatientForm extends JFrame implements ActionListener {

    JTextField nameField, ageField, phoneField;
    JTextArea addressArea, symptomsArea;
    JRadioButton male, female, other;
    JComboBox<String> bloodGroup;
    JButton registerBtn, clearBtn, logoutBtn;

    PatientForm() {
        setTitle("Patient Registration");
        setSize(400, 500);
        setLayout(new FlowLayout());

        // Fields
        add(new JLabel("Patient Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField(5);
        add(ageField);

        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        add(male);
        add(female);
        add(other);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField(15);
        add(phoneField);

        add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        add(addressArea);

        add(new JLabel("Symptoms:"));
        symptomsArea = new JTextArea(3, 20);
        add(symptomsArea);

        add(new JLabel("Blood Group:"));
        String bgroups[] = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        bloodGroup = new JComboBox<>(bgroups);
        add(bloodGroup);

        // Buttons
        registerBtn = new JButton("Register");
        clearBtn = new JButton("Clear");
        logoutBtn = new JButton("Logout");

        add(registerBtn);
        add(clearBtn);
        add(logoutBtn);

        registerBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerBtn) {
            JOptionPane.showMessageDialog(this, "Patient Registered Successfully!");
        }

        else if (e.getSource() == clearBtn) {
            nameField.setText("");
            ageField.setText("");
            phoneField.setText("");
            addressArea.setText("");
            symptomsArea.setText("");
        }

        else if (e.getSource() == logoutBtn) {
            new LoginForm();
            dispose();
        }
    }
}

// Main Class
public class ClinicSystem {
    public static void main(String[] args) {
        new LoginForm();
    }
}