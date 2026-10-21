/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.02 Field Trip Check (Boolean Expressions)
 * Due Date:    10/21/26
 *
 * Description: Reads one student's information and prints a true/false
 *              field trip report. Each report line is a Boolean expression
 *              stored in a well-named boolean variable (no if, &&, or ||).
 */

import java.util.Scanner;

public class FieldTrip
{
    public static void main(String[] args)
    {
        final double MIN_GPA = 2.0;
        final int MAX_ABSENCES = 5;

        Scanner input = new Scanner(System.in);

        // ---- Input ----
        System.out.print("Student name: ");
        String name = input.nextLine();

        System.out.print("Grade level (9-12): ");
        int gradeLevel = input.nextInt();

        System.out.print("GPA: ");
        double gpa = input.nextDouble();

        System.out.print("Absences this semester: ");
        int absences = input.nextInt();

        System.out.print("Total service hours: ");
        int serviceHours = input.nextInt();

        System.out.print("Service events attended: ");
        int serviceEvents = input.nextInt();

        System.out.print("Permission slip returned? (yes/no): ");
        String permission = input.next();

        // ---- Boolean expressions (operators used: >, >=, <=, <) ----
        boolean isUpperclassman = gradeLevel > 10;
        boolean meetsGpa = gpa >= MIN_GPA;
        boolean meetsAttendance = absences <= MAX_ABSENCES;
        boolean hasPermissionSlip = permission.equalsIgnoreCase("yes");
        boolean hasPerfectGpa = Math.abs(gpa - 4.0) < 0.0001;
        boolean isBusA = name.charAt(0) <= 'M';

        // First version (no cast):
        //     boolean meetsServiceAvg = serviceHours / serviceEvents >= 3.5;
        // Tested with 14 hours and 4 events -> printed false (expected true).
        // Why it was wrong: both operands are ints, so 14 / 4 is integer
        // division and gives 3 (the .5 is thrown away). Java then compares
        // 3 >= 3.5, which is false. Casting one operand to double makes the
        // division 14.0 / 4 = 3.5, and 3.5 >= 3.5 is true.
        boolean meetsServiceAvg = (double) serviceHours / serviceEvents >= 3.5;

        // ---- Report ----
        System.out.println();
        System.out.println("=== FIELD TRIP CHECK: " + name.toUpperCase() + " ===");
        System.out.printf("%-29s%b%n", "Upperclassman (11-12):", isUpperclassman);
        System.out.printf("%-29s%b%n", "GPA at least 2.0:", meetsGpa);
        System.out.printf("%-29s%b%n", "Absences 5 or fewer:", meetsAttendance);
        System.out.printf("%-29s%b%n", "Permission slip returned:", hasPermissionSlip);
        System.out.printf("%-29s%b%n", "Perfect 4.0 GPA:", hasPerfectGpa);
        System.out.printf("%-29s%b%n", "Rides Bus A (names A-M):", isBusA);
        System.out.printf("%-29s%b%n", "Avg 3.5+ hours per event:", meetsServiceAvg);

        input.close();
    }
}

/*
 * Think About It
 *
 * 1. Without the cast, 14 / 4 is integer division, so Java actually
 *    compared 3 to 3.5 (3 >= 3.5), which is false.
 *
 * 2. Relational operators like < only work on primitive types (numbers and
 *    chars). name and "M" are String objects, so name < "M" does not
 *    compile. Instead, compare the first char, name.charAt(0) <= 'M', which
 *    works because chars are compared by their Unicode values.
 *    (compareTo could also compare Strings, but that is a method, not <.)
 *
 * 3. The && (logical AND) operator: the student is eligible only when
 *    isUpperclassman && meetsGpa && meetsAttendance && hasPermissionSlip.
 */