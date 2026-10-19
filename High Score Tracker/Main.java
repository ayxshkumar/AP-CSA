// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.17.1 — High Score Tracker
// Due Date:      October 7, 2026

public class Main
{
    public static void main(String[] args)
    {
        // ---------------------------------------------------
        // Player names — provided
        // ---------------------------------------------------
        String[] names = {"Amara", "Devon", "Priya", "Kai", "Lena"};

        // ---------------------------------------------------
        // Score array — provided
        // ---------------------------------------------------
        // This creates 5 empty slots. Every slot starts as null, NOT 0.
        Integer[] scores = new Integer[names.length];

        // Explicit constructor: exam-tested syntax from the AP CSA Java Quick Reference.
        // The "deprecated" warning here is expected, not a mistake.
        scores[0] = new Integer(87);

        // Devon (slot 1) has not played — leave it null on purpose.

        // Autoboxing: Java automatically wraps these plain int values in Integer objects.
        scores[2] = 95;
        scores[3] = 72;

        // Lena (slot 4) has not played — leave it null on purpose.

        // ---------------------------------------------------
        // Create the tracker and print scores — provided
        // ---------------------------------------------------
        HSTracker tracker = new HSTracker(names, scores);
        tracker.printScores();

        // ---------------------------------------------------
        // Highest score — provided
        // ---------------------------------------------------
        int topIndex = tracker.findHighestIndex();
        System.out.println();

        if (topIndex != -1)
        {
            System.out.println("Highest score so far: " + tracker.getScore(topIndex)
                               + " (" + tracker.getName(topIndex) + ")");
        }
        else
        {
            System.out.println("No one has played yet.");
        }

        // ---------------------------------------------------
        // Class average — provided
        // ---------------------------------------------------
        System.out.printf("Class average (players who have played): %.2f%n",
                          tracker.calculateAverage());

        // ---------------------------------------------------
        // Wrapper class limits
        // ---------------------------------------------------
        // Double.MAX_VALUE is the largest finite double (about 1.8E308).
        // Double.MIN_VALUE is the smallest POSITIVE double, not the most negative one,
        // while Integer.MIN_VALUE really is the most negative int.
        System.out.println();
        System.out.println("Double.MAX_VALUE  = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE  = " + Double.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
    }
}