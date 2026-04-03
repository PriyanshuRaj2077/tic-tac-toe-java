import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        initializeBoard();

        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter row and column (0-2): ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already taken, try again.");
            }
        }

        sc.close();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin() {
        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }
        }

        // columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '-' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return true;
            }
        }

        // diagonals
        if (board[0][0] != '-' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != '-' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}