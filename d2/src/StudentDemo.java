import java.util.Scanner;

class Student {
    int roll;
    String name;
    double cgpa;

    // Method to take input
    void input(Scanner sc) {
        System.out.print("Enter Roll No: ");
        roll = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter CGPA: ");
        cgpa = sc.nextDouble();
    }

    // Method to display details
    void display() {
        System.out.println("Roll No: " + roll);
        System.out.println("Name   : " + name);
        System.out.println("CGPA   : " + cgpa);
        System.out.println("----------------------");
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] s = new Student[n];

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));
            s[i] = new Student();
            s[i].input(sc);
        }

        // Display student details
        System.out.println("\nStudent Details:");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }

        // Find student with lowest CGPA
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (s[i].cgpa < s[minIndex].cgpa) {
                minIndex = i;
            }
        }

        System.out.println("Student with lowest CGPA:");
        System.out.println("Name: " + s[minIndex].name);
        System.out.println("CGPA: " + s[minIndex].cgpa);
    }
}
