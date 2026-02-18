package day9;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

class StudentFileDemo {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        // Writing to file
        FileWriter fw = new FileWriter(fileName);
        fw.write("Roll No: " + roll + "\n");
        fw.write("Name: " + name + "\n");
        fw.write("Subject: " + subject + "\n");
        fw.write("Marks: " + marks + "\n");
        fw.close();

        // Reading from file
        FileReader fr = new FileReader(fileName);
        int ch;
        System.out.println("\n--- File Content ---");
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();

        sc.close();
    }
}
