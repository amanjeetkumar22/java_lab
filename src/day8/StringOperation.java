package day8;

import java.util.Scanner;

public class StringOperation{
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n----- STRING OPERATIONS MENU -----");
                System.out.println("1. Change case of string");
                System.out.println("2. Reverse the string");
                System.out.println("3. Compare two strings");
                System.out.println("4. Insert one string into another");
                System.out.println("5. Convert to upper and lower case");
                System.out.println("6. Check character position in string");
                System.out.println("7. Check palindrome");
                System.out.println("8. Count words, vowels and consonants");
                System.out.println("9. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {


                    case 1:
                        System.out.print("Enter a String: ");
                        String s1 = sc.nextLine();
                        System.out.println("After changing case: " + s1.toUpperCase());
                        break;
                    case 2:
                        System.out.print("Enter a String: ");
                        String s2 = sc.nextLine();
                        String rev = "";
                        for (int i = s2.length() - 1; i >= 0; i--) {
                            rev += s2.charAt(i);
                        }
                        System.out.println("Reversed string: " + rev);
                        break;
                    case 3:
                        System.out.print("Enter first string: ");
                        String a = sc.nextLine();
                        System.out.print("Enter second string: ");
                        String b = sc.nextLine();
                        int diff = a.compareTo(b);
                        System.out.println("Difference between ASCII value is: " + diff);
                        break;
                    case 4:
                        System.out.print("Enter first string: ");
                        String mainStr = sc.nextLine();
                        System.out.print("Enter string to insert: ");
                        String ins = sc.nextLine();
                        System.out.println("After insertion: " + mainStr + " " + ins);
                        break;
                    case 5:
                        System.out.print("Enter a String: ");
                        String s5 = sc.nextLine();
                        System.out.println("Uppercase: " + s5.toUpperCase());
                        System.out.println("Lowercase: " + s5.toLowerCase());
                        break;
                    case 6:
                        System.out.print("Enter a String: ");
                        String s6 = sc.nextLine();
                        System.out.print("Enter a character: ");
                        char ch = sc.next().charAt(0);
                        int pos = s6.indexOf(ch);
                        if (pos != -1)
                            System.out.println("Position of entered character: " + pos);
                        else
                            System.out.println("Entered character is not present");
                        break;
                    case 7:
                        System.out.print("Enter a String: ");
                        String s7 = sc.nextLine();
                        String r = "";
                        for (int i = s7.length() - 1; i >= 0; i--) {
                            r += s7.charAt(i);
                        }
                        if (s7.equalsIgnoreCase(r))
                            System.out.println("Entered string is palindrome");
                        else
                            System.out.println("Entered string is not a palindrome");
                        break;
                    case 8:
                        System.out.print("Enter a String: ");
                        String s8 = sc.nextLine().toLowerCase();

                        int vowels = 0, consonants = 0;
                        String[] words = s8.trim().split("\\s+");

                        for (int i = 0; i < s8.length(); i++) {
                            char c = s8.charAt(i);
                            if (c >= 'a' && c <= 'z') {
                                if ("aeiou".indexOf(c) != -1)
                                    vowels++;
                                else
                                    consonants++;
                            }
                        }

                        System.out.println("No. of words: " + words.length);
                        System.out.println("No. of vowels: " + vowels);
                        System.out.println("No. of consonants: " + consonants);
                        break;
                    case 9:
                        System.out.println("Program exited.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 9);
    }
}

