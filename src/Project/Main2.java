package Project;
import java.util.Scanner;

import Project.HR.Manager;
import Project.General.InvalidNameException;
import Project.General.InvalidSalaryException;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter empid: ");
            int empid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter basic salary: ");
            double basic = sc.nextDouble();

            Manager m = new Manager(empid, name, basic);

            System.out.println("\nEmployee ID: " + m.getEmpid());
            System.out.println("Employee Name: " + m.getEname());
            System.out.println("Earnings: " + m.earnings());
            System.out.println("Bonus: " + m.bonus());

        } catch (InvalidNameException e) {
            System.out.println("InvalidNameException: " + e.getMessage());
        } catch (InvalidSalaryException e) {
            System.out.println("InvalidSalaryException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}