/**
 * Assignment: 1.11.2 - Race Car
 * Name:       Ayush Kumar
 * Partner:    None
 * Instructor: Mr. Virak
 * Date:       9/14/26
 * Course:     AP Computer Science A
 * Period:     3
 */
import java.util.Random;

public class Racecar
{
    private double accel; // acceleration in m/s²
    private String name;  // name of the driver

    public Racecar(double acceleration, String driver)
    {
        accel = acceleration;
        name  = driver;
    }

    // Returns the time it takes the racecar to complete
    // the track rounded to three decimal places.
    // Formula: t = √(2 × d / a)
    public double computeTime(double distance)
    {
        double time = Math.sqrt(2 * distance / accel);
        double rounded = Math.round(time * 1000.0) / 1000.0;
        return rounded;
    }

    public String toString()
    {
        return "Racer " + name;
    }

    public static void main(String[] args)
    {
        Random rand = new Random();

        // Length of the track in meters
        double distance = 2414; // ~1.5 miles

        // Random acceleration from 20 to 50 (inclusive)
        int accelTom = rand.nextInt(31) + 20;
        int accelJerry = rand.nextInt(31) + 20;

        // Create the two cars
        Racecar tom = new Racecar((double) accelTom, "Tom");
        Racecar jerry = new Racecar((double) accelJerry, "Jerry");

        // Compute finishing times
        double timeTom = tom.computeTime(distance);
        double timeJerry = jerry.computeTime(distance);

        System.out.println(tom + "'s car finished in " + timeTom + " seconds.");
        System.out.println(jerry + "'s car finished in " + timeJerry + " seconds.");
    }
}