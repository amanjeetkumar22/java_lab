package classwork.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcSimple extends JFrame implements ActionListener {

    JTextField t;
    double n1, n2;
    String op;

    CalcSimple() {
        t = new JTextField();
        add(t, BorderLayout.NORTH);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));

        String b[] = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0","C","=","+"
        };

        for(String x : b) {
            JButton bt = new JButton(x);
            bt.addActionListener(this);
            p.add(bt);
        }

        add(p);
        setSize(250,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.matches("[0-9]")) {
            t.setText(t.getText() + s);
        }
        else if(s.equals("C")) {
            t.setText("");
        }
        else if(s.equals("=")) {
            n2 = Double.parseDouble(t.getText());

            if(op.equals("+")) t.setText("" + (n1+n2));
            if(op.equals("-")) t.setText("" + (n1-n2));
            if(op.equals("*")) t.setText("" + (n1*n2));
            if(op.equals("/")) t.setText("" + (n1/n2));
        }
        else {
            n1 = Double.parseDouble(t.getText());
            op = s;
            t.setText("");
        }
    }

    public static void main(String[] args) {
        new CalcSimple();
    }
}