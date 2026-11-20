/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.06.03 Library Return Desk: Comparing Objects
 * Due Date:    November 20, 2026
 *
 * Description: A Book stores a title and an author. sameBook compares two books by
 * their content (title and author, ignoring capitalization) instead of by reference.
 */
public class Book
{
    private String title;
    private String author;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    // returns true if other is not null and has the same
    // title and author (ignoring case)
    public boolean sameBook(Book other)
    {
        // other != null is on the left, so if other is null, && short-circuits and
        // other.getTitle() is never called (no NullPointerException)
        return other != null && title.equalsIgnoreCase(other.getTitle())
                && author.equalsIgnoreCase(other.getAuthor());
    }

    @Override
    public String toString()
    {
        return "\"" + title + "\" by " + author;
    }
}