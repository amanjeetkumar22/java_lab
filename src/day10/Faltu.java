package day10;
class Faltu {

    private static final int CAPACITY = 5;
    private final java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == CAPACITY) {
                    wait();
                }

                System.out.println("Produced: " + value);
                queue.add(value++);
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }

                int val = queue.poll();
                System.out.println("Consumed: " + val);
                notify();
                Thread.sleep(500);
            }
        }
    }
}