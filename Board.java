import java.util.Scanner;
import java.io.File;

public class Board {
    private String solvedPhrase;       // The phrase with solved letters
    private String phrase;             // The original phrase to guess
    private int currentLetterValue;    // The current value of a letter (unused)

    // Constructor to initialize the Board object
    public Board() {
        solvedPhrase = "";             // Initialize solvedPhrase as an empty string
        phrase = loadPhrase();         // Load a random phrase from the file
        currentLetterValue = 0;        // Initialize currentLetterValue to 0 (unused)
    }

    // Getter method for retrieving the solved phrase
    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    // Getter method for retrieving the original phrase to guess
    public String getPhrase() {
        return phrase;
    }

    // Getter method for retrieving the current letter value (unused)
    public int getCurrentLetterValue() {
        return currentLetterValue;
    }

    // Setter method for setting the solved phrase
    public void setSolvedPhrase(String solvedPhrase) {
        this.solvedPhrase = solvedPhrase;
    }

    // Setter method for setting the original phrase to guess
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    // Setter method for setting the current letter value (unused)
    public void setCurrentLetterValue(int currentLetterValue) {
        this.currentLetterValue = currentLetterValue;
    }

    // Method to set the current letter value randomly (unused)
    public void setLetterValue() {
        int randomInt = (int) ((Math.random() * 10) + 1) * 100;
        currentLetterValue = randomInt;
    }

    // Method to check if a guess matches the original phrase
    public boolean isSolved(String guess) {
        return phrase.equals(guess);
    }

    // Method to load a random phrase from a file
    private String loadPhrase() {
        String tempPhrase = "";
        int numOfLines = 0;
        try {
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try {
            int count = 0;
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        // Initialize solvedPhrase with underscores for each letter in the phrase
        for (int i = 0; i < tempPhrase.length(); i++) {
            if (tempPhrase.substring(i, i + 1).equals(" ")) {
                solvedPhrase += "  ";  // Preserve spaces in solvedPhrase
            } else {
                solvedPhrase += "_ ";  // Replace letters with underscores
            }
        }

        return tempPhrase;
    }

    // Method to guess a letter and update the solved phrase
    public boolean guessLetter(String guess) {
        boolean foundLetter = false;
        StringBuilder newSolvedPhrase = new StringBuilder();

        // Iterate through the original phrase
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(guess)) {
                newSolvedPhrase.append(guess).append(" ");  // Add the guessed letter
                foundLetter = true;
            } else {
                // Preserve existing solved letters or spaces
                newSolvedPhrase.append(solvedPhrase.substring(i * 2, i * 2 + 1)).append(" ");
            }
        }
        solvedPhrase = newSolvedPhrase.toString();  // Update the solved phrase
        return foundLetter;
    }
}
