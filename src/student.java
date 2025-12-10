import java.util.*;
public class student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your roll no:");
        int roll = sc.nextInt();
        System.out.println("Enter your SECTION: ");
        String section = sc.next();
        System.out.println("Enter your BRANCH: ");
        String branch = sc.next();

        System.out.println("---student detail--:");
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Section: " + section);
        System.out.println("Branch: " + branch);

    }
}
