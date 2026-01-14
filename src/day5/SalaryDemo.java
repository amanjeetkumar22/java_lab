package day5;

import java.util.Scanner;

interface Salary {
    void earnings();
    void deductions();
    void bonus();
}

abstract class Manager implements Salary {

    double basic;

    Manager(double basic) {
        this.basic = basic;
    }

    public void earnings() {
        double earn = basic + (0.80 * basic) + (0.15 * basic);
        System.out.println("Earnings - " + earn);
    }

    public void deductions() {
        double ded = 0.12 * basic;
        System.out.println("Deduction - " + ded);
    }
}

class Substaff extends Manager {

    Substaff(double basic) {
        super(basic);
    }

    public void bonus() {
        double b = 0.50 * basic;
        System.out.println("Bonus - " + b);
    }
}

public class SalaryDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        Substaff s = new Substaff(basic);
        s.earnings();
        s.deductions();
        s.bonus();
    }
}
