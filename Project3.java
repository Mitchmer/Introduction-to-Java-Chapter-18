import java.util.Scanner;
public class Project3 {
    public static void main(String[] args) {
        //(Sum the digits in odd positions of an integer using recursion)

        //Write a recursive method that computes the sum of the digits in odd positions in an 
        //integer. Use the following method header:

        //public static int sumOddPositionDigits(long n)
        //In an integer, the last digit’s position is 1, the second last digit’s position 
        //is 2, and so on. For example, sumOddPositionDigits(234) returns 2 + 4 = 6. Write 
        //a test program that prompts the user to enter an integer and displays the result.

        //Sample Run

        //Enter an integer: 1231879
        //The sum of odd positions in 1231879 is 21
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long val = input.nextLong();
        System.out.println("The sum of odd positions in " + val + " is " + sumOddPositionDigits(val));

    }
 
    public static int sumOddPositionDigits(long n) {
        return sumOddPositionDigits(n, 1);
    }
    public static int sumOddPositionDigits(long n, int pos) {
        // base case
        if (n < 10) {
            if (pos % 2 != 0)
                return (int)n;
            else return 0;
        }
        // reduce and sum
        // how to reduce? peel digit

        // peel digit
        int digit = 0;
        if (pos % 2 != 0)
            digit = (int)(n % 10);

        // sum to rest
        return digit + sumOddPositionDigits(n / 10, ++pos);
    }
}
