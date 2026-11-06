/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A
 * Instructor:  Mr. Virak
 * Assignment:  1.15.2 - Speaking
 * Due Date:    October 1, 2026
 */
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		//ask user for your name and partner's name
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String yourName = sc.nextLine();
		System.out.println("Enter your partner's name:");
		String partnerName = sc.nextLine();
		System.out.println();

		//create Speaking Object
		Speaking talk = new Speaking();

		//print results
		System.out.println("Yelling your name: " + talk.yelling(yourName));
		System.out.println("Whispering your partner's name: " + talk.whisper(partnerName));
		System.out.println("Your name in Pig Latin: " + talk.pigLatin(yourName));
		System.out.println("Your partner's name in Pig Latin: "
				+ talk.pigLatin(talk.whisper(partnerName)));
		System.out.println();
		System.out.println("Your team name is " + talk.nameJoin(yourName, partnerName));
	}
}