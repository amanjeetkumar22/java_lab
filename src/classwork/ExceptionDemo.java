package classwork;
/// Write a Java program where following exceptions arise and
/// are handled suitably .
///     a) ArrayIndexOutOfBoundException
///     b) NullPointerException
public class ExceptionDemo {

    public static void main(String[] args) {

        // a) ArrayIndexOutOfBoundsException
        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[5]);   // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled: " + e);
        }

        // b) NullPointerException
        try {
            String str = null;
            System.out.println(str.length());   // accessing null object
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: " + e);
        }
    }
}