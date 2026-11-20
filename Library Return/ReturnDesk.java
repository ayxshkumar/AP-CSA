 /*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A
 * Instructor:  Mr. Virak
 * Assignment:  2.06.03 Library Return Desk: Comparing Objects
 * Due Date:    November 20, 2026
 *
 * Description: Tests how ==, !=, and .equals() behave on Book objects, then uses
 * sameBook to decide whether a returned book matches the book on record.
 */

/*
 * PART A PREDICTIONS (written before running)
 *
 * 1. checkedOut == myCopy -> true
 *    myCopy = checkedOut makes myCopy an alias, so both variables hold the same reference.
 * 2. checkedOut == shelfCopy -> false
 *    shelfCopy was made with its own "new", so it is a different object, even though
 *    the title and author are the same.
 * 3. checkedOut.equals(shelfCopy) -> false
 *    Book does not override equals, so it uses Object's equals, which compares
 *    references just like ==.
 * 4. checkedOut.getTitle().equals(shelfCopy.getTitle()) -> true
 *    getTitle() returns Strings, and String's equals compares the characters.
 *    Both titles are "Hatchet".
 *
 * RESULTS AFTER RUNNING
 * All four predictions were correct: true, false, false, true.
 */
public class ReturnDesk
{
    public static void main(String[] args)
    {
        Book checkedOut = new Book("Hatchet", "Gary Paulsen");
        Book shelfCopy = new Book("Hatchet", "Gary Paulsen");
        Book myCopy = checkedOut;
        Book returned = new Book("hatchet", "GARY PAULSEN");
        Book nothing = null;

        // PART A: write your predictions in a comment BEFORE running
        System.out.println("=== PART A: == vs. equals ===");
        System.out.println("checkedOut == myCopy:        " + (checkedOut == myCopy));
        System.out.println("checkedOut == shelfCopy:     " + (checkedOut == shelfCopy));
        System.out.println("checkedOut.equals(shelfCopy): " + checkedOut.equals(shelfCopy));
        System.out.println("checkedOut.getTitle().equals(shelfCopy.getTitle()): "
                           + checkedOut.getTitle().equals(shelfCopy.getTitle()));

        System.out.println();
        System.out.println("=== PART B: sameBook ===");
        System.out.println("checkedOut.sameBook(shelfCopy): " + checkedOut.sameBook(shelfCopy));
        System.out.println("checkedOut.sameBook(returned):  " + checkedOut.sameBook(returned));
        System.out.println("checkedOut.sameBook(nothing):   " + checkedOut.sameBook(nothing));

        System.out.println();
        System.out.println("=== PART C: Return desk ===");
        processReturn(checkedOut, returned);
        processReturn(checkedOut, new Book("Holes", "Louis Sachar"));
        processReturn(nothing, returned);
    }

    // Prints whether the returned book matches the book on record.
    // The null check has to come first: if onRecord is null, calling onRecord.sameBook(returned)
    // would throw a NullPointerException, because there is no object to call the method on.
    public static void processReturn(Book onRecord, Book returned)
    {
        if (onRecord == null)
        {
            System.out.println("No book on record. " + returned
                    + " goes to the lost-and-found cart.");
        }
        else if (onRecord.sameBook(returned))
        {
            System.out.println("Thank you! " + returned + " has been checked in.");
        }
        else
        {
            System.out.println("Mismatch: expected " + onRecord + " but received "
                    + returned + ".");
        }
    }
}

/*
 * THINK ABOUT IT
 *
 * 1. Why is checkedOut.equals(shelfCopy) false but the getTitle() version true?

 *    Book doesn't override equals, so checkedOut.equals(shelfCopy) uses Object's equals,
 *    which only checks whether they are the same object, and they aren't. getTitle()
 *    returns Strings, and String's equals compares the actual characters, which match.
 *
 * 2. What if processReturn checked onRecord.sameBook(returned) before checking for null?

 *    The third call, processReturn(nothing, returned), would crash with a
 *    NullPointerException, because onRecord is null and you can't call a method on null.
 *    The program would stop before printing the lost-and-found message.
 *
 * 3. What will a Book equals method need to compare?

 *    Like sameBook, it will need to check that the other object isn't null (and is a
 *    Book), then compare the title and the author of the two books, using String
 *    methods like equals or equalsIgnoreCase instead of ==.
 */