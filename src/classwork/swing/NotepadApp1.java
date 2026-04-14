package classwork.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp1 {

    public static void main(String[] args) {

        JFrame f = new JFrame("Smart Notepad");

        // ===== TEXT AREA =====
        JTextArea textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(10, 50, 560, 380);

        // ===== TASK PANEL =====
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

        JScrollPane taskScroll = new JScrollPane(taskPanel);
        taskScroll.setBounds(10, 50, 560, 380);
        taskScroll.setVisible(false);

        // ===== MODE BUTTONS =====
        JButton noteMode = new JButton("Notepad");
        noteMode.setBounds(10, 10, 100, 30);

        JButton taskMode = new JButton("Task");
        taskMode.setBounds(120, 10, 100, 30);

        JButton addTask = new JButton("Add Task");
        addTask.setBounds(230, 10, 100, 30);
        addTask.setVisible(false);

        // ===== MENU BAR =====
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(exit);

        mb.add(file);
        f.setJMenuBar(mb);

        // ===== FILE OPERATIONS =====

        // NEW
        newFile.addActionListener(e -> {
            textArea.setText("");
            taskPanel.removeAll();
            taskPanel.revalidate();
            taskPanel.repaint();
        });

        // OPEN
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(f);

            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fc.getSelectedFile();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file1));
                    textArea.read(br, null);
                    br.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Error opening file");
                }
            }
        });

        // SAVE
        save.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int i = fc.showSaveDialog(f);

            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fc.getSelectedFile();

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                    textArea.write(bw);
                    bw.close();
                    JOptionPane.showMessageDialog(f, "Saved Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Error saving file");
                }
            }
        });

        // EXIT
        exit.addActionListener(e -> System.exit(0));

        // ===== MODE SWITCHING =====

        noteMode.addActionListener(e -> {
            scroll.setVisible(true);
            taskScroll.setVisible(false);
            addTask.setVisible(false);
        });

        taskMode.addActionListener(e -> {
            scroll.setVisible(false);
            taskScroll.setVisible(true);
            addTask.setVisible(true);
        });

        // ===== ADD TASK =====
        addTask.addActionListener(e -> {
            String taskText = JOptionPane.showInputDialog(f, "Enter Task:");

            if (taskText != null && !taskText.isEmpty()) {

                JCheckBox checkBox = new JCheckBox(taskText);

                checkBox.addItemListener(ev -> {
                    if (checkBox.isSelected()) {
                        checkBox.setForeground(Color.GRAY); // dim
                    } else {
                        checkBox.setForeground(Color.BLACK);
                    }
                });

                taskPanel.add(checkBox);
                taskPanel.revalidate();
            }
        });

        // ===== AUTO SAVE =====
        Timer autoSave = new Timer(5000, e -> {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("autosave.txt"));
                textArea.write(bw);
                bw.close();
                System.out.println("Auto-saved...");
            } catch (Exception ex) {
                System.out.println("Auto-save error");
            }
        });
        autoSave.start();

        // ===== ADD COMPONENTS =====
        f.add(noteMode);
        f.add(taskMode);
        f.add(addTask);

        f.add(scroll);
        f.add(taskScroll);

        // ===== FRAME SETTINGS =====
        f.setSize(600, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}