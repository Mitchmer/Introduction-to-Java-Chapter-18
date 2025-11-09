import java.util.Scanner;

public class Project5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Write a recursive method that converts a decimal number into a binary number as 
        //a string. The method header is:

        //public static String dec2Bin(int value)

        //Write a test program that prompts the user to enter a decimal number 
        //and displays its binary equivalent. Here are sample runs:

        //Sample Run 1

        //Enter a decimal integer: 35
        //35 decimal is binary 100011
        //Sample Run 2

        //Enter a decimal integer: 127
        //127 decimal is binary 1111111

        System.out.print("Enter a decimal integer: ");
        int decVal = input.nextInt();
        System.out.println("" + decVal + " decimal is binary " + dec2bin(decVal));
    }

    public static String dec2bin(int value) {
        // base case
        if (value / 2 == 0)
            return "" + value % 2;
        
        // peel & add to rest
        // remove digit
        return "" + dec2bin(value / 2) + (value % 2);
    }
}
