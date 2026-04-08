package classwork.Threadd;

//WITH 1 SEC PAUSE

// Thread 1 using Thread class
class NumberThread2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number Thread: " + i);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Thread 2 using Runnable interface
class LetterThread2 implements Runnable {
    public void run() {
        for (char ch = 'A'; ch <= 'E'; ch++) {
            System.out.println("Letter Thread: " + ch);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Main class
public class ThreadDemo2 {
    public static void main(String[] args) {

        NumberThread2 t1 = new NumberThread2();
        Thread t2 = new Thread(new LetterThread2());

        t1.start();
        t2.start();
    }
}