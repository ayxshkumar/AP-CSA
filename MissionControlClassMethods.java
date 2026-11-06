/**
 * Name:          Ayush Kumar
 * Course:        AP Computer Science A
 * Instructor:    Mr. Virak
 * Assignment:    1.10.1 -  Mission Control: Class Methods
 * Due Date:      September 9th, 2026
 */

/*
Investigation

Section A

1. Why can you call Math.sqrt() without first writing Math m = new Math()?
sqrt is a static method, so it belongs to the Math class rather than to an instance. You call it through the class name without creating an object.

2. What keyword makes a method a class (static) method?
static

3. What is the return type of Math.random()? What range of values can it produce?
double, ranging from 0.0 up to but not including 10.0.

4. What is the return type of Math.round(double a)? Why is the return type different from double?
long. Math.round narrows the double down to a long.

5. In your own words, explain why main must be declared static.
main has to belong to the class rather than an object, since no object exists when the program starts. Without static it would be an instance method.

Section B - Reading Method Signatures

public static int max(int a, int b)

6. How many parameters does this method take?
Two.

7. What data type does it return?
int.

8. Write a line of code that calls this method with the values 42 and 17 and stores the result in a variable.
int maximum = max(42, 17);

public static void printDivider(int width)

9. What does a void return type mean?
The method returns no value; it only produces output (e.g. printing).

10. Can you store the result of calling this method in a variable? Why or why not?
No. A void method returns nothing, so there is nothing to store.

Section C - Decomposing a Problem

11. Three static methods for the rocket task (signatures only):
public static double calculateRequiredFuel(double distance, double currentFuel)
public static boolean printWarning(double currentFuel)
public static String printLaunchReport(double distance, double currentFuel)
*/
import java.util.*;

public class MissionControlClassMethods
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("=== MISSION CONTROL LAUNCH SYSTEM ===");

        // Get user inputs
        System.out.print("Enter rocket name: ");
        String rocketName = input.nextLine();

        System.out.print("Enter fuel amount (liters): ");
        double fuel = input.nextDouble();

        System.out.print("Enter rocket mass (kg): ");
        double mass = input.nextDouble();

        System.out.print("Enter engine thrust (kN): ");
        double thrust = input.nextDouble();

       // Mission constants
        double distanceKm    = 400.0;
        double fuelEfficiency = 12.5;
        double speedKph      = 28000.0;
        String safeMessage;

        // Call your static methods and store the results
        double flightTime = calculateFlightTime(distanceKm, speedKph);
        double fuelConsumption = calculateFuelConsumption(distanceKm, fuelEfficiency);
        boolean isSafe = isSafeLaunch(thrust, mass);
        // Conditional for message in report depending on safeness due to method returning a boolean
        if (isSafe) 
        {
            safeMessage = "Safe for Launch.";
        }
        else
        {
            safeMessage = "Not Safe for Launch.";
        }
       // Call printLaunchReport
        //passing name, fuel, flight time, thrust, mass, and safety message
        printLaunchReport(rocketName, fuelConsumption, flightTime, thrust, mass, safeMessage);
        input.close();
    }
 // Static Methods
    public static double calculateFuelConsumption(double distanceKm, double fuelEfficiency)
    {
        double consumption = distanceKm/fuelEfficiency;
        return Math.round(consumption);
    }

    public static double calculateFlightTime(double distanceKm, double speedKph)
    {
        double flightTime = distanceKm/speedKph;
        return Math.abs(flightTime);
    }

    public static boolean isSafeLaunch(double thrustKn, double massKg)
    {
        if ((thrustKn/(massKg *9.8/1000)) > 1.5)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static void printLaunchReport(String rocketName, double fuel,
                                         double flightTime, double thrust, double mass,
                                         String safeMessage)
    {
        //printf formatting
        System.out.println("\nMission Launch Report:\n");
        System.out.printf("Rocket Name: " + rocketName
                + "\nFuel Consumed: %.2f liters\nFlight Time: %.2f hours"
                + "\nThrust/Weight: %.2f \nLaunch Status: " + safeMessage,
                fuel, flightTime, (thrust/(mass *9.8/1000)));
    }    

}

/*
TEST CASE 1: Real rocket that is too heavy
Input: Falcon 9, 500000, 549054, 7607
Expected: Fuel 32.00, Time 0.01, Thrust/Weight 1.41, Not Safe for Launch.
Actual: Fuel 32.00, Time 0.01, Thrust/Weight 1.41, Not Safe for Launch.
Result: PASS

TEST CASE 2: Light rocket with strong thrust
Input: Scout, 900, 1000, 20
Expected: Fuel 32.00, Time 0.01, Thrust/Weight 2.04, Safe for Launch.
Actual: Fuel 32.00, Time 0.01, Thrust/Weight 2.04, Safe for Launch.
Result: PASS

TEST CASE 3: Ratio exactly 1.5 (must be greater than 1.5)
Input: Edge, 100, 1000, 14.7
Expected: Fuel 32.00, Time 0.01, Thrust/Weight 1.50, Not Safe for Launch.
Actual: Fuel 32.00, Time 0.01, Thrust/Weight 1.50, Not Safe for Launch.
Result: PASS

TEST CASE 4: Ratio just above 1.5
Input: Edge2, 100, 1000, 14.71
Expected: Fuel 32.00, Time 0.01, Thrust/Weight 1.50, Safe for Launch.
Actual: Fuel 32.00, Time 0.01, Thrust/Weight 1.50, Safe for Launch.
Result: PASS
*/