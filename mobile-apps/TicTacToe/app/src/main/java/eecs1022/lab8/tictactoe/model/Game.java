package eecs1022.lab8.tictactoe.model;

public class Game {

    String p1name;
    String p2name;
    char[][] board = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };;
    boolean turn = true;
    boolean error = false;
    String errorString;

    boolean win = false;
    String winString = "";

    public Game(String p1, String p2) {
        this.p1name = p1;
        this.p2name = p2;
    }


    public String getCurrentPlayer() {
        String result = "";
        if (this.win == true) {
            result = null;
        } else if (this.turn == true) {
            result = this.p1name;
        } else if (this.turn == false) {
            result = this.p2name;
        }
        return result;
    }

    public String getStatus() {
        String result = "";
        if (this.error == true) {
            result = this.errorString;
        }else if (this.win == true) {
            result = this.winString;
        } else {
            result = getCurrentPlayer() + "'s turn to play...";
        }

        return result;
    }

    public char[][] getBoard() {

        return this.board;
    }

    public void setWhoPlaysFirst(char player) {
        if (player == 'x') {
            this.turn = true;
        } else if (player == 'o') {
            this.turn = false;
        }
    }

    public void move(int row, int col) {
        if (this.win == true) {
            this.error = true;
            this.errorString = "Error: game is already over with a winner.";
        } else if (row < 1) {
            this.error = true;
            this.errorString = "Error: row " + row +" is invalid.";
        } else if (row > 3) {
            this.error = true;
            this.errorString = "Error: row " + row +" is invalid.";
        } else if (col < 1) {
            this.error = true;
            this.errorString = "Error: col " + col +" is invalid.";
        } else if (col > 3) {
            this.error = true;
            this.errorString = "Error: col " + col +" is invalid.";
        } else {
            if (board[row - 1][col - 1] != '_') {
                this.error = true;
                this.errorString = "Error: slot @ (" + row +", " + col +") is already occupied.";
            } else {
                this.error = false;
                if (this.turn == true) {
                    this.board[row - 1][col - 1] = 'x';
                    this.turn = false;
                } else if (this.turn == false) {
                    this.board[row - 1][col - 1] = 'o';
                    this.turn = true;
                }
                checkWin();
            }
        }
    }

    public void checkWin() {
        if (this.board[0][0] == 'x' && this.board[1][1] == 'x' && this.board[2][2] == 'x') {
            this.win = true;
            this.winString = "Game is over with " + p1name + " being the winner.";
        } else if (this.board[0][2] == 'x' && this.board[1][1] == 'x' && this.board[2][0] == 'x') {
            this.win = true;
            this.winString = "Game is over with " + p1name + " being the winner.";
        } else if (this.board[0][0] == 'o' && this.board[1][1] == 'o' && this.board[2][2] == 'o') {
            this.win = true;
            this.winString = "Game is over with " + p2name + " being the winner.";
        } else if (this.board[0][2] == 'o' && this.board[1][1] == 'o' && this.board[2][0] == 'o') {
            this.win = true;
            this.winString = "Game is over with " + p2name + " being the winner.";
        } else {
            checkStrightWin();
        }
    }

    public void checkStrightWin() {
        for (int i = 0; i < 3; i++) {
            if (this.win == true) {
                break;
            }
            if (this.board[0][i] == 'x' && this.board[1][i] == 'x' && this.board[2][i] == 'x') {
                this.win = true;
                this.winString = "Game is over with " + p1name + " being the winner.";
            } else if (this.board[i][0] == 'x' && this.board[i][1] == 'x' && this.board[i][2] == 'x') {
                this.win = true;
                this.winString = "Game is over with " + p1name + " being the winner.";
            } else if (this.board[0][i] == 'o' && this.board[1][i] == 'o' && this.board[2][i] == 'o') {
                this.win = true;
                this.winString = "Game is over with " + p2name + " being the winner.";
            } else if (this.board[i][0] == 'x' && this.board[i][1] == 'x' && this.board[i][2] == 'x') {
                this.win = true;
                this.winString = "Game is over with " + p2name + " being the winner.";
            }
        }
    }

}
