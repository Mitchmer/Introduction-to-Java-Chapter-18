import java.util.Scanner;
// Quizzes on recursion

public class RecursiveQuizzes {
    public static void main(String[] args) {

        System.out.println("==== compressString ====");
        String param = "aaaabaaaabaaa";
        System.out.println(compressString(param));

        //System.out.println("==== findHighestResponse ====");
        //Scanner input = new Scanner(System.in);
        //System.out.println(Integer.valueOf(findHighestResponse(input)));

        System.out.println("==== reverseString ====");
        param = "please reverse";
        System.out.println(reverseString(param));

        System.out.println("==== findPattern ====");
        System.out.println(findPattern("there is no pattern in this one"));
        System.out.println(findPattern("there is DBD pattern in this one"));

        System.out.println("==== calculatePower ====");
        System.out.println(calculatePower(2, 8));
        System.out.println(calculatePower(4, -5));

        System.out.println("==== findMinimum ====");
        int[] intArr1 = {21, 3, 14, 1, 5};
        System.out.println(findMinimum(intArr1, 0, intArr1.length - 1));
        int[] intArr2 = {-11, 64, 9, 0, 22, -4};
        System.out.println(findMinimum(intArr2, 0, intArr2.length - 1));

        System.out.println("==== calculateAverage ====");
        System.out.println(calculateAverage(intArr1));
        

    }

    public static String compressString(String str) {
    // base case
    // length == 0
        if (str.length() > 1) {
            // check first char
            // if ((Character(str.charAt(1)).isDigit())
            //     // if it's a number, skip
            //     return str.substring(0, 1).concat(compressString(str.substring(1)))
            // check char at index 1
            if (str.charAt(0) == str.charAt(1)) {
                // if it's the same as the first, it's a repeat.
                    // replace with '1'
                char[] strToChar = str.toCharArray();
                char newNum = 50; // '2'
                strToChar[1] = newNum;
                    // call fcn w/ same string
                return compressString(new String(strToChar));
            }
            else if (str.length() > 2) {
                if (Character.isDigit(str.charAt(1))) {
                    // if it's a number, check char at index 2
                    if (str.charAt(0) == str.charAt(2)) {
                        // if it's same as the first, it's a repeat.
                        // replace char at index 1 with char(number(char at index 1) + 1)
                        char[] strToChar = str.toCharArray();
                        int repeatNum = strToChar[1] - 48; // '2' - 48 = 2
                        repeatNum += 1;
                        strToChar[1] = (char)(repeatNum + 48); // 3 + 48 = '3'
                        String newString = new String(strToChar);
                        // call fcn with same string, minus the repeated character
                        return compressString(newString.substring(0, 2).concat(newString.substring(3)));
                    }
                    else return str.substring(0, 2).concat(compressString(str.substring(2)));
                } 
                else 
                    return str.substring(0, 1).concat(compressString(str.substring(1))); // otherwise, peel first character and call with reduced string
                // otherwise, str[1] is not a digit and it's not a repeat, so strip first character
            }
            // otherwise, str[1] is not a repeat, and str has less <= 2 characters, so just return
            //else {
            //    return str.substring(0, 1).concat(compressString(str.substring(1))); // otherwise, peel first character and call with reduced string
            //}
        }
        return str;
    }

    //Assignment: Implement a public method named countPositive that accepts a Scanner object 
    //linked to a stream of integer inputs. This method should recursively count and return the number 
    //of positive integers entered. The method should consume all the input integers available.

    //For example, if the user inputs 5 -3 8 0, the method returns 2.

    //The method should not use loops (for, while, do-while) to perform its task, showcasing recursion 
    //as a viable alternative for iterative processes.

    //Note: Assume the stream has at least one number.
    public static int countPositive(Scanner input) {
        // base case
        if (!input.hasNext()) {
            return 0;
        } else {
            // reduction + rest
            if (input.nextInt() > 0) {
                return 1 + countPositive(input);
            } else
                return countPositive(input);
        }
    }

    //Assignment: In a software system designed to analyze survey responses, where responses are 
    //quantified as integer values, it's crucial to identify the most frequent or emphasized 
    //response for a set of data. However, instead of finding the most frequent response, you're 
    //tasked with identifying the highest response value provided, using recursion to navigate through 
    //the dataset.

