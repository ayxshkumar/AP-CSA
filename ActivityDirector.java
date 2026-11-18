/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  Activity Director - 2.04.02
 * Due Date:    October 28, 2026
 *
 * Description: Picks a random morning temperature from 10 to 101 (inclusive), prints it,
 *              and suggests one activity using an if / else if / else chain. A separate,
 *              independent check also prints "Visit our shops!" when the temperature is
 *              above 95 or below 20.
 */
public class ActivityDirector
{
    public static void main(String[] args)
    {
        // Random temperature from 10 to 101 (inclusive)
        // Number of possible values = max - min + 1 = 101 - 10 + 1 = 92
        // Math.random() * 92 gives 0.0 up to (not including) 92.0
        // (int) truncates that to 0..91, and + 10 shifts the range to 10..101
        int temp = (int) (Math.random() * 92) + 10;

        System.out.println("Temperature: " + temp);

        System.out.println(suggestActivity(temp));

        // Separate check, NOT part of the activity chain: it can print in addition to the activity
        if (temp > 95)
        {
            System.out.println("Visit our shops!");
        }
        else if (temp < 20)
        {
            System.out.println("Visit our shops!");
        }
    }

    /** Returns the suggested activity for the given temperature. */
    public static String suggestActivity(int temp)
    {
        if (temp >= 80)
        {
            return "Go swimming!";
        }
        else if (temp >= 60)
        {
            return "Play tennis!";
        }
        else if (temp >= 40)
        {
            return "Play golf!";
        }
        else
        {
            return "Go skiing!";
        }
    }
}

/*
 * Think About It
 *
 * 1. Why can't "Visit our shops!" be another else if at the bottom of the activity chain?
 * 
 *    Only one branch of an if / else if / else chain runs. Nothing can come after the else
 *    statement, so the shop check would have to sit just before it. A temperature like 100
 *    would then stop at temp >= 80 and never reach the shop check, and a temperature like
 *    15 would reach it and get Visit our shops! in place of Go skiing!. Either way the 
 *    guest gets one message when they should get two, so the shop check needs its own if
 *    after the chain.
 *
 * 2. What would go wrong if temp >= 40 came first?
 * 
 *    Every temperature 40 and above would match it and get Play golf!, so 72 and 100 would both
 *    print Play golf! and the tennis and swimming branches would never run. With >= conditions,
 *    the chain has to check the highest range first.
 *
 * 3. Preview of 2.05: the shop check written as one if with ||
 *    if (temp > 95 || temp < 20)
 *    {
 *        System.out.println("Visit our shops!");
 *    }
 */