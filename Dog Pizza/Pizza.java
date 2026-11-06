public class Pizza
{
    // Instance variables: private so only Pizza's own methods can change them
    private int size;         // diameter of the pizza in inches
    private String type;      // kind of pizza, e.g. "Veggie"
    private String toppings;  // list of toppings as one String

    // Constructor: sets all three instance variables when a Pizza is created
    public Pizza(int size, String type, String toppings)
    {
        this.size = size;
        this.type = type;
        this.toppings = toppings;
    }

    // toString(): builds the text Java uses when this object is printed
    // Format: "<size> inch <type> pizza with <toppings>"
    public String toString()
    {
        return size + " inch " + type + " pizza with " + toppings;
    }
}