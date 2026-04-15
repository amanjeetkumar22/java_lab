package classwork.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name;
    int id;
    double marks;

    Student(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
}

public class StudentSwingApp extends JFrame implements ActionListener {

    JTextField nameField, idField, marksField;
    JTextArea displayArea;
    JButton addButton, showButton, avgButton;

    ArrayList<Student> students = new ArrayList<>();

    StudentSwingApp() {
        setTitle("Student Management System");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input fields
        add(new JLabel("Name:"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("Marks:"));
        marksField = new JTextField(10);
        add(marksField);

        // Buttons
        addButton = new JButton("Add Student");
        showButton = new JButton("Show Students");
        avgButton = new JButton("Average Marks");

        add(addButton);
        add(showButton);
        add(avgButton);

        addButton.addActionListener(this);
        showButton.addActionListener(this);
        avgButton.addActionListener(this);

        // Display area
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                double marks = Double.parseDouble(marksField.getText());

                students.add(new Student(name, id, marks));
                displayArea.setText("Student Added Successfully!\n");

                nameField.setText("");
                idField.setText("");
                marksField.setText("");

            } catch (Exception ex) {
                displayArea.setText("Invalid input! Please enter correct data.\n");
            }
        }

        if (e.getSource() == showButton) {
            displayArea.setText("");
            for (Student s : students) {
                displayArea.append("Name: " + s.name +
                        ", ID: " + s.id +
                        ", Marks: " + s.marks + "\n");
            }
        }

        if (e.getSource() == avgButton) {
            if (students.size() == 0) {
                displayArea.setText("No students available.\n");
                return;
            }

            double sum = 0;
            for (Student s : students) {
                sum += s.marks;
            }

            double avg = sum / students.size();
            displayArea.setText("Average Marks: " + avg + "\n");
        }
    }

    public static void main(String[] args) {
        new StudentSwingApp();
    }
}