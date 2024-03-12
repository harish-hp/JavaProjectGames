package launchgame;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void dispBoard() {
        System.out.println("-------------------- ");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|  ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  |  ");

            }
            System.out.println();
            System.out.println("--------------------");
        }

    }

    static void placeMark(int row, int column, char mark) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            board[row][column] = mark;
        } else {
            System.out.println("Invalid Position");
        }
    }

    static boolean checkColWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }

        }
        return false;
    }

    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }

        }
        return false;

    }

    static boolean checkDigWin() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

abstract class Player {

    String name;
    char mark;

    abstract void makeMove();

    boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
}

class HumanPlayer extends Player {

    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the Row :");
            row = scan.nextInt();
            System.out.println("Enter the Column :");
            col = scan.nextInt();
        } while (!isValidMove(row, col));

        TicTacToe.placeMark(row, col, mark);

    }

}

class BotPlayer extends Player {

    BotPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner scan = new Scanner(System.in);
        int row;
        int col;
        do {
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);

        } while (!isValidMove(row, col));

        TicTacToe.placeMark(row, col, mark);

    }

}

public class LaunchGame {

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int opt;
        while (true) {
            System.out.println("Let's Play Tic Tac Toe . Select The mode \n1.Pass&Play \n2.Bot Player");
            opt = sc.nextInt();
            if (opt == 1 || opt == 2) {
                System.out.println("Game Begins");
                break;
            } else {
                System.out.println("Enter valid Option ...");
            }
        }
        HumanPlayer p1 = new HumanPlayer("Iron Man", 'X');
        HumanPlayer p2 = new HumanPlayer("Captian America", 'O');
        BotPlayer b1 = new BotPlayer("Jarvis", 'O');
        Player cp;
        cp = p1;
        while (true) {
            System.out.println(cp.name + " Make A Move ");
            cp.makeMove();
            TicTacToe.dispBoard();
            if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkRowWin()) {
                System.out.println(cp.name + " Has Won ....!");
                break;

            } else if (TicTacToe.checkDraw()) {
                System.out.println("Game is Draw ......");
                break;
            } else {
                if (cp == p1) {
                    if (opt == 2) {
                        cp = b1;
                    } else {
                        cp = p2;
                    }
                } else {
                    cp = p1;
                }
            }
        }
    }

}
