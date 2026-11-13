/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.05.1 - Thunder Mountain Ride Gate
 * Due Date:    11/13/26
 *
 * Description: Gate program for the Thunder Mountain roller coaster. Reads a
 *              rider's height, age, adult-escort answer, and safety-video
 *              answer, then applies the six ride rules in order with one 
 *              singular if / else if / else chain. An admitted rider who is
 *              under 10 years old or under 48 inches also gets a Fast Pass.
 */

import java.util.Scanner;

public class RideGate {

    // Rule 1: valid entry ranges
    private static final int MIN_VALID_HEIGHT = 30;
    private static final int MAX_VALID_HEIGHT = 96;
    private static final int MIN_VALID_AGE = 1;
    private static final int MAX_VALID_AGE = 110;

    // Rule 3: riding on your own
    private static final int MIN_SOLO_HEIGHT = 48;
    private static final int MAX_RIDER_HEIGHT = 76;
    private static final int MIN_SOLO_AGE = 8;

    // Rule 4: riding with an adult
    private static final int MIN_ESCORT_HEIGHT = 44;
    private static final int MAX_ESCORT_HEIGHT = 47;

    // Fast Pass limits
    private static final int FAST_PASS_AGE = 10;
    private static final int FAST_PASS_HEIGHT = 48;

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        int height;
        int age;
        boolean withAdult;
        boolean watchedVideo;
        boolean admitted = false;

        System.out.println("=== THUNDER MOUNTAIN RIDE GATE ===");

        System.out.print("Rider height (inches): ");
        height = entry.nextInt();

        System.out.print("Rider age: ");
        age = entry.nextInt();

        System.out.print("Riding with an adult? (yes/no): ");
        withAdult = entry.next().equalsIgnoreCase("yes");

        System.out.print("Watched the safety video? (yes/no): ");
        watchedVideo = entry.next().equalsIgnoreCase("yes");

        // Gate decision: rules are checked in order and the first match wins
        if (height < MIN_VALID_HEIGHT || height > MAX_VALID_HEIGHT
                || age < MIN_VALID_AGE || age > MAX_VALID_AGE) {
            System.out.println(
                    "Invalid entry. Please check the height and age.");
        } else if (!watchedVideo) {
            System.out.println("Please watch the safety video first.");
        } else if (height >= MIN_SOLO_HEIGHT && height <= MAX_RIDER_HEIGHT
                && age >= MIN_SOLO_AGE) {
            System.out.println("Welcome aboard! Enjoy Thunder Mountain.");
            admitted = true;
        } else if (height >= MIN_ESCORT_HEIGHT && height <= MAX_ESCORT_HEIGHT
                && withAdult) {
            System.out.println(
                    "Welcome aboard! Stay seated next to your adult.");
            admitted = true;
        } else if (height > MAX_RIDER_HEIGHT) {
            System.out.println(
                    "Sorry, the restraints do not fit riders over 76 inches.");
        } else {
            System.out.println(
                    "Sorry, you do not meet the ride requirements yet.");
        }

        // Fast Pass: only admitted riders who are young OR short qualify
        if (admitted && (age < FAST_PASS_AGE || height < FAST_PASS_HEIGHT)) {
            System.out.println("Fast Pass granted: use the short line!");
        }

        entry.close();
    }
}

/*
 * TEST CASES
 * entry order: height, age, with adult, watched video
 *
 * #   entry               Rule  Expected output                     Fast Pass
 * --  ------------------  ----  ----------------------------------  ---------
 * 1   25, 10, no, yes     1     Invalid entry (height under 30)     No
 * 2   60, 120, no, yes    1     Invalid entry (age over 110)        No
 * 3   52, 12, no, no      2     Please watch the safety video first No
 * 4   52, 9, no, yes      3     Welcome aboard! Enjoy Thunder Mtn.  Yes (age)
 * 5   60, 15, no, yes     3     Welcome aboard! Enjoy Thunder Mtn.  No
 * 6   46, 7, yes, yes     4     Welcome aboard! Stay seated...      Yes (hgt)
 * 7   80, 30, no, yes     5     Sorry, the restraints do not fit... No
 * 8   46, 7, no, yes      6     Sorry, you do not meet the ride...  No
 * 9   52, 7, no, yes      6     Sorry, you do not meet the ride...  No
 *
 * Boundary heights
 * 10  44, 6, yes, yes     4     Welcome aboard! Stay seated...      Yes
 * 11  47, 9, yes, yes     4     Welcome aboard! Stay seated...      Yes
 * 12  48, 12, no, yes     3     Welcome aboard! Enjoy Thunder Mtn.  No
 * 13  76, 30, no, yes     3     Welcome aboard! Enjoy Thunder Mtn.  No
 * 14  77, 30, no, yes     5     Sorry, the restraints do not fit... No
 *
 * All 14 cases were run and matched the expected output.
 */

/*
 * THINK ABOUT IT
 *
 * 1. Without parentheses, admitted && age < 10 || height < 48 is read as
 *    (admitted && age < 10) || height < 48, because && is evaluated before
 *    the ||. entry 46, 7, no, yes changes the result because the rider is
 *    turned away by Rule 6 (admitted is false), but height < 48 is true by
 *    itself, so the program still prints "Fast Pass granted" to someone 
 *    who cannot actually ride. With the parentheses, admitted is false, so
 *    the whole condition is false and no Fast Pass is printed.
 *
 * 2. An if / else if chain pauses at the first true condition, so bad data
 *    must be caught before any other rule looks at it. If Rule 1 came later,
 *    an impossible entry such as height 60, age 200 would pass Rule 3 and
 *    be welcomed aboard, and height 120 would get the "restraints" message
 *    instead of being flagged as an invalid test case.
 *
 * 3. height < 48 || height > 76
 *    Using De Morgan's law, !(a && b) is the same as !a || !b, so the >= 
 *    flips to <, <= flips to >, and && becomes ||.
 */