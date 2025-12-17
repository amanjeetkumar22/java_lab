import java.util.Scanner;

// Superclass
class Account {
    int acc_no;
    double balance;

    // Method to take input
    void input(Scanner sc) {
        System.out.print("Enter Account Number: ");
        acc_no = sc.nextInt();

        System.out.print("Enter Balance: ");
        balance = sc.nextDouble();
    }

    // Method to display details
    void disp() {
        System.out.println("Account Number : " + acc_no);
        System.out.println("Balance        : " + balance);
    }
}

// Subclass
class Person extends Account {
    String name;
    long aadhar_no;

    // Method to take input
    void input(Scanner sc) {
        System.out.print("Enter Name: ");
        sc.nextLine(); // clear buffer
        name = sc.nextLine();

        System.out.print("Enter Aadhar Number: ");
        aadhar_no = sc.nextLong();

        super.input(sc); // call Account input
    }

    // Overriding disp() method
    void disp() {
        System.out.println("Name           : " + name);
        System.out.println("Aadhar Number  : " + aadhar_no);
        System.out.println("Account Number : " + acc_no);
        System.out.println("Balance        : " + balance);
        System.out.println("----------------------------");
    }
}

// Main class
public class PersonDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Person[] p = new Person[3];

        // Input details of 3 persons
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details of person " + (i + 1));
            p[i] = new Person();
            p[i].input(sc);
        }

        // Display details
        System.out.println("\nDetails of Persons:");
        for (int i = 0; i < 3; i++) {
            p[i].disp();
        }
    }
}
