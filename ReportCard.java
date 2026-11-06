// Name: Ayush Kumar
// Partner: None
// Instructor: Mr. Virak
// Course: AP Computer Science A
// Assignment: 1.16.1 — Formatted Report Card
// Date: September 30th, 2026

/**
 * Assignment 1.16.1 — Formatted Report Card
 * Prints an aligned Name/Score/Grade report using String.format().
 * Scale: standard 90/80/70/60 cutoffs (A/B/C/D, below 60 is F).
 */
public class ReportCard {

    // Shared column widths: Name 15, Score 6, Grade 5
    static final String HEADER_FORMAT = "%-15s %6s %5s";
    static final String ROW_FORMAT    = "%-15s %6.1f %5s";

    public static void main(String[] args) {
        // Parallel arrays; short and long names test alignment
        String[] names = {"Al", "Christopher", "Beatrix", "Sam", "Priya", "Maximilian", "Jo"};

        // Boundary tests: 90.0 = A, 89.9 = B, 60.0 = D, 59.9 = F
        double[] scores = {92.5, 78.3, 89.9, 60.0, 95.0, 90.0, 59.9};

        // Header uses same widths as data rows
        System.out.println(String.format(HEADER_FORMAT, "Name", "Score", "Grade"));

        // Separator dashes sized to each column (15, 6, and 5 dashes)
        System.out.println(String.format(HEADER_FORMAT,
                "---------------", "------", "-----"));

        for (int i = 0; i < names.length; i++) {
            String grade = letterGrade(scores[i]);
            // Left-align names: shared left edge makes text easy to scan
            // Right-align scores: decimal points and place values line up
            System.out.println(String.format(ROW_FORMAT, names[i], scores[i], grade));
        }
    }

    // Highest to lowest; >= so exact cutoffs earn the higher grade
    public static String letterGrade(double score) {
        if (score >= 90.0) {
            return "A";
        } else if (score >= 80.0) {
            return "B";
        } else if (score >= 70.0) {
            return "C";
        } else if (score >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }
}