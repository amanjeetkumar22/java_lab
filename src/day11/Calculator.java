package day11;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField t;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button bAdd, bSub, bMul, bDiv, bMod, bEq, bOff;

    String num1 = "", num2 = "", op = "";

    Calculator() {
        setTitle("Calculator");
        setSize(310, 180);
        setLayout(null);
        setBackground(Color.cyan);

        Label l = new Label("CALCULATOR");
        l.setBounds(20, 30, 95, 20);
        l.setBackground(Color.white);
        l.setForeground(Color.blue);
        add(l);

        t = new TextField();
        t.setBounds(120, 30, 130, 20);
        add(t);

        b1 = new Button("1");
        b1.setBounds(20, 50, 50, 20);
        add(b1);

        b2 = new Button("2");
        b2.setBounds(70, 50, 50, 20);
        add(b2);

        b3 = new Button("3");
        b3.setBounds(120, 50, 50, 20);
        add(b3);

        bAdd = new Button("+");
        bAdd.setBounds(170, 50, 50, 20);
        add(bAdd);

        b4 = new Button("4");
        b4.setBounds(20, 70, 50, 20);
        add(b4);

        b5 = new Button("5");
        b5.setBounds(70, 70, 50, 20);
        add(b5);

        b6 = new Button("6");
        b6.setBounds(120, 70, 50, 20);
        add(b6);

        bSub = new Button("-");
        bSub.setBounds(170, 70, 50, 20);
        add(bSub);

        b7 = new Button("7");
        b7.setBounds(20, 90, 50, 20);
        add(b7);

        b8 = new Button("8");
        b8.setBounds(70, 90, 50, 20);
        add(b8);

        b9 = new Button("9");
        b9.setBounds(120, 90, 50, 20);
        add(b9);

        bMul = new Button("*");
        bMul.setBounds(170, 90, 50, 20);
        add(bMul);

        bDiv = new Button("/");
        bDiv.setBounds(20, 110, 50, 20);
        add(bDiv);

        b0 = new Button("0");
        b0.setBounds(70, 110, 50, 20);
        add(b0);

        bMod = new Button("%");
        bMod.setBounds(120, 110, 50, 20);
        add(bMod);

        bEq = new Button("=");
        bEq.setBounds(170, 110, 50, 20);
        add(bEq);

        bOff = new Button("OFF");
        bOff.setBounds(70, 130, 100, 20);
        add(bOff);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);
        bMod.addActionListener(this);
        bEq.addActionListener(this);
        bOff.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") ||
                s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") ||
                s.equals("8") || s.equals("9")) {
            t.setText(t.getText() + s);
        }
        else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")) {
            num1 = t.getText();
            op = s;
            t.setText("");
        }
        else if (s.equals("=")) {
            num2 = t.getText();

            try {
                int a = Integer.parseInt(num1);
                int b = Integer.parseInt(num2);
                int result = 0;

                if (op.equals("+"))
                    result = a + b;
                else if (op.equals("-"))
                    result = a - b;
                else if (op.equals("*"))
                    result = a * b;
                else if (op.equals("/"))
                    result = a / b;
                else if (op.equals("%"))
                    result = a % b;

                t.setText(String.valueOf(result));
            } catch (Exception ex) {
                t.setText("Error");
            }
        }
        else if (s.equals("OFF")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}