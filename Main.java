import java.util.Scanner;

/**
 * Created by Benjamin Ehlers on 2/24/2019.
 */
public class Main {

    private static String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        String input;
        System.out.println("Enter a number to calculate its Additive Persistence");
        System.out.println("Enter '!' to quit.");
        while(true) {
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            if(input.equals("!")) break;
            System.out.println(input + " => " + base10tobase62(Integer.parseInt(input)));
        }
    }

    private static String base10tobase62(int input) {
        String result = "";
        int inputDiv = input;
        int inputDivActual = input;
        while (true) {
            int numDivides = 0;
            while (inputDiv > 62 && inputDiv != 0) {
                inputDiv = inputDiv / 62;
                numDivides++;
            }
            result += alphabet.charAt(inputDiv);
            inputDivActual = inputDivActual - ((int) Math.pow(62, numDivides) * inputDiv);
            inputDiv = inputDivActual;
            if (inputDiv == 0) break;
        }
        return result;
    }
}