/**
 * Assignment: 1.7.2 — Magic 8-Ball: Exploring APIs and Libraries
 * Name:       Ayush Kumar
 * Partner:    None
 * Instructor: Mr. Virak
 * Date:       9/2/26
 * Course:     AP Computer Science A
 * Period:     5
 *
 * Description:
 * The program asks the user a yes/no question, uses java.util.Random
 * to pick one of eight Magic 8-Ball responses, prints it in uppercase,
 * and loops until the user answers "no" to asking another question.
 * I also added a null guard prints a warning if the question is blank. 
 * The Scanner, Random, and responses array are all created with
 * "new", so they live on the heap. The local variables input, rand,
 * and responses live on the stack and only hold references to those heap objects.
 */

// Import the required packages
import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args)
    {
        // Create Scanner and Random objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Array of Magic 8-Ball responses
        String[] responses = {
            "It is certain.",
            "Without a doubt.",
            "Reply hazy, try again.",
            "Ask again later.",
            "Don't count on it.",
            "My sources say no.",
            "Outlook not so good.",
            "Very doubtful."
        };

        // Starts as "yes" so that the loop runs at least once
        String continueChoice = "yes";

        System.out.println("Welcome to the Magic 8-Ball!");
        System.out.println("============================");

        // Loop while the user wants to keep asking questions
        while (continueChoice.equalsIgnoreCase("yes"))
        {
            // Prompt the user for a question nextLine() reads the whole line
            System.out.print("Ask your yes/no question: ");
            String question = input.nextLine();

            // Generate a random index using rand.nextInt()
            int index = rand.nextInt(responses.length);

            // Display the response; toUpperCase() makes the answer look dramatic I guess
            System.out.println();
            System.out.println("\uD83C\uDFB1 The Magic 8-Ball says...");
            System.out.println("   " + responses[index].toUpperCase());
            System.out.println();

            // Ask if the user wants to continue
            System.out.print("Ask another question? (yes/no): ");
            continueChoice = input.nextLine();
            System.out.println();
        }

        System.out.println("The Magic 8-Ball has spoken. Goodbye!");

        // Closes the Scanner and releases the heap
        input.close();
    }
}