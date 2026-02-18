package day7;
import java.util.Scanner;

// User-defined exceptions
class InvalidHourException extends Exception {
    InvalidHourException(String msg) {
        super(msg);
    }
}

class InvalidMinuteException extends Exception {
    InvalidMinuteException(String msg) {
        super(msg);
    }
}

class InvalidSecondException extends Exception {
    InvalidSecondException(String msg) {
        super(msg);
    }
}

class Time {
    int h, m, s;

    void getTime() throws InvalidHourException,
            InvalidMinuteException,
            InvalidSecondException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hours: ");
        h = sc.nextInt();
        if (h < 0 || h > 24)
            throw new InvalidHourException("hour is not greater than 24");

        System.out.print("Enter minutes: ");
        m = sc.nextInt();
        if (m < 0 || m > 60)
            throw new InvalidMinuteException("minute is not greater than 60");

        System.out.print("Enter seconds: ");
        s = sc.nextInt();
        if (s < 0 || s > 60)
            throw new InvalidSecondException("second is not greater than 60");

        System.out.println("Correct Time-> " + h + ":" + m + ":" + s);
    }
}

public class TimeExceptionDemo {
    public static void main(String[] args) {

        Time t = new Time();

        try {
            t.getTime();
        } catch (Exception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + e);
        }
    }
}
