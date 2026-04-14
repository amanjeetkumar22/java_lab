//package classwork.swing;
//import javax.swing.*;
//import java.awt.event.*;
//import java.io.*;
//
//public class NotepadApp {
//
//    public static void main(String[] args) {
//
//        JFrame f = new JFrame("Notepad");
//
//        // Text Area
//        JTextArea textArea = new JTextArea();
//        JScrollPane scroll = new JScrollPane(textArea);
//        f.add(scroll);
//
//        // Menu Bar
//        JMenuBar mb = new JMenuBar();
//
//        // Menu
//        JMenu file = new JMenu("File");
//
//        // Menu Items
//        JMenuItem newFile = new JMenuItem("New");
//        JMenuItem open = new JMenuItem("Open");
//        JMenuItem save = new JMenuItem("Save");
//        JMenuItem exit = new JMenuItem("Exit");
//
//        file.add(newFile);
//        file.add(open);
//        file.add(save);
//        file.add(exit);
//
//        mb.add(file);
//        f.setJMenuBar(mb);
//
//        // NEW
//        newFile.addActionListener(e -> textArea.setText(""));
//
//        // OPEN
//        open.addActionListener(e -> {
//            JFileChooser fc = new JFileChooser();
//            int i = fc.showOpenDialog(f);
//
//            if (i == JFileChooser.APPROVE_OPTION) {
//                File file1 = fc.getSelectedFile();
//
//                try {
//                    BufferedReader br = new BufferedReader(new FileReader(file1));
//                    textArea.read(br, null);
//                    br.close();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(f, "Error opening file");
//                }
//            }
//        });
//
//        // SAVE
//        save.addActionListener(e -> {
//            JFileChooser fc = new JFileChooser();
//            int i = fc.showSaveDialog(f);
//
//            if (i == JFileChooser.APPROVE_OPTION) {
//                File file1 = fc.getSelectedFile();
//
//                try {
//                    BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
//                    textArea.write(bw);
//                    bw.close();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(f, "Error saving file");
//                }
//            }
//        });
//
//        // EXIT
//        exit.addActionListener(e -> System.exit(0));
//
//        // Frame settings
//        f.setSize(600, 500);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//    }
//}