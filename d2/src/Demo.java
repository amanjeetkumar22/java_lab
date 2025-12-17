import java.util.Scanner;

// Box class
class box {
    double length;
    double width;
    double height;

    // Method to calculate volume
    double volume() {
        return length * width * height;
    }
}

// Application class
public class Demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        box b = new box();

        System.out.print("Enter length: ");
        b.length = sc.nextDouble();

        System.out.print("Enter width: ");
        b.width = sc.nextDouble();

        System.out.print("Enter height: ");
        b.height = sc.nextDouble();

        double vol = b.volume();

        System.out.println("Volume of the box = " + vol);
    }
}
