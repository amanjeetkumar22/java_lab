import java.awt.*;
import java.awt.event.*;

public class StringGUI extends Frame implements ActionListener
{
    Label l1, l2;
    TextField t1, t2;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    StringGUI()
    {
        setTitle("My Frame");
        setSize(800, 500);
        setLayout(null);
        setBackground(new Color(240, 170, 170));

        l1 = new Label("Enter the string:");
        l1.setBounds(70, 140, 120, 25);
        add(l1);

        t1 = new TextField();
        t1.setBounds(230, 140, 250, 25);
        add(t1);

        l2 = new Label("Result:");
        l2.setBounds(70, 180, 120, 25);
        add(l2);

        t2 = new TextField();
        t2.setBounds(230, 180, 250, 25);
        add(t2);

        b1 = new Button("IN CAPS");
        b1.setBounds(45, 325, 70, 22);
        add(b1);

        b2 = new Button("IN SMALL");
        b2.setBounds(180, 325, 70, 22);
        add(b2);

        b3 = new Button("CONVERT CASE");
        b3.setBounds(310, 325, 105, 22);
        add(b3);

        b4 = new Button("WORDS");
        b4.setBounds(495, 325, 55, 22);
        add(b4);

        b5 = new Button("LETTERS");
        b5.setBounds(620, 325, 75, 22);
        add(b5);

        b6 = new Button("REVERSE");
        b6.setBounds(100, 350, 80, 22);
        add(b6);

        b7 = new Button("VOWELS");
        b7.setBounds(235, 350, 80, 22);
        add(b7);

        b8 = new Button("FREQUENCY");
        b8.setBounds(400, 350, 95, 22);
        add(b8);

        b9 = new Button("BEGIN CAPS");
        b9.setBounds(540, 350, 95, 22);
        add(b9);

        b10 = new Button("RESET");
        b10.setBounds(335, 410, 80, 25);
        b10.setBackground(Color.blue);
        b10.setForeground(Color.white);
        add(b10);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = t1.getText();

        if (e.getSource() == b1)
        {
            t2.setText(s.toUpperCase());
        }
        else if (e.getSource() == b2)
        {
            t2.setText(s.toLowerCase());
        }
        else if (e.getSource() == b3)
        {
            String result = "";
            for (int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch))
                    result = result + Character.toLowerCase(ch);
                else if (Character.isLowerCase(ch))
                    result = result + Character.toUpperCase(ch);
                else
                    result = result + ch;
            }
            t2.setText(result);
        }
        else if (e.getSource() == b4)
        {
            String str = s.trim();
            if (str.length() == 0)
                t2.setText("0");
            else
            {
                String words[] = str.split("\\s+");
                t2.setText(String.valueOf(words.length));
            }
        }
        else if (e.getSource() == b5)
        {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) != ' ')
                    count++;
            }
            t2.setText(String.valueOf(count));
        }
        else if (e.getSource() == b6)
        {
            String rev = "";
            for (int i = s.length() - 1; i >= 0; i--)
            {
                rev = rev + s.charAt(i);
            }
            t2.setText(rev);
        }
        else if (e.getSource() == b7)
        {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
            {
                char ch = Character.toLowerCase(s.charAt(i));
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    count++;
            }
            t2.setText(String.valueOf(count));
        }
        else if (e.getSource() == b8)
        {
            int freq[] = new int[256];
            for (int i = 0; i < s.length(); i++)
            {
                freq[s.charAt(i)]++;
            }

            String result = "";
            boolean visited[] = new boolean[256];

            for (int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i);
                if (!visited[ch] && ch != ' ')
                {
                    result = result + ch + ":" + freq[ch] + " ";
                    visited[ch] = true;
                }
            }
            t2.setText(result);
        }
        else if (e.getSource() == b9)
        {
            String words[] = s.toLowerCase().split("\\s+");
            String result = "";

            for (int i = 0; i < words.length; i++)
            {
                if (words[i].length() > 0)
                {
                    result = result + Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
                    if (i != words.length - 1)
                        result = result + " ";
                }
            }
            t2.setText(result);
        }
        else if (e.getSource() == b10)
        {
            t1.setText("");
            t2.setText("");
        }
    }

    public static void main(String args[])
    {
        new StringGUI();
    }
}