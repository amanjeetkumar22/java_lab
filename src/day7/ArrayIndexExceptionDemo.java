package day7;
import java.util.Scanner;

public class ArrayIndexExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];   // size is 4

        try {
            System.out.println("Enter 5 numbers:");
            for (int i = 0; i < 5; i++) {   // causes exception
                arr[i] = sc.nextInt();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}