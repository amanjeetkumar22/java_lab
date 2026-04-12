package classwork.swing;
import javax.swing.*;
import java.awt.event.*;

public class NumberCheckerGUI {

    public static void main(String[] args) {

        JFrame f = new JFrame("Number Checker");

        // Label
        JLabel l = new JLabel("Enter Number:");
        l.setBounds(50, 50, 120, 30);

        // TextField
        JTextField t = new JTextField();
        t.setBounds(180, 50, 120, 30);

        // Buttons
        JButton b1 = new JButton("Odd / Even");
        b1.setBounds(50, 120, 120, 40);

        JButton b2 = new JButton("Prime Check");
        b2.setBounds(180, 120, 120, 40);

        // Result Label
        JLabel result = new JLabel("");
        result.setBounds(50, 200, 250, 30);

        // Action for Odd/Even
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(t.getText());

                    if (num % 2 == 0) {
                        result.setText("Number is Even");
                    } else {
                        result.setText("Number is Odd");
                    }

                } catch (Exception ex) {
                    result.setText("Invalid Input!");
                }
            }
        });

        // Action for Prime Check
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(t.getText());
                    boolean isPrime = true;

                    if (num <= 1) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= num / 2; i++) {
                            if (num % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        result.setText("Number is Prime");
                    } else {
                        result.setText("Number is Not Prime");
                    }

                } catch (Exception ex) {
                    result.setText("Invalid Input!");
                }
            }
        });

        // Add components
        f.add(l);
        f.add(t);
        f.add(b1);
        f.add(b2);
        f.add(result);

        // Frame settings
        f.setSize(350, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}