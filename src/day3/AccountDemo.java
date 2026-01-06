package day3;
import java.util.Scanner;

class Account {
    int acc_no;
    double balance;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        acc_no = sc.nextInt();
        System.out.print("Enter Balance: ");
        balance = sc.nextDouble();
    }

    void disp() {
        System.out.println("Account No: " + acc_no);
        System.out.println("Balance: " + balance);
    }
}

class Person extends Account {
    String name;
    long aadhar_no;

    void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Aadhar Number: ");
        aadhar_no = sc.nextLong();
    }

    void disp() {
        super.disp();
        System.out.println("Name: " + name);
        System.out.println("Aadhar No: " + aadhar_no);
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        Person[] p = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Person " + (i + 1));
            p[i] = new Person();
            p[i].input();
        }

        System.out.println("\n--- Details of Persons ---");
        for (int i = 0; i < n; i++) {
            p[i].disp();
        }
    }
}
