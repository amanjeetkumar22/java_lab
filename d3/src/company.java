import java.util.Scanner;

// 2D Sheet class
class Sheet2D {
    double length;
    double breadth;
    double cost;

    // Method to calculate cost of 2D sheet
    void calculateCost2D() {
        double area = length * breadth;
        cost = area * 40;   // Rs 40 per square ft
        System.out.println("Area of 2D Sheet = " + area + " sq.ft");
        System.out.println("Cost of 2D Sheet = Rs " + cost);
    }
}


class Box3D extends Sheet2D {
    double height;

    void calculateCost3D() {
        double volume = length * breadth * height;
        cost = volume * 60;   // Rs 60 per cubic ft
        System.out.println("Volume of 3D Box = " + volume + " cu.ft");
        System.out.println("Cost of 3D Box = Rs " + cost);
    }
}

public class company {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---- 2D Sheet ----");
        Sheet2D s = new Sheet2D();

        System.out.print("Enter length: ");
        s.length = sc.nextDouble();

        System.out.print("Enter breadth: ");
        s.breadth = sc.nextDouble();

        s.calculateCost2D();


        System.out.println("\n---- 3D Box ----");
        Box3D b = new Box3D();

        System.out.print("Enter length: ");
        b.length = sc.nextDouble();

        System.out.print("Enter breadth: ");
        b.breadth = sc.nextDouble();

        System.out.print("Enter height: ");
        b.height = sc.nextDouble();

        b.calculateCost3D();
    }
}
