package day1;
import java.util.Scanner;
public class StudentDetails {
     public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();

            sc.nextLine(); // consume leftover newline

            System.out.print("Enter Section: ");
            String section = sc.nextLine();

            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();

            System.out.println("\n--- Student Details ---");
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Section: " + section);
            System.out.println("Branch: " + branch);

            sc.close();
     }
}


