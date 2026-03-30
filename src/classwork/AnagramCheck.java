package classwork;
/// Checking for Anagrams between two strings (Ex: worth and throw)
import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {

        String s1 = "worth";
        String s2 = "throw";

        // Convert to lowercase (optional for case-insensitive check)
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        // Convert strings to char arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Strings are Anagrams");
        } else {
            System.out.println("Strings are NOT Anagrams");
        }
    }
}