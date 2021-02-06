import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    private static final Scanner keyboard = new Scanner(System.in);

    public static String encrypt(String stringToEncrypt, int key) {
        String encryptedString = "";
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            char letter = (char)(stringToEncrypt.charAt(i) + key);
            encryptedString += letter;
        }
        return encryptedString;
    }

    public static String decrypt(String stringToDecrypt, int key) {
        String encryptedString = "";
        for (int i = 0; i < stringToDecrypt.length(); i++) {
            char letter = (char)(stringToDecrypt.charAt(i) - key);
            encryptedString += letter;
        }
        return encryptedString;
    }

    public static double sum(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static boolean arrayContains(double[] numbers, double searchValue) {
        for (int i = 0;i < numbers.length; ++i) {
            if (numbers[i]==searchValue) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Enter a string to encrypt: ");
        String stringToEncrypt = keyboard.next();
        System.out.println("What value do you want to encrypt with? ");
        int key = 0;
            try {
                 key = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You've entered invalid integer. Using default value of 0.");
                keyboard.next();
            }
        String encryptedString = encrypt(stringToEncrypt, key);
        System.out.println(stringToEncrypt+" encrypted is "+encryptedString);
        String decryptedString = decrypt(encryptedString, key);
        System.out.println("Using "+encryptedString+" to test the decryption with "+key+"...");
        System.out.println("The decrypted string is "+decryptedString);
        System.out.println("=========================================");
        System.out.println("Enter the number of elements: ");
        int numOfElement = 10;
        try {
            numOfElement = keyboard.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid Input");
            System.out.println("Using default value of "+numOfElement);
            keyboard.next();
        }

        double[] numbers = new double[numOfElement];
        System.out.println("Enter "+numOfElement+" elements");
        try {
            for (int i = 0;i < numbers.length;i++) {
                numbers[i] = keyboard.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            keyboard.next();
        }

        System.out.println("The sum of the given elements is: "+sum(numbers));
        System.out.println("Enter a number to search for in the previous array: ");
        double searchValue = Math.random();
        try {
             searchValue = keyboard.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Using random value.");
            keyboard.next();
        }

        if (arrayContains(numbers, searchValue)) {
            System.out.println("The array contains "+searchValue);
        } else {
            System.out.println("The array does not contain "+searchValue);
        }


    }
}
