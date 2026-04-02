package classwork.innerclass;
import javax.swing.*;
import java.awt.event.*;

public class ButtonDemo {
    public static void main(String[] args) {

        JFrame f = new JFrame("Anonymous Class Demo");
        JButton b = new JButton("Click Me");

        b.setBounds(100, 100, 120, 40);

        // Anonymous Inner Class for event handling
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        f.add(b);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
}