import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {
        //The gcd(m, n) can also be defined recursively as follows:

        //If m % n is 0, gcd (m, n) is n.
        //Otherwise, gcd (m, n) is gcd(n, m%n).
        //Write a recursive method to find the GCD. Write a test program that prompts the 
        //user to enter two integers and displays their GCD.

        //Sample Run

        //Enter the first number: 59
        //Enter the second number: 57
        //The GCD of 59 and 57 is 1
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNum = input.nextInt();
        System.out.print("Enter the second number: ");
        int secondNum = input.nextInt();

        System.out.println("The GCD of " + firstNum + " and " + secondNum + " is " + gcd(firstNum, secondNum));

    }

    public static int gcd(int m, int n) {
        // base case
        // if m % n is 0, gcd is n
        if (m % n == 0) {
            return n;
        }
        // reduce + rest
        // how to reduce?
        return gcd(n, m % n);
        // otherwise, gcd(n, m %n)
    }
}
