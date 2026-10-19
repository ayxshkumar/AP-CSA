// Name:          [Ayush Kumar]
// Partner:       [None]
// Course:        AP Computer Science A
// Instructor:    [Mr.Virak]
// Assignment:    1.13.1 — Bakery Order System: Building Multiple Constructors
// Due Date:      [9/16/26]

public class Bakery {
    public static void main(String[] args) {

        // TODO 1: Create an Order using the no-argument constructor (default values)
        Order order1 = new Order();

        // TODO 2: Create an Order using the one-parameter constructor
        Order order2 = new Order("Birthday Cake");

        // TODO 3: Create an Order using the two-parameter constructor
        Order order3 = new Order("Cupcake", 6);

        // TODO 4: Create an Order using the four-parameter constructor
        Order order4 = new Order("Wedding Cake", 3, "Large", true);

        // TODO 5: Call printOrder() on all four objects to demonstrate each constructor
        order1.printOrder();
        order2.printOrder();
        order3.printOrder();
        order4.printOrder();
    }
}