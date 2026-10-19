// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.04.2 - Average Test Score / Cashier Totals
// Due Date:      August 24, 2026
import java.util.Scanner;

public class AverageTestScore {
    public static void main(String[] args) {
        // One Scanner for the whole program, shared with CashierTotals
        Scanner scanner = new Scanner(System.in);

        // Read all four scores as doubles so decimals like 87.5 don't crash the program
        System.out.println("Enter your first test score:");
        double firstScore = scanner.nextDouble();
        System.out.println("Enter your second test score:");
        double secondScore = scanner.nextDouble();
        System.out.println("Enter your third test score:");
        double thirdScore = scanner.nextDouble();
        System.out.println("Enter your fourth test score:");
        double fourthScore = scanner.nextDouble();

        // Add the four scores and divide by 4 to get the average
        double averageScore = (firstScore + secondScore + thirdScore + fourthScore) / 4;

        // Print the average rounded to two decimal places
        System.out.printf("Average Test Score: %.2f%n", averageScore);

        // Run the cashier program using the same Scanner
        CashierTotals.run(scanner);

        scanner.close();
    }
}

class CashierTotals {
    // Lets CashierTotals still run by itself, with its own Scanner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    // Does the cashier work using whichever Scanner is passed in
    public static void run(Scanner scanner) {
        System.out.println("---------------------------------");

        // Read how many of each item were ordered and what each one costs
        System.out.println("Enter the number of burgers ordered:");
        int burgersOrdered = scanner.nextInt();
        System.out.println("Price of a burger:");
        double burgerPrice = scanner.nextDouble();
        System.out.println("Enter the number of fries ordered:");
        int friesOrdered = scanner.nextInt();
        System.out.println("Price of fries:");
        double friesPrice = scanner.nextDouble();

        // Total items is the number of burgers plus the number of fries
        int itemsSold = burgersOrdered + friesOrdered;
        System.out.printf("Total Items Sold: %d%n", itemsSold);

        // Total sales is each quantity times its price, added together
        double totalSales = (burgersOrdered * burgerPrice) + (friesOrdered * friesPrice);
        System.out.printf("Total Sales: $%.2f%n", totalSales);
    }
}