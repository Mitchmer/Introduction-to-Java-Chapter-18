import java.util.Scanner;
public class Project4 {
    public static void main(String[] args) {
        //Write a recursive method that finds the number of occurrences of a specified character 
        //in an array. You need to define the following two methods. The second one is a recursive helper method.

        //public static int count(char[] chars, char ch)
        //public static int count(char[] chars, char ch, int high)
        //Write a test program that prompts the user to enter a list of characters in one line, 
        //and a character, and displays the number of occurrences of the character in the list.

        //Sample Run

        //Enter a string: Welcome to Java
        //Enter a character: a
        //a appears 2 times
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        char[] userChars = input.nextLine().toCharArray();

        System.out.print("Enter a character: ");
        char userChar = input.next().charAt(0);

        System.out.println("" + userChar + " appears " + count(userChars, userChar) + " times");
        
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, 0);
    }
    public static int count(char[] chars, char ch, int high) {
        // base case
        // high == chars.length
        if (high == chars.length)
            return 0;

        // reduce + sum rest
        // how to reduce?
        // increment index (high)
        if (chars[high++] == ch)
            return count(chars, ch, high) + 1;
        else
            return count(chars, ch, high);
    }
}
