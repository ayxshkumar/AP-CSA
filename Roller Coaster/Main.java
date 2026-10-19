// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.11.1 - Roller Coaster Simulator
// Due Date:      September 11, 2026
import java.util.Scanner;

class RollerCoasterSimulator {
    private static final double GRAVITY = 9.8; // m/s^2 // DO NOT CHANGE
    private static final double CURVE_RADIUS = 10.0; // constant curve radius

    // Attributes
    private double height;
    private double angle;
    private double trackLength;
    private double speed;
    private double time;
    private double gForce;

    // Constructor
    public RollerCoasterSimulator(double height, double angle, double trackLength) {
        this.height = height;
        this.angle = angle;
        this.trackLength = trackLength;
        calculateAll();
    }

    // Perform all calculations
    public void calculateAll() {
        // Speed at bottom using conservation of energy: v = sqrt(2 * g * h)
        this.speed = Math.sqrt(2 * GRAVITY * height);

        // Time down the incline: acceleration along the slope is a = g * sin(angle),
        // so t = sqrt((2 * trackLength) / a). Math.sin() needs radians, not degrees.
        double radians = Math.toRadians(angle);
        double acceleration = GRAVITY * Math.sin(radians);
        this.time = Math.sqrt((2 * trackLength) / acceleration);

        // G-force estimation during curve: G = v^2 / (r * g)
        this.gForce = Math.pow(this.speed, 2) / (CURVE_RADIUS * GRAVITY);
    }

    // Helper method for safety
    public boolean isSafe() {
        return this.gForce <= 5.0;
    }

    // Return calculated results
    public double getSpeed() {
        return speed;
    }

    public double getTime() {
        return time;
    }

    public double getGForce() {
        return gForce;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Roller Coaster Simulator");

        // Get user inputs
        System.out.print("Enter hill height (in meters): ");
        double height = input.nextDouble();

        System.out.print("Enter slope angle (in degrees): ");
        double angle = input.nextDouble();

        System.out.print("Enter track length (in meters): ");
        double trackLength = input.nextDouble();

        // Create an instance of RollerCoasterSimulator
        RollerCoasterSimulator sim = new RollerCoasterSimulator(height, angle, trackLength);

        // Get results
        double speed = sim.getSpeed();
        double time = sim.getTime();
        double gForce = sim.getGForce();

        System.out.println("--- Results ---");
        System.out.printf("Estimated Speed at Bottom: %.2f m/s%n", speed);
        System.out.printf("Time to Fall: %.2f seconds%n", time);
        System.out.printf("Estimated G-force in curve: %.1f Gs ", gForce);

        if (!sim.isSafe()) {
            System.out.println("TOO DANGEROUS!");
            System.out.println("Recommendation: Reduce hill height or increase curve radius.");
        } else {
            System.out.println("Safe for riders!");
        }

        System.out.println("--- Rounded Data ---");
        System.out.printf("Speed Rounded Up: %.1f m/s%n", Math.ceil(speed));
        System.out.printf("Time Rounded Down: %.1f sec%n", Math.floor(time));

        input.close();
    }
}