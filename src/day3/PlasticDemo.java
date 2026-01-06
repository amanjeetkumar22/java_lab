package day3;

import java.util.Scanner;

class Plastic2D {
    double length, width;

    void input2D() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        length = sc.nextDouble();
        System.out.print("Enter width: ");
        width = sc.nextDouble();
    }

    double cost2D() {
        double area = length * width;
        return area * 40;
    }
}

class Plastic3D extends Plastic2D {
    double height;

    void input3D() {
        input2D();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    double cost3D() {
        double volume = length * width * height;
        return volume * 60;
    }
}

public class PlasticDemo {
    public static void main(String[] args) {
        Plastic3D obj = new Plastic3D();
        obj.input3D();

        System.out.println("Cost of Plastic Sheet: Rs " + obj.cost2D());
        System.out.println("Cost of Plastic Box: Rs " + obj.cost3D());
    }
}

