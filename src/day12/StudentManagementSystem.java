package day12;
import java.io.*;
import java.util.*;

// Student Class
class Student implements Serializable {
    int rollNo;
    String name;
    double cgpa;

    Student(int rollNo, String name, double cgpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", CGPA: " + cgpa;
    }
}

// Main Class
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        try {
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            // Exception Handling
            if (cgpa < 0 || cgpa > 10) {
                throw new Exception("Invalid CGPA! Must be between 0 and 10.");
            }

            students.add(new Student(roll, name, cgpa));
            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    // Display Students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Find Lowest CGPA
    static void findLowestCGPA() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student min = students.get(0);

        for (Student s : students) {
            if (s.cgpa < min.cgpa) {
                min = s;
            }
        }

        System.out.println("Student with Lowest CGPA:");
        System.out.println(min);
    }

    // Search by Roll No
    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Save to File
    static void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
            oos.writeObject(students);
            oos.close();
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // Read from File
    static void readFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            students = (ArrayList<Student>) ois.readObject();
            ois.close();

            System.out.println("Data loaded from file:");
            displayStudents();

        } catch (Exception e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Find Lowest CGPA");
            System.out.println("4. Search by Roll No");
            System.out.println("5. Save to File");
            System.out.println("6. Read from File");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: findLowestCGPA(); break;
                case 4: searchStudent(); break;
                case 5: saveToFile(); break;
                case 6: readFromFile(); break;
                case 7: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}