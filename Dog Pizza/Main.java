/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Class:       AP Computer Science A
 * Teacher:     Mr. Virak
 * Date:        9/25/26
 * Assignment:  a.13.4 - Dog and Pizza Classes
 * Description: This assignment finishes a partly written Dog class (Part A) and builds a
 *              Pizza class from scratch (Part B). Main creates objects of
 *              each class and prints them directly, which calls each
 *              object's toString() method automatically.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Part A: create a Dog (breed first, then name) and print it
        Dog golden = new Dog("Golden Retriever", "Sammy");
        System.out.println(golden);   // println calls golden.toString()

        // Part B: create three Pizza objects (size, type, toppings)
        Pizza veggie = new Pizza(12, "Veggie", "Tomatoes, onions, olives");
        Pizza cheese = new Pizza(15, "Cheese", "Cheese");
        Pizza meat = new Pizza(20, "Meat", "Pepperoni, sausage, bacon");

        // Print each pizza directly; println uses each object's toString()
        System.out.println(veggie);
        System.out.println(cheese);
        System.out.println(meat);
    }
}