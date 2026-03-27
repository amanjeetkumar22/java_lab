package classwork;

// Define interface
interface Motor {
    int capacity = 5;   // data member (public, static, final by default)

    void run();         // abstract method
    void consume();     // abstract method
}

// Define class implementing interface
class WashingMachine implements Motor {

    // Implement run()
    public void run() {
        System.out.println("Washing machine is running");
    }

    // Implement consume()
    public void consume() {
        System.out.println("Washing machine is consuming power");
    }
}

// Main class
public class InterfaceDemo {
    public static void main(String[] args) {

        WashingMachine wm = new WashingMachine();

        // Calling methods
        wm.run();
        wm.consume();

        // Accessing interface data member through object
        System.out.println("Capacity of the motor is " + wm.capacity);
    }
}