package day10;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton add, sub, mul, reset;

    CalculatorGUI() {

        setTitle("Simple Calculator");
        setSize(400,300);
        setLayout(null);

        // Labels
        l1 = new JLabel("Enter First Number");
        l1.setBounds(50,30,150,25);
        add(l1);

        l2 = new JLabel("Enter Second Number");
        l2.setBounds(50,70,150,25);
        add(l2);

        l3 = new JLabel("Result");
        l3.setBounds(50,110,150,25);
        add(l3);

        // TextFields
        t1 = new JTextField();
        t1.setBounds(200,30,120,25);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(200,70,120,25);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(200,110,120,25);
        add(t3);

        // Buttons
        add = new JButton("Add");
        sub = new JButton("Sub");
        mul = new JButton("Multiply");
        reset = new JButton("Reset");

        add.setBounds(30,170,80,30);
        sub.setBounds(120,170,80,30);
        mul.setBounds(210,170,90,30);
        reset.setBounds(310,170,80,30);

        add(add);
        add(sub);
        add(mul);
        add(reset);

        // Action Listener
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        reset.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==reset){
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        else {

            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = 0;

            if(e.getSource()==add)
                result = num1 + num2;

            if(e.getSource()==sub)
                result = num1 - num2;

            if(e.getSource()==mul)
                result = num1 * num2;

            t3.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}