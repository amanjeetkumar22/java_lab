package classwork.Synchronization;
/*Design a Java program where multiple users (threads)
access a single bank account to perform deposit and withdrawal
operations. Without synchronization, the balance may become incorrect.
Your task is to implement synchronization to ensure correct balance updates.
 */
// Bank Account class
class BankAccount {
    private int balance = 1000; // initial balance

    // synchronized deposit method
    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
        balance += amount;
        System.out.println("Updated Balance after deposit: " + balance);
    }

    // synchronized withdraw method
    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Updated Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    int getBalance() {
        return balance;
    }
}

// Thread class for transactions
class UserThread extends Thread {
    BankAccount account;

    UserThread(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        account.deposit(500);
        account.withdraw(700);
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // Multiple users (threads)
        UserThread t1 = new UserThread(account, "User-1");
        UserThread t2 = new UserThread(account, "User-2");

        t1.start();
        t2.start();
    }
}