package day2;

class Subtract {
    void sub(int a, int b) {
        System.out.println("Result = " + (a - b));
    }

    void sub(double a, double b) {
        System.out.println("Result = " + (a - b));
    }

    void sub(int a, int b, int c) {
        System.out.println("Result = " + (a - b - c));
    }
}

class SubtractDemo {
    public static void main(String[] args) {
        Subtract s = new Subtract();
        s.sub(10, 5);
        s.sub(20.5, 5.5);
        s.sub(30, 10, 5);
    }
}
