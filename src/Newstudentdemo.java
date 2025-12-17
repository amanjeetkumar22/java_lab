import java.util.Scanner;

class Student {
    int rollno;
    String name;
    String section;
    String branch;

    // Parameterized constructor
    Student(int rollno, String name, String section, String branch) {
        this.rollno = rollno;
        this.name = name;
        this.section = section;
        this.branch = branch;
    }

    // Method to display student details
    void getStudentDetails() {
        System.out.println("Student Name   : " + name);
        System.out.println("Roll No        : " + rollno);
        System.out.println("Section        : " + section);
        System.out.println("Branch         : " + branch);
    }
}

public class Newstudentdemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input order changed as requested
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        int rollno = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Section: ");
        String section = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        Student st = new Student(rollno, name, section, branch);
        st.getStudentDetails();
    }
}
