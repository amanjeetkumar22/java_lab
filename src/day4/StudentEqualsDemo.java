import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double cgpa;

    Student(int rollNo, String name, double cgpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student s = (Student) obj;

        return rollNo == s.rollNo &&
                name.equals(s.name) &&
                cgpa == s.cgpa;
    }
}

public class StudentEqualsDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details of Student 1:");
        System.out.print("Roll No: ");
        int r1 = sc.nextInt();
        System.out.print("Name: ");
        String n1 = sc.next();
        System.out.print("CGPA: ");
        double c1 = sc.nextDouble();

        System.out.println("\nEnter details of Student 2:");
        System.out.print("Roll No: ");
        int r2 = sc.nextInt();
        System.out.print("Name: ");
        String n2 = sc.next();
        System.out.print("CGPA: ");
        double c2 = sc.nextDouble();

        Student s1 = new Student(r1, n1, c1);
        Student s2 = new Student(r2, n2, c2);

        if (s1.equals(s2))
            System.out.println("\nBoth students are EQUAL");
        else
            System.out.println("\nBoth students are NOT equal");
    }
}
