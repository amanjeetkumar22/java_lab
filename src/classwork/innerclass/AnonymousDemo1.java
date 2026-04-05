package classwork.innerclass;
// Abstract class
abstract class Animal {
    abstract void sound();
}

public class AnonymousDemo1 {
    public static void main(String[] args) {

        // Anonymous inner class
        Animal a = new Animal() {
            void sound() {
                System.out.println("Dog barks");
            }
        };

        a.sound();
    }
}