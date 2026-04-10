//package classwork.swing;
////package classwork.swing;
//
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class UserRegistrationForm {
//    public static void main(String[] args) {
//
//        JFrame f = new JFrame("User Registration Form");
//
//        // Labels
//        JLabel l1 = new JLabel("Username:");
//        l1.setBounds(50, 50, 100, 30);
//
//        JLabel l2 = new JLabel("Email:");
//        l2.setBounds(50, 100, 100, 30);
//
//        JLabel l3 = new JLabel("Gender:");
//        l3.setBounds(50, 150, 100, 30);
//
//        JLabel l4 = new JLabel("Contact No:");
//        l4.setBounds(50, 200, 100, 30);
//
//        // TextFields
//        JTextField t1 = new JTextField();
//        t1.setBounds(150, 50, 150, 30);
//
//        JTextField t2 = new JTextField();
//        t2.setBounds(150, 100, 150, 30);
//
//        JTextField t3 = new JTextField();
//        t3.setBounds(150, 200, 150, 30);
//
//        // RadioButtons
//        JRadioButton r1 = new JRadioButton("Male");
//        r1.setBounds(150, 150, 70, 30);
//
//        JRadioButton r2 = new JRadioButton("Female");
//        r2.setBounds(220, 150, 80, 30);
//
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(r1);
//        bg.add(r2);
//
//        // Button
//        JButton b = new JButton("Submit");
//        b.setBounds(150, 250, 100, 30);
//
//        // Action Listener
//        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                String username = t1.getText();
//                String email = t2.getText();
//                String contact = t3.getText();
//
//                String gender = "";
//                if (r1.isSelected()) gender = "Male";
//                else if (r2.isSelected()) gender = "Female";
//
//                try {
//                    // Load Driver
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//
//                    // Connection
//                    Connection con = DriverManager.getConnection(
//                            "jdbc:mysql://localhost:3306/userdb", "root", "password");
//
//                    // Insert Query
//                    String query = "INSERT INTO users(username, email, gender, contact) VALUES (?, ?, ?, ?)";
//
//                    PreparedStatement pst = con.prepareStatement(query);
//                    pst.setString(1, username);
//                    pst.setString(2, email);
//                    pst.setString(3, gender);
//                    pst.setString(4, contact);
//
//                    pst.executeUpdate();
//
//                    JOptionPane.showMessageDialog(f, "Data Saved Successfully!");
//
//                    con.close();
//
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(f, ex.getMessage());
//                }
//            }
//        });
//
//        // Add components
//        f.add(l1); f.add(t1);
//        f.add(l2); f.add(t2);
//        f.add(l3); f.add(r1); f.add(r2);
//        f.add(l4); f.add(t3);
//        f.add(b);
//
//        // Frame settings
//        f.setSize(400, 350);
//        f.setLayout(null);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//    }
//}