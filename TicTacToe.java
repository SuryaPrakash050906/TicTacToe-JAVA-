package JAVA;

import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        System.out.println("===== TIC TAC TOE GAME =====");

        while (!gameOver) {

            printBoard();

            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input!");
                sc.next();
                continue;
            }

            int position = sc.nextInt();

            if (placeMark(position)) {

                if (checkWin()) {

                    printBoard();
                    System.out.println("Player " + currentPlayer + " Wins!");
                    gameOver = true;

                } else if (checkDraw()) {

                    printBoard();
                    System.out.println("Game Draw!");
                    gameOver = true;

                } else {

                    changePlayer();
                }

            } else {

                System.out.println("Invalid Move! Try Again.");
            }
        }

        sc.close();
    }

    // Display Board
    public static void printBoard() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            System.out.println(" " + board[i][0] + " | "
                    + board[i][1] + " | "
                    + board[i][2]);

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    // Place Mark
    public static boolean placeMark(int position) {

        if (position < 1 || position > 9) {
            return false;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (board[row][col] != 'X' && board[row][col] != 'O') {

            board[row][col] = currentPlayer;
            return true;
        }

        return false;
    }

    // Change Player
    public static void changePlayer() {

        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // Check Win
    public static boolean checkWin() {

        // Rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer) {

                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {

            if (board[0][i] == currentPlayer &&
                    board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer) {

                return true;
            }
        }

        // Diagonals
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) {

            return true;
        }

        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer) {

            return true;
        }

        return false;
    }

    // Check Draw
    public static boolean checkDraw() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] != 'X' &&
                        board[i][j] != 'O') {

                    return false;
                }
            }
        }

        return true;
    }
}