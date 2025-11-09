import java.math.BigInteger;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        //Using the BigInteger class introduced in Section 10.9, you can find the 
        //factorial for a large number (e.g., 100!). Implement the factorial method using recursion. 
        //Write a program that prompts the user to enter an integer and displays its factorial.

        //Sample Run

        //Enter an integer of any size: 35
        //Factorial of 35 is 10333147966386144929666651337523200000000

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer of any size: ");
        BigInteger userBigInt = new BigInteger(input.nextLine());
        System.out.println(bigFactorial(userBigInt));
    }

    public static BigInteger bigFactorial(BigInteger i) {
        return bigFactorial(i, BigInteger.ONE);
    }
    public static BigInteger bigFactorial(BigInteger i, BigInteger result) {
        if (i == BigInteger.ZERO) {
            return result;
        }
        // reduce + result
        // how to peel one? 
        // 3
        // 3*2*1 + 2*1 + 1*1
        return bigFactorial(i.subtract(BigInteger.ONE), i.multiply(result));
    }
}
