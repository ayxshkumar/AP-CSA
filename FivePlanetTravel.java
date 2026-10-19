// Name:          Ayush Kumar
// Partner:       None
// Course:        AP Computer Science A
// Instructor:    Mr. Virak
// Assignment:    1.05.1 - FivePlanetTravel
// Due Date:      August 24, 2026

public class FivePlanetTravel
{
  public static void main(String[] args)
  {
    // theplanets.org average distance from earth to the planets
    int mercury = 56974146;
    int venus = 25724767;
    int mars = 48678219;
    int jupiter = 390674710;
    int saturn = 792248270;

    // number of planets to visit
    int numPlanets = 5;

    // speed of light and our speed
    int lightSpeed =  670616629;
    lightSpeed /= 10;

    // total travel time
    double total = 0;

    int mercuryTime = mercury / lightSpeed;
    int venusTime   = venus   / lightSpeed;
    int marsTime    = mars    / lightSpeed;
    int jupiterTime = jupiter / lightSpeed;
    int saturnTime  = saturn  / lightSpeed;

    System.out.println("Travel time to ...");
    System.out.println("Mercury: " + mercuryTime + " hours");
    System.out.println("Venus: "   + venusTime   + " hours");
    System.out.println("Mars: "    + marsTime    + " hours");
    System.out.println("Jupiter: " + jupiterTime + " hours");
    System.out.println("Saturn: "  + saturnTime  + " hours");

    total += mercuryTime;
    total += venusTime;
    total += marsTime;
    total += jupiterTime;
    total += saturnTime;
    System.out.println("Total travel time:" + total);

    System.out.println();
    total = 0;

    // printf with %.10f shows each exact travel time to 10 decimal places
    System.out.println("Travel time to ...");
    System.out.printf("Mercury: %.10f hours%n", mercury / (double) lightSpeed);
    System.out.printf("Venus: %.10f hours%n",   venus   / (double) lightSpeed);
    System.out.printf("Mars: %.10f hours%n",    mars    / (double) lightSpeed);
    System.out.printf("Jupiter: %.10f hours%n", jupiter / (double) lightSpeed);
    System.out.printf("Saturn: %.10f hours%n",  saturn  / (double) lightSpeed);

    total += mercury / (double) lightSpeed;
    total += venus   / (double) lightSpeed;
    total += mars    / (double) lightSpeed;
    total += jupiter / (double) lightSpeed;
    total += saturn  / (double) lightSpeed;
    System.out.println("Total travel time:" + total);

    System.out.println();
    int average = (int) Math.round(total / numPlanets);
    System.out.println("Average travel time: approximately " + average + " hours.");
  }
}