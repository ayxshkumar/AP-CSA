/*
 * Name: Ayush Kumar
 * Partner: None
 * Course: AP Computer Science A
 * Instructor: Mr. Virak
 * Assignment: 2.05.3 - GuessChecker
 * Due Date: 11/16/26
 */

import java.util.Scanner;

public class GuessChecker
{
  //  - shared Scanner so no input is lost between guesses
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args)
  {
    /* Add any variables you will need throughout the program here. */
    //  - Pt 3: guesses left and a flag for a correct guess
    int guessesLeft = 3;
    boolean solved = false;

    // Generate the random number
    String targetStr = makeCode();
    System.out.println(targetStr);  // leave this line uncommented

    // Break the random number into four variables.
    int r1 = Integer.parseInt(targetStr.substring(0, 1));
    int r2 = Integer.parseInt(targetStr.substring(1, 2));
    int r3 = Integer.parseInt(targetStr.substring(2, 3));
    int r4 = Integer.parseInt(targetStr.substring(3, 4));

    //  - Pt 3: keep asking until out of guesses or solved
    while (guessesLeft > 0 && !solved)
    {
      // Get the user's guess.
      String guess = getGuess();

      // Break the user's guess into four variables.
      int g1 = Integer.parseInt(guess.substring(0, 1));
      int g2 = Integer.parseInt(guess.substring(1, 2));
      int g3 = Integer.parseInt(guess.substring(2, 3));
      int g4 = Integer.parseInt(guess.substring(3, 4));

      int hits = 0;
      int nearHits = 0;

      //  - Pt 1: a hit is a matching digit in the same position
      if (g1 == r1)
        hits++;
      //  - Pt 2/3: near hit = digit is in the code, wrong position
      // (compound boolean with ||; no duplicate digits, so no double counting)
      else if (g1 == r2 || g1 == r3 || g1 == r4)
        nearHits++;

      if (g2 == r2)
        hits++;
      else if (g2 == r1 || g2 == r3 || g2 == r4)
        nearHits++;

      if (g3 == r3)
        hits++;
      else if (g3 == r1 || g3 == r2 || g3 == r4)
        nearHits++;

      if (g4 == r4)
        hits++;
      else if (g4 == r1 || g4 == r2 || g4 == r3)
        nearHits++;

      guessesLeft--;
      solved = (hits == 4);

      System.out.println("Number of hits: " + hits);
      System.out.println("Number of near hits: " + nearHits);
      System.out.println("You have " + guessesLeft + " guesses remaining.");
      System.out.println();

      //  - Pt 3: end-of-game messages
      if (solved)
        System.out.println("You guessed the code!");
      else if (guessesLeft == 0)
        System.out.println("Out of guesses. The code was " + targetStr + ".");
    }
  }

  // Checks to ensure no duplicate digits in a int.
  public static boolean hasDupes(int num)
  {
    boolean[] digs = new boolean[10];
    while (num > 0)
    {
      if (digs[num % 10])
        return true;
      digs[num % 10] = true;
      num /= 10;
    }
    return false;
  }

  // Creates a new random 4 digit code 1000-9999 with no duplicates.
  public static String makeCode()
  {
    int target = (int) (Math.random() * 9000 + 1000);
    while (hasDupes(target))
      target = (int) (Math.random() * 9000 + 1000);
    String targetStr = target + "";
    return targetStr;
  }

  // Prompts the user for a guess and repeats until valid guess is made.
  public static String getGuess()
  {
    boolean validGuess = false;
    int userGuess = 0;
    while (!validGuess)
    {
      System.out.print("Guess a 4-digit number from 1000 to 9999 with no duplicate digits: ");
      userGuess = sc.nextInt();
      if (!(hasDupes(userGuess) || (userGuess < 1000)))
        validGuess = true;
    }
    String userStr = userGuess + "";
    return userStr;
  }
}

/*
 * TESTS (target code was 9782 in each run)
 *
 * Test 1 - wrong guesses, then correct on the last guess
 * 9782
 * Guess a 4-digit number from 1000 to 9999 with no duplicate digits: 9728
 * Number of hits: 2
 * Number of near hits: 2
 * You have 2 guesses remaining.
 *
 * Guess a 4-digit number from 1000 to 9999 with no duplicate digits: 7928
 * Number of hits: 0
 * Number of near hits: 4
 * You have 1 guesses remaining.
 *
 * Guess a 4-digit number from 1000 to 9999 with no duplicate digits: 9782
 * Number of hits: 4
 * Number of near hits: 0
 * You have 0 guesses remaining.
 *
 * You guessed the code!
 */