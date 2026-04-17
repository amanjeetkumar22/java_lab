package classwork.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {

    JTextField rateField, amountField, resultField;
    JButton rateBtn, icToNcBtn, ncToIcBtn;

    double rate = 1.0;

    public CurrencyConverter() {
        setTitle("IC ↔ NC Converter");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels
        add(new JLabel("Enter Rate:"));
        rateField = new JTextField();
        add(rateField);

        add(new JLabel("Enter Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        // Buttons
        rateBtn = new JButton("Set Rate");
        icToNcBtn = new JButton("IC → NC");
        ncToIcBtn = new JButton("NC → IC");

        add(rateBtn);
        add(icToNcBtn);
        add(ncToIcBtn);

        // Action Listeners
        rateBtn.addActionListener(this);
        icToNcBtn.addActionListener(this);
        ncToIcBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == rateBtn) {
                rate = Double.parseDouble(rateField.getText());
                JOptionPane.showMessageDialog(this, "Rate set to: " + rate);
            }

            else if (e.getSource() == icToNcBtn) {
                double amount = Double.parseDouble(amountField.getText());
                double result = amount * rate;
                resultField.setText(String.valueOf(result));
            }

            else if (e.getSource() == ncToIcBtn) {
                double amount = Double.parseDouble(amountField.getText());
                double result = amount / rate;
                resultField.setText(String.valueOf(result));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}