/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.06.02 - BMI Calculator
 * Due Date:    11/20/26
 *
 * Description: Reads a height and weight, checks that both are greater than 0, then
 * calculates the Body Mass Index (BMI) and prints it with its CDC weight class.
 * Extra credit: the user can choose metric (m) or imperial (i) units.
 */
import java.util.Scanner;

public class BMI
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Would you like to use metric (m) or imperial (i) units? ");
        String units = scan.next();

        double height;
        double weight;
        if (units.equalsIgnoreCase("m"))
        {
            System.out.print("Height (in centimeters): ");
            double heightCm = scan.nextDouble();
            System.out.print("Weight (in kilograms): ");
            double weightKg = scan.nextDouble();

            // convert to inches and pounds so the same methods work for both units
            height = heightCm / 2.54;
            weight = weightKg * 2.20462;
        }
        else
        {
            System.out.print("Height (in inches): ");
            height = scan.nextDouble();
            System.out.print("Weight (in pounds): ");
            weight = scan.nextDouble();
        }

        // De Morgan equivalent with no !: height <= 0 || weight <= 0
        if (!(height > 0 && weight > 0))
        {
            System.out.println("Height and weight must both be greater than 0.");
        }
        else
        {
            System.out.printf("BMI = %.1f%n", bmi(height, weight));
            System.out.println("Weight class: " + weightClass(height, weight));
        }

        scan.close();
    }

    // returns the BMI for a height in inches and a weight in pounds
    public static double bmi(double height, double weight)
    {
        return weight / (height * height) * 703;
    }

    // returns the CDC weight class for a height in inches and a weight in pounds
    public static String weightClass(double height, double weight)
    {
        double value = bmi(height, weight);

        if (value < 18.5)
        {
            return "underweight";
        }
        else if (value < 25.0)
        {
            return "normal";
        }
        else if (value < 30.0)
        {
            return "overweight";
        }
        else
        {
            return "obese";
        }
    }
}

/*
 * THINK ABOUT IT
 *
 * 1. Why should weightClass call bmi instead of repeating the formula?
 *    The formula is written in only one place. If it ever needs to change (for example,
 *    a typo in the 703 or switching to metric), I fix it once in bmi and weightClass
 *    automatically uses the fix. Repeating the formula means two copies that could end
 *    up disagreeing, so the printed BMI and the weight class might not match.
 *
 * 2. What changes if the normal range uses value <= 25.0 instead of value < 25.0?
 *    A BMI of exactly 25.0 would pass the value <= 25.0 test and be returned as
 *    "normal". The CDC table says 25.0 is "overweight", so a BMI of exactly 25.0 would
 *    be misclassified. Every other BMI would still land in the same class.
 *
 * 3. Valid-scan condition (the opposite of the invalid check) without !:
 *    height > 0 && weight > 0
 */