package day10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RGBColorDemo extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JComboBox<Integer> redBox, greenBox, blueBox;
    JButton show;
    JPanel panel;

    RGBColorDemo() {

        setTitle("RGB Color Selector");
        setSize(400,300);
        setLayout(null);

        // Labels
        l1 = new JLabel("Red");
        l1.setBounds(50,30,50,25);
        add(l1);

        l2 = new JLabel("Green");
        l2.setBounds(50,70,50,25);
        add(l2);

        l3 = new JLabel("Blue");
        l3.setBounds(50,110,50,25);
        add(l3);

        // ComboBox values (0–255)
        Integer values[] = new Integer[256];
        for(int i=0; i<256; i++) {
            values[i] = i;
        }

        redBox = new JComboBox<>(values);
        redBox.setBounds(120,30,80,25);
        add(redBox);

        greenBox = new JComboBox<>(values);
        greenBox.setBounds(120,70,80,25);
        add(greenBox);

        blueBox = new JComboBox<>(values);
        blueBox.setBounds(120,110,80,25);
        add(blueBox);

        // Button
        show = new JButton("Show Output");
        show.setBounds(100,150,150,30);
        add(show);

        // Panel
        panel = new JPanel();
        panel.setBounds(50,200,250,50);
        panel.setBackground(Color.WHITE);
        add(panel);

        show.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        int r = (int) redBox.getSelectedItem();
        int g = (int) greenBox.getSelectedItem();
        int b = (int) blueBox.getSelectedItem();

        Color color = new Color(r, g, b);
        panel.setBackground(color);
    }

    public static void main(String[] args) {
        new RGBColorDemo();
    }
}