    //Write an int-returned public method named findHighestResponse that accepts a Scanner object 
    //associated with a stream of input consisting of integer response values. This method reads all 
    //the input values from the Scanner, recursively determines the highest response value, and returns 
    //it. Note that the method should not use loops of any kind (for, while, do-while) to accomplish its task.

    //Note: assume the Scanner object has at least one integer.
    public static int findHighestResponse(Scanner input) {
        // base case
        if (!input.hasNext()) {
            return 0;
        }
        // reduction + rest
        else {
            // how to reduce?
            // iterate input

            // what to do with it?
            int nextInt = input.nextInt();
            int restOfSet = findHighestResponse(input);
            if (nextInt > restOfSet) {
                return nextInt;
            } else
                return restOfSet;
        }
    }

    //Assignment: Implement a public method named reverseString that accepts a String parameter. 
    //This method should recursively reverse the string and return the result.

    //The method should not use loops (for, while, do-while) to perform its task, showcasing 
    //recursion as a viable alternative for iterative processes.
    public static String reverseString(String str) {
        // base case
        // string length == 0
        if (str.length() == 0)
            return str;
        else
            // reduce + rest
            // how to reduce?
            // return str.substring(1,n) + str.substring(0, 1)
            // "test string"
            // "est string" + "t"
            // "st string" + "e"
            return reverseString(str.substring(1)).concat(str.substring(0, 1));
    }

    //Assignment: Implement a recursive public method boolean findPattern that accepts a String 
    //and returns true if the pattern "DBD" is present within the provided input string, 
    //and otherwise returns false.
    //Your solution must not make use of loops.

    // Helper function solution: 
    //public static boolean findPattern(String s) {
    //    // Write your code here
    //    // base case
    //    // s.length() == 0
    //    char[] chArr = new char[2]; 
    //    return findPattern(s, chArr, 0);
    //}

    //public static boolean findPattern(String s, char[] chArr, int index) {
    //    // base cases
    //    // ch == "B" and s.charAt(0) == "D"
    //    if (chArr[0] == 'D' && chArr[1] == 'B' && s.charAt(index) == 'D')
    //        return true;
    //    if (index == s.length())
    //        return false;
    //    chArr[0] = chArr[1];
    //    chArr[1] = s.charAt(index++);
    //    return findPattern(s, chArr, index);
    //}

    // normal solution:
    public static boolean findPattern(String s) {
        // Write your code here
        // base case
        // s.length() == 0
        if (s.startsWith("DBD"))
            return true;
        if (s.length() < 3)
            return false;
        return findPattern(s.substring(1));
        // reduce + rest
        // how to reduce
    }

    //Assignment: Implement a method named calculatePower that accepts two int 
    //parameters for the base and exponents.
    public static double calculatePower(double base, int exponent) {
        // base case
        // exponent == 0
        if (exponent == 0)
            return 1.0;
        // reduce + rest
        if (exponent > 0) {
            return base * calculatePower(base, exponent - 1);
        } else {
            return (1.0 / base) * calculatePower(base, exponent + 1);
        }
    }

    //Assignment: Implement a public static method named findMinimum(int[] array, int start, int end) 
    //that recursively determines the minimum value within a given integer array. 
    //The method should accept the following arguments:
    //array: an array of int values;
    //start: an int that can be used to identify the start of a subarray within array;
    //end: an int that can be used to identify the end of a subarray within array.
    public static int findMinimum(int[] array, int start, int end) {
        // base case
        // start == end
        if (start == end) {
            return array[end];
        }
        int nextInt = findMinimum(array, (start + 1), end);
        if (array[start] < nextInt) 
            return array[start];
        else
            return nextInt;
        // reduce + rest
        // how to reduce?
    }

    //Assignment: Create a method named calculateAverage. This method should accept an int[] array. 
    //It should return the average value of the array as a double. To do so, you will also implement 
    //a recursive helper function sumArrayHelper, which will compute the sum of the array's elements. 
    //This helper function takes two parameters, the int[] array and an int index.

    // Helper recursive method to calculate the sum of elements in an array
    private static int sumArrayHelper(int[] arr, int index) {
    //Write your code here
        // base case
        // index == arr.length
        if (index == arr.length)
            return 0;
        // reduce + rest
        return arr[index] + sumArrayHelper(arr, index + 1);
    }

    // Public method to calculate the average of values in an array
    public static double calculateAverage(int[] arr) {
        return sumArrayHelper(arr, 0) / (double)arr.length;
    }

}
