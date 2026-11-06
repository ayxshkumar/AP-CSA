/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A
 * Instructor:  Mr. Virak
 * Assignment:  1.15.1 - WordPlay
 * Due Date:    October 1, 2026
 */
import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
    {
        //ask user for name and phrase
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name and last name, separated by a space:");
        String fullName = sc.nextLine();
        System.out.println("Enter a phrase:");
        String phrase = sc.nextLine();
        System.out.println();

        //create a Wordplay Object
        Wordplay word = new Wordplay();

        //print name info
        System.out.println("Your first name is " + word.getFirstName(fullName));
        System.out.println("Your last name is " + word.getLastName(fullName));
        System.out.println("Your initials are " + word.getInitials(fullName));
        System.out.println();

        //print password
        System.out.println("Your new password: " + word.makePassword(fullName));
        System.out.println();

        //print phrase with c's changed to b's
        System.out.println(word.ceeBee(phrase));

        sc.close();
    }
}