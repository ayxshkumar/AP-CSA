// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.16.2 — Palindrome Checker
// Due Date:      October 5, 2026
import java.util.Scanner;

class Main 
{
	public static void main(String[] args) 
	{
		// create a Scanner to read user input from the keyboard
		Scanner sc = new Scanner(System.in);

		// ask the user for a phrase and store it
		System.out.println("Enter a phrase:");
		String phrase = sc.nextLine();
		System.out.println();

		// copy the phrase into a StringBuilder so it can be reversed
		StringBuilder reversePhrase = new StringBuilder(phrase);

		// reverse the order of the characters
		reversePhrase.reverse();

		// make both versions lowercase and strip out everything that isn't a letter
		// (spaces, punctuation, digits), then check if they match
		if (phrase.toLowerCase().replaceAll("[^a-zA-Z]", "").equals(reversePhrase.toString().toLowerCase().replaceAll("[^a-zA-Z]", ""))) {
			// original and reversed phrase are the same, so it's a palindrome
			System.out.println("The phrase " + phrase + " is a palindrome");
		} else {
			// original and reversed phrase differ, so it's not a palindrome
			System.out.println("The phrase " + phrase + " is not a palindrome");
		}

		// close the Scanner to free up the input resource
		sc.close();
	}
}