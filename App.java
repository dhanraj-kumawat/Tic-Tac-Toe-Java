import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;

        newBoard(board);

        while (!gameOver) {
            printBoard(board);
            boolean checkDraw = isDraw(board);
            if(checkDraw){
                gameOver = true;
                System.out.println("game is draw");
            }

            if (!gameOver) {
                System.out.println("Player " + player + " turn: ");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (row < 3 && col < 3 && board[row][col] == '|') {
                    board[row][col] = player;
                    gameOver = haveWon(board, player);

                    if (gameOver && checkDraw == false) {
                        printBoard(board);
                        System.out.println("player " + player + " won");
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }

                } else {
                    System.out.print("Invalid Move! Try again\n");
                }
            }
        }
    }

    // to clear the board
    private static void newBoard(char board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '|';
            }
        }
    }

    // print the board
    private static void printBoard(char board[][]) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // check win
    private static boolean haveWon(char board[][], char player) {
        // check rows0
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }
        // for cols
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // check Draw

    private static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '|')
                    return false;
            }
        }
        return true;
    }
}