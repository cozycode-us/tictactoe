/*INSTRUCTIONS:
(DONE)  Create a TicTacToe class that initializes a 3x3 board of "-" values.

    The TicTacToe class should have a 2D array as an instance variable and a constructor that initializes the 2D array with the "-" value.

    Add a getter method that returns the private 2D instance variable.*/
public class TicTacToe {
private String[][] board;

public TicTacToe() {
    board = new String[3][3];
    for (int row = 0; row < 3; row++) {
        for (int play = 0; play < 3; play++) {
            board[row][play] = "-";
        }
    }
}
public String[][] getBoard() {
    return board;
}
}
