public class Revisar {
    Board board;
    boolean secondChance = false;
    int sosNum = 0;
    public int modo;
    public Revisar(Board board) {
        board = board;
    }

    int horizontalCheck(int count) {
        for(int i = 0; i < board.column - 3; ++i) {
            for(int j = 0; j < board.row - 1; ++j) {
                if (board.array[i][j].equals("S") && board.array[i][j + 1].equals("O") && board.array[i][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int verticalCheck(int count) {
        for(int i = 0; i < board.column - 1; ++i) {
            for(int j = 0; j < board.row - 3; ++j) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j].equals("O") && board.array[i + 2][j].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int diagonalCheck(int count) {
        int i;
        int j;
        for(i = 0; i < board.column - 2; ++i) {
            for(j = 0; j < board.row - 2; ++j) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j + 1].equals("O") && board.array[i + 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 0; i < board.column - 2; ++i) {
            for(j = 2; j < board.row; ++j) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j - 1].equals("O") && board.array[i + 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < board.column; ++i) {
            for(j = 0; j < board.row - 2; ++j) {
                if (board.array[i][j].equals("S") && board.array[i - 1][j + 1].equals("O") && board.array[i - 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < board.column; ++i) {
            for(j = 2; j < board.row; ++j) {
                if (board.array[i][j].equals("S") && board.array[i - 1][j - 1].equals("O") && board.array[i - 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int incScore() {
        int count = 0;
        int score = 0;
        count = horizontalCheck(count);
        count = verticalCheck(count);
        count = diagonalCheck(count);
        if (count > sosNum) {
            score = count - sosNum;
            sosNum = count;
            secondChance = !board.isOver(modo, Jugador.jugador);
        }

        return score;
    }
}
