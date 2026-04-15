package classwork.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

// ===== BASE CLASS =====
abstract class Feature extends JPanel {
    public abstract String getName();
}

// ===== NOTEPAD =====
class NotepadPanel extends Feature {
    JTextArea textArea;

    public NotepadPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public String getName() {
        return "Notepad";
    }
}

// ===== TASK PANEL =====
class TaskPanel extends Feature {

    JPanel taskContainer;

    public TaskPanel() {
        setLayout(new BorderLayout());

        taskContainer = new JPanel();
        taskContainer.setLayout(new BoxLayout(taskContainer, BoxLayout.Y_AXIS));

        JButton addTask = new JButton("Add Task");

        addTask.addActionListener(e -> {
            String task = JOptionPane.showInputDialog("Enter Task:");

            if (task != null && !task.isEmpty()) {
                JCheckBox cb = new JCheckBox(task);

                cb.addItemListener(ev -> {
                    if (cb.isSelected()) {
                        cb.setForeground(Color.GRAY);
                    } else {
                        cb.setForeground(Color.BLACK);
                    }
                });

                taskContainer.add(cb);
                taskContainer.revalidate();
            }
        });

        add(addTask, BorderLayout.NORTH);
        add(new JScrollPane(taskContainer), BorderLayout.CENTER);
    }

    public String getName() {
        return "Tasks";
    }
}

// ===== STUDY PANEL =====
class StudyPanel extends Feature {

    int totalMinutes = 0;
    int sessions = 0;

    int currentStreak = 0;
    int bestStreak = 0;
    LocalDate lastStudyDate = null;

    JLabel totalLabel, sessionLabel, streakLabel, bestLabel;

    LocalDate currentDate = LocalDate.now();
    Map<String, Integer> studyData = new LinkedHashMap<>();

    JTextArea sessionArea;

    // 🔹 Suggestions
    public String[] generateTimeSuggestions() {
        java.util.List<String> list = new java.util.ArrayList<>();
        for (int h = 1; h <= 12; h++) {
            for (int m = 0; m < 60; m += 5) {
                String time = String.format("%02d:%02d", h, m);
                list.add(time + " AM");
                list.add(time + " PM");
            }
        }
        return list.toArray(new String[0]);
    }

    // 🔹 Convert
    public int convertToMinutes(String time) {
        try {
            String[] parts = time.split(" ");
            String[] hm = parts[0].split(":");

            int hour = Integer.parseInt(hm[0]);
            int min = Integer.parseInt(hm[1]);
            String format = parts[1];

            if (format.equals("PM") && hour != 12) hour += 12;
            if (format.equals("AM") && hour == 12) hour = 0;

            return hour * 60 + min;
        } catch (Exception e) {
            return -1;
        }
    }

