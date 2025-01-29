import java.util.*;

public class CAESARCIPHER {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Caesar Cipher Generator!");
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the shift value: ");
        int shift = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Encrypted Text: " + encrypt(text, shift));
                break;
            case 2:
                System.out.println("Decrypted Text: " + decrypt(text, shift));
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}

