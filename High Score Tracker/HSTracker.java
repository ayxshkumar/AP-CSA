// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.17.1 — High Score Tracker
// Due Date:      October 7, 2026

public class HSTracker
{
    // ---------------------------------------------------
    // Instance variables — provided
    // ---------------------------------------------------
    private String[] names;     // player names
    private Integer[] scores;   // WRAPPER array — a slot can be null ("has not played yet")

    // ---------------------------------------------------
    // Constructor — provided
    // ---------------------------------------------------
    public HSTracker(String[] names, Integer[] scores)
    {
        this.names = names;
        this.scores = scores;
    }

    // ---------------------------------------------------
    // Prints each player's score, or "no score yet"
    // ---------------------------------------------------
    public void printScores()
    {
        System.out.println("Player scores:");

        for (int i = 0; i < scores.length; i++)
        {
            // Null check comes first, because calling intValue() on null crashes.
            if (scores[i] == null)
            {
                System.out.println(names[i] + ": no score yet");
            }
            else
            {
                // Explicit unboxing: intValue() pulls the primitive int out of the Integer.
                int score = scores[i].intValue();
                System.out.println(names[i] + ": " + score);
            }
        }
    }

    // ---------------------------------------------------
    // Returns the slot number of the highest score,
    // or -1 if no one has played yet
    // ---------------------------------------------------
    public int findHighestIndex()
    {
        // MIN_VALUE, not 0: if every score were 0 or negative, nothing would beat 0,
        // so the tracker would report a fake high score that no player earned.
        int highest = Integer.MIN_VALUE;
        int highestIndex = -1;

        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] != null)   // skip players who haven't played
            {
                // Implicit unboxing: scores[i] is an Integer, but > only works on
                // primitives, so Java unboxes it automatically.
                if (scores[i] > highest)
                {
                    highest = scores[i];
                    highestIndex = i;
                }
            }
        }

        return highestIndex;
    }

    // ---------------------------------------------------
    // Returns the average of players who HAVE played.
    // Null scores are skipped — they are not zeros!
    // ---------------------------------------------------
    public double calculateAverage()
    {
        int total = 0;
        int count = 0;

        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] != null)
            {
                total += scores[i];   // implicit unboxing again
                count++;
            }
        }

        // Holds the average score of only the players who have played, as a Double object.
        Double average = new Double((double) total / count);

        // Java unboxes the Double back to a primitive double automatically.
        return average;
    }

    // ---------------------------------------------------
    // Accessors — provided
    // ---------------------------------------------------
    public String getName(int index)
    {
        return names[index];
    }

    public Integer getScore(int index)
    {
        return scores[index];
    }
}