package classwork.innerclass;
// Interface
interface Greeting {
    void sayHello();
}

public class AnonymousDemo2 {
    public static void main(String[] args) {

        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello, welcome!");
            }
        };

        g.sayHello();
    }
}