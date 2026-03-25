package day12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main Class
public class ThreadedCalculator extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton square, sqrt, power, mod, log;

    ThreadedCalculator() {

        setTitle("Threaded Calculator 24051155 ");
        setSize(400, 300);
        setLayout(null);
        getContentPane().setBackground(Color.pink);

        // Input Fields
        t1 = new JTextField();
        t1.setBounds(50, 30, 120, 30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(200, 30, 120, 30);
        add(t2);

        // Result Field
        result = new JTextField();
        result.setBounds(50, 80, 270, 30);
        result.setEditable(false);
        add(result);

        // Buttons
        square = new JButton("x²");
        square.setBounds(50, 130, 80, 30);

        sqrt = new JButton("√x");
        sqrt.setBounds(150, 130, 80, 30);

        power = new JButton("xʸ");
        power.setBounds(250, 130, 80, 30);

        mod = new JButton("%");
        mod.setBounds(80, 180, 80, 30);

        log = new JButton("Log");
        log.setBounds(200, 180, 80, 30);

        add(square);
        add(sqrt);
        add(power);
        add(mod);
        add(log);

        // Action Listeners
        square.addActionListener(this);
        sqrt.addActionListener(this);
        power.addActionListener(this);
        mod.addActionListener(this);
        log.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Multithreading Logic
    public void performOperation(String operation) {

        Thread t = new Thread(() -> {
            try {
                result.setText("Processing...");
                Thread.sleep(1000); // simulate delay

                double num1 = Double.parseDouble(t1.getText());
                double num2 = t2.getText().isEmpty() ? 0 : Double.parseDouble(t2.getText());

                double res = 0;

                switch (operation) {
                    case "square":
                        res = num1 * num1;
                        break;

                    case "sqrt":
                        res = Math.sqrt(num1);
                        break;

                    case "power":
                        res = Math.pow(num1, num2);
                        break;

                    case "mod":
                        res = num1 % num2;
                        break;

                    case "log":
                        res = Math.log(num1);
                        break;
                }

                result.setText(String.valueOf(res));

            } catch (Exception e) {
                result.setText("Error!");
            }
        });

        t.start(); // start thread
    }

    // Button Click Handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == square)
            performOperation("square");

        else if (e.getSource() == sqrt)
            performOperation("sqrt");

        else if (e.getSource() == power)
            performOperation("power");

        else if (e.getSource() == mod)
            performOperation("mod");

        else if (e.getSource() == log)
            performOperation("log");
    }

    public static void main(String[] args) {
        new ThreadedCalculator();
    }
}
