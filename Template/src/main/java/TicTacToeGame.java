import java.util.Scanner;

public class TicTacToeGame extends Game {

    private char[][] board;
    private int numberOfPlayers;
    private int turnsPlayed;
    private int winner = -1;
    private boolean gameEnded = false;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        board = new char[3][3];
        turnsPlayed = 0;

        // fill with blanks
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';

        System.out.println("=== TIC TAC TOE GAME START ===");
        printBoard();
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("Player " + player + " (" + playerMark(player) + "), choose your move!");

        int row, col;
        while (true) {
            System.out.print("Row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Col (0-2): ");
            col = scanner.nextInt();

            if (validMove(row, col))
                break;
            System.out.println("Invalid move — try again.");
        }

        board[row][col] = playerMark(player);
        turnsPlayed++;

        printBoard();

        if (checkWinner(playerMark(player))) {
            winner = player;
            gameEnded = true;
        } else if (turnsPlayed == 9) {
            gameEnded = true; // draw
        }
    }

    @Override
    public void displayWinner() {
        if (winner == -1) {
            System.out.println("Game ended in a DRAW.");
        } else {
            System.out.println("Player " + winner + " (" + playerMark(winner) + ") wins!");
        }
    }

    // ------------ Helper methods ------------------

    private char playerMark(int player) {
        return player == 0 ? 'X' : 'O';
    }

    private boolean validMove(int row, int col) {
        return row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == ' ';
    }

    private boolean checkWinner(char mark) {
        // rows
        for (int i = 0; i < 3; i++)
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark)
                return true;

        // cols
        for (int i = 0; i < 3; i++)
            if (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)
                return true;

        // diagonals
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark)
            return true;

        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark)
            return true;

        return false;
    }

    private void printBoard() {
        System.out.println("------");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + "|" + board[i][1] + "|" + board[i][2]);
            System.out.println("------");
        }
    }
}