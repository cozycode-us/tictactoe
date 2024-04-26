import java.util.Scanner;

public class TicTacToeTester {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");

        while (!game.checkWin() && !isBoardFull(game)) {
            int row, col;

            // Print current board
            System.out.println("\nCurrent Game Board:");
            game.printBoard();

            // Get user input for row and column
            do {
                System.out.print("\nPlayer " + (game.getTurn() % 2 == 0 ? "X" : "O") + ", enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Player " + (game.getTurn() % 2 == 0 ? "X" : "O") + ", enter column (0-2): ");
                col = scanner.nextInt();
            } while (!isValidInput(row, col, game));

            // Take the turn
            game.takeTurn(row, col);

            // Check for a winner
            if (game.checkWin()) {
                System.out.println("\nPlayer " + (game.getTurn() % 2 == 1 ? "X" : "O") + " wins!");
            } else if (isBoardFull(game)) {
                System.out.println("\nIt's a tie!");
            }
        }
    }

    // Helper method to check if the board is full
    private static boolean isBoardFull(TicTacToe game) {
        for (String[] row : game.getBoard()) {
            for (String cell : row) {
                if (cell.equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper method to check if the user input is valid
    private static boolean isValidInput(int row, int col, TicTacToe game) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid input! Row and column must be between 0 and 2.");
            return false;
        } else if (!game.pickLocation(row, col)) {
            System.out.println("Invalid input! That position is already taken.");
            return false;
        }
        return true;
    }
}
