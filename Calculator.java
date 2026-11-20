/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  Calculator - 2.04a.1
 * Due Date:    11/4/26
 *
 * Description: Asks the user for a mode (basic, scientific, or stats) and uses a switch on
 *              the mode String to run it. Basic mode uses a nested switch on the operator
 *              char. Each mode uses ternary operators for its quick decisions, and the
 *              default case reports an unknown mode.
 */
import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Choose a mode (basic, scientific, stats): ");
        String typed = scan.nextLine();
        // so " Basic " still matches "basic"
        String mode = typed.trim().toLowerCase();

        switch (mode)
        {
            case "basic":
                System.out.print("Enter first number: ");
                double a = scan.nextDouble();
                System.out.print("Enter second number: ");
                double b = scan.nextDouble();
                System.out.print("Enter operator (+ - * /): ");
                char op = scan.next().charAt(0);

                double result = 0;
                boolean validOp = true;

                switch (op)
                {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    default:
                        validOp = false;
                        break;
                }

                if (validOp)
                {
                    // 0 counts as positive
                    String sign = (result >= 0) ? "positive" : "negative";
                    String answer = result + " (" + sign + ")";

                    // Dividing by 0 has no answer, so print undefined instead
                    if (op == '/')
                    {
                        answer = (b == 0) ? "undefined" : answer;
                    }
                    System.out.println("Result: " + answer);
                }
                else
                {
                    System.out.println("Unknown operator: " + op);
                }
                break;

            case "scientific":
                System.out.print("Enter a number: ");
                double x = scan.nextDouble();

                System.out.println("Square: " + Math.pow(x, 2));
                System.out.println("Absolute value: " + Math.abs(x));

                // Both choices are Strings, so the ternary produces one type
                String root = (x < 0) ? "not a real number"
                                      : String.format("%.3f", Math.sqrt(x));
                System.out.println("Square root: " + root);
                break;

            case "stats":
                System.out.print("Enter three whole numbers: ");
                int n1 = scan.nextInt();
                int n2 = scan.nextInt();
                int n3 = scan.nextInt();

                // Largest of three in two steps
                int max = (n1 > n2) ? n1 : n2;
                max = (n3 > max) ? n3 : max;
                System.out.println("Largest: " + max);

                // Divide by 3.0 so the average keeps its decimal part
                System.out.printf("Average: %.2f%n", (n1 + n2 + n3) / 3.0);
                break;

            default:
                System.out.println("Unknown mode: " + typed);
                break;
        }

        scan.close();
    }
}

/*
 * Test Cases
 *
 * Run 1: Basic mode, divide by zero
 *    Choose a mode (basic, scientific, stats): basic
 *    Enter first number: 12
 *    Enter second number: 0
 *    Enter operator (+ - * /): /
 *    Result: undefined
 *
 * Run 2: Basic mode typed as " Basic " (capital letter and spaces), negative result
 *    Choose a mode (basic, scientific, stats):  Basic
 *    Enter first number: 7.5
 *    Enter second number: 10
 *    Enter operator (+ - * /): -
 *    Result: -2.5 (negative)
 *
 * Run 3: Basic mode, addition
 *    Choose a mode (basic, scientific, stats): basic
 *    Enter first number: 3.5
 *    Enter second number: 4
 *    Enter operator (+ - * /): +
 *    Result: 7.5 (positive)
 *
 * Run 4: Basic mode, result of 0 (0 counts as positive), all caps mode
 *    Choose a mode (basic, scientific, stats): BASIC
 *    Enter first number: 5
 *    Enter second number: 5
 *    Enter operator (+ - * /): -
 *    Result: 0.0 (positive)
 *
 * Run 5: Basic mode, division
 *    Choose a mode (basic, scientific, stats): basic
 *    Enter first number: 9
 *    Enter second number: 4
 *    Enter operator (+ - * /): /
 *    Result: 2.25 (positive)
 *
 * Run 6: Basic mode, invalid operator
 *    Choose a mode (basic, scientific, stats): basic
 *    Enter first number: 5
 *    Enter second number: 2
 *    Enter operator (+ - * /): %
 *    Unknown operator: %
 *
 * Run 7: Scientific mode, negative number
 *    Choose a mode (basic, scientific, stats): scientific
 *    Enter a number: -16
 *    Square: 256.0
 *    Absolute value: 16.0
 *    Square root: not a real number
 *
 * Run 8: Scientific mode, positive number
 *    Choose a mode (basic, scientific, stats): Scientific
 *    Enter a number: 2
 *    Square: 4.0
 *    Absolute value: 2.0
 *    Square root: 1.414
 *
 * Run 9: Stats mode
 *    Choose a mode (basic, scientific, stats): stats
 *    Enter three whole numbers: 84 97 90
 *    Largest: 97
 *    Average: 90.33
 *
 * Run 10: Stats mode, largest is first, negative numbers
 *    Choose a mode (basic, scientific, stats): stats
 *    Enter three whole numbers: -3 -10 -7
 *    Largest: -3
 *    Average: -6.67
 *
 * Run 11: Invalid mode
 *    Choose a mode (basic, scientific, stats): graphing
 *    Unknown mode: graphing
 */