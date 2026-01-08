package day4;

import java.util.Scanner;

// Abstract class
abstract class Student {
    int rollNo;
    long regNo;

    void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rollno: ");
        rollNo = sc.nextInt();

        System.out.print("Enter Registration no: ");
        regNo = sc.nextLong();
    }

    abstract void course();
}

// Subclass
class Kiitian extends Student {

    void course() {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }

    void display() {
        System.out.println("Rollno - " + rollNo);
        System.out.println("Registration no - " + regNo);
        course();
    }
}

// Driver class
class AbstractDemo {
    public static void main(String[] args) {
        Kiitian k = new Kiitian();
        k.getInput();
        k.display();
    }
}
