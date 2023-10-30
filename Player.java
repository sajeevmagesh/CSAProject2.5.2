import java.util.Scanner;

public class Player {
    private String name;
    private int points;

    public Player() {
        // Default constructor
        name = "";
        points = 0;
    }

    public Player(String inputName) {
        // Constructor with a name parameter
        name = inputName;
        points = 0;
        System.out.println("Welcome, " + name + ", to the game!");
    }

    // Accessor for getting the player's name
    public String getName() {
        return name;
    }

    // Accessor for getting the player's points
    public int getPoints() {
        return points;
    }

    // Mutator for setting the player's name
    public void setName(String inputName) {
        name = inputName;
    }

    // Mutator for updating the player's points
    public void setPoints(int newPoints) {
        points = newPoints;
    }
}
