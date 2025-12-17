import java.util.Scanner;

class Rectangle {
    double length;
    double breadth;

    // Default constructor
    Rectangle() {
        length = 0;
        breadth = 0;
    }

    // Parameterized constructor
    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    // Method to calculate area
    double area() {
        return length * breadth;
    }
}

public class RectangleDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Object using default constructor
        Rectangle r1 = new Rectangle();
        System.out.println("Area using default constructor = " + r1.area());

        // User input
        System.out.print("Enter length: ");
        double l = sc.nextDouble();

        System.out.print("Enter breadth: ");
        double b = sc.nextDouble();

        // Object using parameterized constructor
        Rectangle r2 = new Rectangle(l, b);
        System.out.println("Area using parameterized constructor = " + r2.area());
    }
}
