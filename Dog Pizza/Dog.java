public class Dog
{
    // Instance variables: each Dog object gets its own copy of these
    private String breed;   // the dog's breed, e.g. "Golden Retriever"
    private String name;    // the dog's name, e.g. "Sammy"

    // Constructor: runs when "new Dog(...)" is called
    // Parameters come in the order breed first, then name
    public Dog(String breed, String name)
    {
        // "this." refers to the instance variable, not the parameter with the same name
        this.breed = breed;
        this.name = name;
    }

    // This method works once you finish the instance variables and the constructor.
    // DO NOT modify this method.
    public String toString()
    {
        return name + " is a " + breed;
    }
}