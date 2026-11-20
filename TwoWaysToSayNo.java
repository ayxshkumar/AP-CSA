/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.06.01 Two Ways to Say No: De Morgan Checker
 * Due Date:    November 20, 2026
 *
 * Description: Writes four conditions two ways, once as the original !( ... ) form and
 * once rewritten with De Morgan's Laws, then uses a test harness to check that both
 * versions return the same value on the same inputs, including boundary values.
 */
public class TwoWaysToSayNo
{
    public static void main(String[] args)
    {
        System.out.println("=== SCENARIO 1: School stays open ===");
        check("snow=2, temp=20", schoolOpenOriginal(2, 20), schoolOpenRewrite(2, 20));
        check("snow=8, temp=20", schoolOpenOriginal(8, 20), schoolOpenRewrite(8, 20));
        check("snow=2, temp=-15", schoolOpenOriginal(2, -15), schoolOpenRewrite(2, -15));
        check("snow=6, temp=-10", schoolOpenOriginal(6, -10), schoolOpenRewrite(6, -10));
        check("snow=2, temp=-10", schoolOpenOriginal(2, -10), schoolOpenRewrite(2, -10));

        System.out.println("=== SCENARIO 2: Password rejected ===");
        check("length=10, digit=true", rejectedOriginal(10, true), rejectedRewrite(10, true));
        check("length=10, digit=false", rejectedOriginal(10, false), rejectedRewrite(10, false));
        check("length=5, digit=true", rejectedOriginal(5, true), rejectedRewrite(5, true));
        check("length=8, digit=true", rejectedOriginal(8, true), rejectedRewrite(8, true));

        System.out.println("=== SCENARIO 3: Game over ===");
        check("lives=3, time=30", gameOverOriginal(3, 30), gameOverRewrite(3, 30));
        check("lives=0, time=30", gameOverOriginal(0, 30), gameOverRewrite(0, 30));
        check("lives=3, time=0", gameOverOriginal(3, 0), gameOverRewrite(3, 0));
        check("lives=0, time=0", gameOverOriginal(0, 0), gameOverRewrite(0, 0));

        System.out.println("=== SCENARIO 4: Score out of range ===");
        check("score=50", outOfRangeOriginal(50), outOfRangeRewrite(50));
        check("score=0", outOfRangeOriginal(0), outOfRangeRewrite(0));
        check("score=100", outOfRangeOriginal(100), outOfRangeRewrite(100));
        check("score=101", outOfRangeOriginal(101), outOfRangeRewrite(101));

        System.out.println("=== THE COMMON MISTAKE (provided) ===");
        check("score=0", outOfRangeOriginal(0), outOfRangeBuggy(0));
        check("score=100", outOfRangeOriginal(100), outOfRangeBuggy(100));

        System.out.println("=== SCENARIO 5: My own scenario ===");
        check("height=48, adult=false", rideDeniedOriginal(48, false),
                rideDeniedRewrite(48, false));
        check("height=47, adult=false", rideDeniedOriginal(47, false),
                rideDeniedRewrite(47, false));
    }

    // prints one test row and whether the two versions agree
    public static void check(String inputs, boolean original, boolean rewrite)
    {
        String result = (original == rewrite) ? "MATCH" : "MISMATCH";
        System.out.printf("  %-24s original=%-6b rewrite=%-6b %s%n",
                inputs, original, rewrite, result);
    }

    // Scenario 1: school stays open
    public static boolean schoolOpenOriginal(int snow, int temp)
    {
        return !(snow >= 6 || temp < -10);
    }

    public static boolean schoolOpenRewrite(int snow, int temp)
    {
        return snow < 6 && temp >= -10;
    }

    // Scenario 2: password rejected
    public static boolean rejectedOriginal(int length, boolean hasDigit)
    {
        return !(length >= 8 && hasDigit);
    }

    public static boolean rejectedRewrite(int length, boolean hasDigit)
    {
        return length < 8 || !hasDigit;
    }

    // Scenario 3: game over
    public static boolean gameOverOriginal(int lives, int time)
    {
        return !(lives > 0 && time > 0);
    }

    public static boolean gameOverRewrite(int lives, int time)
    {
        return lives <= 0 || time <= 0;
    }

    // Scenario 4: score out of range
    public static boolean outOfRangeOriginal(int score)
    {
        return !(score >= 0 && score <= 100);
    }

    public static boolean outOfRangeRewrite(int score)
    {
        return score < 0 || score > 100;
    }

    // Scenario 5 (my own): a rider is denied when it is not the case that they are
    // 48+ inches tall or riding with an adult
    public static boolean rideDeniedOriginal(int height, boolean withAdult)
    {
        return !(height >= 48 || withAdult);
    }

    public static boolean rideDeniedRewrite(int height, boolean withAdult)
    {
        return height < 48 && !withAdult;
    }

    // PROVIDED — a common mistake: negating >= as > and <= as <
    public static boolean outOfRangeBuggy(int score)
    {
        return score <= 0 || score >= 100;
    }
    /*
     * Why the Common Mistake shows MISMATCH:
     * The negation of >= is <, not <=, and the negation of <= is >, not >=. The correct
     * rewrite is score < 0 || score > 100. The buggy version uses score <= 0 and
     * score >= 100, so it also counts 0 and 100 as out of range, even though the original
     * says 0 and 100 are in range. At score = 0 and score = 100 the original returns 
     * false but the buggy version returns true, so those rows say MISMATCH.
     */
}

/*
 * SCENARIO 2 TRUTH TABLE: rejected = !(length >= 8 && hasDigit) = length < 8 || !hasDigit
 *
 * length >= 8 | hasDigit | length >= 8 && hasDigit | rejected (original and rewrite)
 * ------------+----------+-------------------------+-------------------------------
 *    true     |   true   |          true           |             false
 *    true     |   false  |          false          |             true
 *    false    |   true   |          false          |             true
 *    false    |   false  |          false          |             true
 *
 * A password is accepted only when both conditions are true; every other combination
 * is rejected.
 *
 * THINK ABOUT IT
 *
 * 1. Why do the boundary values catch the Common Mistake when 50 and 101 don't?
 *    The buggy version (score <= 0 || score >= 100) and the correct rewrite
 *    (score < 0 || score > 100) only differ at the exact values where < and <= disagree,
 *    which are 0 and 100. For 50, both versions are false, and for 101, both are true,
 *    so those tests can't tell the two apart. Off-by-one mistakes in relational operators
 *    only show up when you test the boundary value itself.
 *
 * 2. Which Scenario 1 test catches temp > -10 instead of temp >= -10?
 *    The snow=2, temp=-10 test catches it. The original returns true (-10 is not below
 *    -10, so school stays open), but temp > -10 is false at -10, so the bad rewrite
 *    returns false and the row says MISMATCH.
 *    The snow=6, temp=-10 test doesn't catch it because snow < 6 is false. When the left
 *    side of && is false, the whole expression is false no matter what the right side
 *    is (Java short-circuits and doesn't even check the temp). Both the correct and the
 *    buggy rewrite return false, so the row says MATCH and the bug stays hidden.
 *
 * 3. My own scenario (Scenario 5):
 *    English rule: A rider is denied entry to a ride when it is not the case that they
 *    are at least 48 inches tall or riding with an adult.
 *    Original: !(height >= 48 || withAdult)
 *    Rewrite:  height < 48 && !withAdult
 *    Tests: height=48 with no adult is the boundary (48 is tall enough, so not denied),
 *    and height=47 with no adult is just below it (denied). Someone who negated >= as
 *    <= would get height=48 wrong.
 */