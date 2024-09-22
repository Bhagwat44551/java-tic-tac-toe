import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOn = true;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (gameOn) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOn = false;
                } else if (isBoardFull()) {
                    System.out.println("The game is a tie!");
                    gameOn = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }

        scanner.close();
    }

    // Method to print the board
    public static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    // Method to check for a winner
    public static boolean checkWinner(char player) {
        // Check rows, columns, and diagonals
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||  // Row 1
               (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||  // Row 2
               (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||  // Row 3
               (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||  // Column 1
               (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||  // Column 2
               (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||  // Column 3
               (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||  // Diagonal 1
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);    // Diagonal 2
    }

    // Method to check if the board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
