public class Revisar {
    Board board;
    boolean secondChance = false;
    int sosNum = 0;
    public int modo;
    public Revisar(Board board) {
        this.board = board;
    }

    int horizontalCheck(int count) {
        for(int i = 0; i < this.board.column - 3; ++i) {
            for(int j = 0; j < this.board.row - 1; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i][j + 1].equals("O") && this.board.array[i][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int verticalCheck(int count) {
        for(int i = 0; i < this.board.column - 1; ++i) {
            for(int j = 0; j < this.board.row - 3; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i + 1][j].equals("O") && this.board.array[i + 2][j].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int diagonalCheck(int count) {
        int i;
        int j;
        for(i = 0; i < this.board.column - 2; ++i) {
            for(j = 0; j < this.board.row - 2; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i + 1][j + 1].equals("O") && this.board.array[i + 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 0; i < this.board.column - 2; ++i) {
            for(j = 2; j < this.board.row; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i + 1][j - 1].equals("O") && this.board.array[i + 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < this.board.column; ++i) {
            for(j = 0; j < this.board.row - 2; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i - 1][j + 1].equals("O") && this.board.array[i - 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < this.board.column; ++i) {
            for(j = 2; j < this.board.row; ++j) {
                if (this.board.array[i][j].equals("S") && this.board.array[i - 1][j - 1].equals("O") && this.board.array[i - 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int incScore(Jugador.Player jugador) {
        int count = 0;
        int score = 0;
        count = this.horizontalCheck(count);
        count = this.verticalCheck(count);
        count = this.diagonalCheck(count);
        if (count > this.sosNum) {
            score = count - this.sosNum;
            this.sosNum = count;
            this.secondChance = !this.board.isOver(modo, jugador);
        }

        return score;
    }
}
