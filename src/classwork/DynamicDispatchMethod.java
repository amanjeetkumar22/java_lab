package classwork;
//Write a program in java having four classes Fruit, Apple, Banana and Cherry.
// Class Apple,  Banana and Cherry are
//inherited from class Fruit and each class has
// its own member function show() . Using Dynamic Method Dispatch
//concept, display all the show() method of each class.
// Base class
class Fruit {
    void show() {
        System.out.println("This is a Fruit");
    }
}

// Derived class Apple
class Apple extends Fruit {
    void show() {
        System.out.println("This is an Apple");
    }
}

// Derived class Banana
class Banana extends Fruit {
    void show() {
        System.out.println("This is a Banana");
    }
}

// Derived class Cherry
class Cherry extends Fruit {
    void show() {
        System.out.println("This is a Cherry");
    }
}

// Main class
public class DynamicDispatchMethod {
    public static void main(String[] args) {

        // Reference of parent class
        Fruit f;

        // Object of Apple
        f = new Apple();
        f.show();

        // Object of Banana
        f = new Banana();
        f.show();

        // Object of Cherry
        f = new Cherry();
        f.show();
    }
}