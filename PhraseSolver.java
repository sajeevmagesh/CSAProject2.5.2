import java.util.Scanner;

// Define the main class for the PhraseSolver game
public class PhraseSolver {
    // Declare private class members
    private Player player1;         // Player 1
    private Player player2;         // Player 2
    private Board board;            // Game board
    private boolean gameSolved;    // Flag to check if the game is solved

    // Constructor for initializing the game with player names
    public PhraseSolver(String playerName1, String playerName2) {
        player1 = new Player(playerName1);   // Create Player 1 object
        player2 = new Player(playerName2);   // Create Player 2 object
        board = new Board();                // Create the game board
        gameSolved = false;                 // Initialize gameSolved to false
    }

    // Getter methods for accessing private members
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameSolved() {
        return gameSolved;
    }

    // Setter methods for modifying private members
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameSolved(boolean gameSolved) {
        this.gameSolved = gameSolved;
    }

    // Method to start and play the game
    public void play() {
        boolean solved = false;           // Flag to check if the game is solved
        int currentPlayer = 1;           // Initialize the current player as Player 1

        Scanner input = new Scanner(System.in);  // Create a Scanner object for user input

        // Main game loop
        while (!solved) {
            // Display the current state of the board
            System.out.println("Current Board: " + board.getSolvedPhrase());

            // Determine which player's turn it is
            Player currentPlayerObj = (currentPlayer == 1) ? player1 : player2;
            Player otherPlayer = (currentPlayer == 1) ? player2 : player1;

            // Prompt the current player for a letter guess
            System.out.print(currentPlayerObj.getName() + ", enter a letter guess: ");
            String guess = input.next();

            // Check if the guess is correct and update the board
            boolean guessResult = board.guessLetter(guess);

            if (guessResult) {
                System.out.println("Correct guess!");
            } else {
                // Incorrect guess, switch to the other player's turn
                System.out.println("Incorrect guess. " + otherPlayer.getName() + "'s turn.");
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }

            // Check if the game has been solved
            if (board.getPhrase().equalsIgnoreCase(board.getSolvedPhrase().replaceAll(" ", ""))) {
                solved = true;
                System.out.println(currentPlayerObj.getName() + " wins!");
            }
        }
    }
}
