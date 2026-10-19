public class Order {

    // Private instance variables to store order details
    private String itemName;
    private int quantity;
    private String size;
    private boolean isRush;

    // TODO 1: No-argument constructor — sets default values for a quick walk-in order
    public Order() {
        this.itemName = "Cake";
        this.quantity = 1;
        this.size = "Medium";
        this.isRush = false;
    }

    // TODO 2: One-parameter constructor — accepts custom itemName, defaults the rest
    public Order(String itemName) {
        this.itemName = itemName;
        this.quantity = 1;
        this.size = "Medium";
        this.isRush = false;
    }

    // TODO 3: Two-parameter constructor — accepts custom itemName and quantity
    public Order(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.size = "Medium";
        this.isRush = false;
    }

    // TODO 4: Four-parameter constructor — accepts full custom order parameters
    public Order(String itemName, int quantity, String size, boolean isRush) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.size = size;
        this.isRush = isRush;
    }

    // TODO 5: printOrder() — prints all four fields in a clean, formatted line
    public void printOrder() {
        System.out.println("Order: " + this.quantity + " " + this.size + " "
                + this.itemName + "(s)  |  Rush: " + this.isRush);
    }
}