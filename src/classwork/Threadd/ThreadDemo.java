package classwork.Threadd;
/*1. Write a Java program that creates two
threads (Thread 1 using Thread class and
Thread 2 using Runnable interface).

Thread 1 prints numbers from 1 to 5.

Thread 2 prints letters from A to E.*/


// Thread 1 using Thread class
class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number Thread: " + i);
        }
    }
}

// Thread 2 using Runnable interface
class LetterThread implements Runnable {
    public void run() {
        for (char ch = 'A'; ch <= 'E'; ch++) {
            System.out.println("Letter Thread: " + ch);
        }
    }
}

// Main class
public class ThreadDemo {
    public static void main(String[] args) {

        // Create Thread 1
        NumberThread t1 = new NumberThread();

        // Create Thread 2
        Thread t2 = new Thread(new LetterThread());

        // Start both threads
        t1.start();
        t2.start();
    }
}