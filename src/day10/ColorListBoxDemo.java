package day10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorListBoxDemo extends JFrame implements ActionListener {

    JList<String> colorList;
    JButton changeColor;
    JPanel panel;

    ColorListBoxDemo() {

        setTitle("Color Selector");
        setSize(400,300);
        setLayout(new FlowLayout());

        // List of colors
        String colors[] = {"Red", "Green", "Blue", "Yellow"};

        colorList = new JList<>(colors);
        colorList.setVisibleRowCount(4);

        JScrollPane sp = new JScrollPane(colorList);

        changeColor = new JButton("Change Color");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,120));

        add(sp);
        add(changeColor);
        add(panel);

        changeColor.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String selectedColor = colorList.getSelectedValue();

        if(selectedColor.equals("Red"))
            panel.setBackground(Color.RED);

        else if(selectedColor.equals("Green"))
            panel.setBackground(Color.GREEN);

        else if(selectedColor.equals("Blue"))
            panel.setBackground(Color.BLUE);

        else if(selectedColor.equals("Yellow"))
            panel.setBackground(Color.YELLOW);
    }

    public static void main(String args[]) {
        new ColorListBoxDemo();
    }
}