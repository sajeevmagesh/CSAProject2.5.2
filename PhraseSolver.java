import java.util.Scanner;

public class PhraseSolver {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean gameSolved;

    public PhraseSolver(String playerName1, String playerName2) {
        player1 = new Player(playerName1);
        player2 = new Player(playerName2);
        board = new Board();
        gameSolved = false;
    }

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

    public void play() {
        boolean solved = false;
        int currentPlayer = 1;

        Scanner input = new Scanner(System.in);

        while (!solved) {
            System.out.println("Current Board: " + board.getSolvedPhrase());

            Player currentPlayerObj = (currentPlayer == 1) ? player1 : player2;
            Player otherPlayer = (currentPlayer == 1) ? player2 : player1;

            System.out.print(currentPlayerObj.getName() + ", enter a letter guess: ");
            String guess = input.next();

            boolean guessResult = board.guessLetter(guess);

            if (guessResult) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess. " + otherPlayer.getName() + "'s turn.");
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }

            if (board.getPhrase().equalsIgnoreCase(board.getSolvedPhrase().replaceAll(" ", ""))) {
                solved = true;
                System.out.println(currentPlayerObj.getName() + " wins!");
            }
        }
    }
}
