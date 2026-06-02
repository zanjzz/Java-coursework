package week_7;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Board currentBoard = new Board();
        char currentPlayer = 'X';
        boolean gameNotOver = true;
        
        // Loop prompts until the game ends
        while (gameNotOver) {
            
            // Prompt users
            currentBoard.displayBoard();
            currentPlayer = promptUser(currentPlayer, currentBoard, scanner);
            
            // Check game status
            char winner = currentBoard.checkWinner();
            if (winner != 'n') {
                currentBoard.displayBoard();
                if (winner == 't') {
                    System.out.println("\nGame ended, it's a Tie!");
                    gameNotOver = false;
                } else {
                    System.out.println("\nCongratulations Player " + winner + "! You are the winner.");
                    break;
                }
            }            
        }  
        scanner.close();
    }
    
    public static char promptUser(char currentPlayer, Board currentBoard, Scanner scanner) {
        if (currentPlayer == 'X') {
            System.out.print("Player X's turn, Enter row and column (r c): ");
            inputHandling(currentBoard, currentPlayer, scanner);       
            currentPlayer = 'O';
        } else {
            System.out.print("Player O's turn, Enter row and column (r c): ");
            inputHandling(currentBoard, currentPlayer, scanner);
            currentPlayer = 'X';
        }
        return currentPlayer;
    }
    
    public static void inputHandling(Board currentBoard, char currentPlayer, Scanner scanner) {
        int row = 0, column = 0;
        // This will prevent string inputs and invalid ranges
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.print("Please enter integers (1-3): ");
                scanner.nextLine(); // clear entire bad input
                continue;
            }
            row = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.print("Please enter integers (1-3): ");
                scanner.nextLine();
                continue;
            }
            column = scanner.nextInt();

            scanner.nextLine(); // clear leftover newline

            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.print("Invalid Range, Please try again: ");
                continue;
            }

            if (currentBoard.board[row - 1][column - 1] != ' ') {
                System.out.print("Square already taken! Try again: ");
                continue;
            }

            currentBoard.addValue(row, column, currentPlayer);
            break;
        }
        
    }
    
}

class Board {
    char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    
    void addValue(int row, int column, char player) {
        // This will add value in the board and fix the index as well
        if (player == 'X') {
            board[row - 1][column - 1] = 'X';
        } else if  (player == 'O') {
            board[row - 1][column - 1] = 'O';    
        }
    }

    void displayBoard() {
        // Displaying the board using for loop
        System.out.println("Current Board: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("--+---+--");
            }
        }
    }
    
    char checkWinner() {
        char winner = 'n';
        
        // Check horizontal and vertical combinations using loop
        for (int i = 0; i < 3; i++) {
            // For row winner
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                return board[i][0];
            // For column winner
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
                return board[0][i]; 
        }
        
        // Check diagonal combinations efficiently
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        
        return checkDraw() ? 't' : winner;
    } 
    
    boolean checkDraw() {
        // Check if tie
        boolean isTie = true;
        outer:
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
                if (board[row][column] == ' ') {
                    isTie = false;
                    break outer;
                }
            }
        }
        return isTie;
    }
}
