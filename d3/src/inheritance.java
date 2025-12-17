import java.util.Scanner;

// Base class
class Plate {
    double length, width;

    Plate(double length, double width) {
        this.length = length;
        this.width = width;
        System.out.println("\nPlate constructor called");
        System.out.println("Length = " + length + ", Width = " + width);
    }
}

// Derived class
class Box extends Plate {
    double height;

    Box(double length, double width, double height) {
        super(length, width);
        this.height = height;
        System.out.println("\nBox constructor called");
        System.out.println("Height = " + height);
    }
}

// Derived class
class WoodBox extends Box {
    double thick;

    WoodBox(double length, double width, double height, double thick) {
        super(length, width, height);
        this.thick = thick;
        System.out.println("\nWoodBox constructor called");
        System.out.println("Thickness = " + thick);
    }
}

// Main class (MATCHES FILE NAME)
public class inheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        double l = sc.nextDouble();

        System.out.print("Enter width: ");
        double w = sc.nextDouble();

        System.out.print("Enter height: ");
        double h = sc.nextDouble();

        System.out.print("Enter thickness: ");
        double t = sc.nextDouble();

        WoodBox wb = new WoodBox(l, w, h, t);
    }
}
