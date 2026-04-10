package classwork.Threadd;
/*Q7. Write a Java program to create a thread using
the Thread class and print numbers
from 1 to 5 with a delay of 1 second.*/

// Create thread using Thread class
class NumberThread1 extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class ThreadExample {
    public static void main(String[] args) {

        NumberThread1 t = new NumberThread1();
        t.start();  // start thread
    }
}