    public StudyPanel() {
        setLayout(null);

        JLabel l1 = new JLabel("Entry Time:");
        l1.setBounds(50, 50, 120, 30);

        JLabel l2 = new JLabel("Exit Time:");
        l2.setBounds(50, 100, 120, 30);

        String[] timeSuggestions = generateTimeSuggestions();

        JComboBox<String> entryTime = new JComboBox<>(timeSuggestions);
        entryTime.setEditable(true);
        entryTime.setBounds(180, 50, 150, 30);

        JComboBox<String> exitTime = new JComboBox<>(timeSuggestions);
        exitTime.setEditable(true);
        exitTime.setBounds(180, 100, 150, 30);

        JButton add = new JButton("Add Session");
        add.setBounds(180, 150, 140, 30);

        JButton graphBtn = new JButton("Show Graph");
        graphBtn.setBounds(180, 200, 140, 30);

        totalLabel = new JLabel("Total: 0h");
        totalLabel.setBounds(50, 250, 200, 30);

        sessionLabel = new JLabel("Sessions: 0");
        sessionLabel.setBounds(50, 280, 200, 30);

        streakLabel = new JLabel("Streak: 0");
        streakLabel.setBounds(50, 310, 200, 30);

        bestLabel = new JLabel("Best: 0");
        bestLabel.setBounds(50, 340, 200, 30);

        // Session display
        sessionArea = new JTextArea();
        sessionArea.setEditable(false);
        JScrollPane sessionScroll = new JScrollPane(sessionArea);
        sessionScroll.setBounds(350, 50, 300, 300);

        // 🔹 ADD SESSION
        add.addActionListener(e -> {
            try {
                LocalDate today = LocalDate.now();

                // Daily reset
                if (!today.equals(currentDate)) {
                    totalMinutes = 0;
                    sessions = 0;
                    sessionArea.setText("");
                    currentDate = today;
                    JOptionPane.showMessageDialog(this, "New Day Reset!");
                }

                String entryStr = entryTime.getSelectedItem().toString();
                String exitStr = exitTime.getSelectedItem().toString();

                int inTotal = convertToMinutes(entryStr);
                int outTotal = convertToMinutes(exitStr);

                if (inTotal == -1 || outTotal == -1) {
                    JOptionPane.showMessageDialog(this, "Invalid Time Format");
                    return;
                }

                int diff = outTotal - inTotal;
                if (diff < 0) diff += 24 * 60;

                int hours = diff / 60;
                int minutes = diff % 60;

                sessionArea.append(
                        "Session " + (sessions + 1) + ": " +
                                entryStr + " → " + exitStr +
                                " = " + hours + "h " + minutes + "m\n"
                );

                totalMinutes += diff;
                sessions++;

                totalLabel.setText("Total: " + (totalMinutes / 60) + "h " + (totalMinutes % 60) + "m");
                sessionLabel.setText("Sessions: " + sessions);

                // 🔥 STREAK LOGIC
                if (lastStudyDate == null) {
                    currentStreak = 1;
                } else if (lastStudyDate.plusDays(1).equals(today)) {
                    currentStreak++;
                } else if (!lastStudyDate.equals(today)) {
                    currentStreak = 1;
                }

                if (currentStreak > bestStreak) {
                    bestStreak = currentStreak;
                }

                lastStudyDate = today;

                streakLabel.setText("Streak: " + currentStreak);
                bestLabel.setText("Best: " + bestStreak);

                studyData.put(currentDate.toString(), totalMinutes);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error");
            }
        });

        // GRAPH
        graphBtn.addActionListener(e -> {
            JFrame gFrame = new JFrame("Study Graph");
            gFrame.setSize(500, 400);

            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    int x = 50;

                    for (String date : studyData.keySet()) {
                        int minutes = studyData.get(date);
                        int height = minutes / 2;

                        g.fillRect(x, 300 - height, 40, height);
                        g.drawString(date.substring(5), x, 320);
                        g.drawString((minutes / 60) + "h", x, 290 - height);

                        x += 70;
                    }
                }
            };

            gFrame.add(panel);
            gFrame.setVisible(true);
        });

        add(l1); add(l2);
        add(entryTime); add(exitTime);
        add(add); add(graphBtn);
        add(totalLabel); add(sessionLabel);
        add(streakLabel); add(bestLabel);
        add(sessionScroll);
    }

    public String getName() {
        return "Study";
    }
}

// ===== MAIN =====
public class NotepadApp1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Smart Notepad App1");
        frame.setSize(750, 500);
        frame.setLayout(new BorderLayout());

        JPanel container = new JPanel(new CardLayout());

        Feature notepad = new NotepadPanel();
        Feature tasks = new TaskPanel();
        Feature study = new StudyPanel();

        container.add(notepad, notepad.getName());
        container.add(tasks, tasks.getName());
        container.add(study, study.getName());

        JPanel top = new JPanel();

        JButton b1 = new JButton("Notepad");
        JButton b2 = new JButton("Tasks");
        JButton b3 = new JButton("Study");

        top.add(b1); top.add(b2); top.add(b3);

        CardLayout cl = (CardLayout) container.getLayout();

        b1.addActionListener(e -> cl.show(container, "Notepad"));
        b2.addActionListener(e -> cl.show(container, "Tasks"));
        b3.addActionListener(e -> cl.show(container, "Study"));

        frame.add(top, BorderLayout.NORTH);
        frame.add(container, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}