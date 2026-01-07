package day2;
import java.util.Scanner;

class Box {
    double length, width, height;

    void volume() {
        double vol = length * width * height;
        System.out.println("Volume of Box = " + vol);
    }
}

class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Box b = new Box();

        System.out.print("Enter length: ");
        b.length = sc.nextDouble();

        System.out.print("Enter width: ");
        b.width = sc.nextDouble();

        System.out.print("Enter height: ");
        b.height = sc.nextDouble();

        b.volume();
    }
}
