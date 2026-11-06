// Name:          Ayush Kumar
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.7.3 - Heap Detective: Tracing References and Memory
// Due Date:      9/4/26
//
// Explanation: sameBag = myBag copies the address stored in myBag, so both
// variables point to the same Backpack object in the heap. Adding an item 
// through one is visible through the other because there is only one object. 
// differentBag was created with its own new Backpack(), so it points to a 
// separate object with its own item field.

public class Main {
    public static void main(String[] args) {

        Backpack myBag = new Backpack();
        Backpack sameBag = myBag;

        sameBag.addItem("pencil");

        Backpack differentBag = new Backpack();
        differentBag.addItem("notebook");

        System.out.println("myBag content:        " + myBag.getItem());
        System.out.println("sameBag content:      " + sameBag.getItem());
        System.out.println("differentBag content: " + differentBag.getItem());
        System.out.println();
        System.out.println("myBag reference:        " + myBag);
        System.out.println("sameBag reference:      " + sameBag);
        System.out.println("differentBag reference: " + differentBag);
    }
}