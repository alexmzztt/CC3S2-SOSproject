public class Revisar {
    Board board;
    boolean secondChance = false;
    int sosNum = 0;

    public Revisar (Board board) {
        this.board = board;
    }

    int horizontalCheck(int count) {
        for (int i = 0; i < board.column - 2; i++) {
            for (int j = 0; j < board.row - 1; j++) {
                if (board.array[i][j].equals("S") && board.array[i][j + 1].equals("O") && board.array[i][j + 2].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    int verticalCheck(int count) {
        for (int i = 0; i < board.column - 1; i++) {
            for (int j = 0; j < board.row - 2; j++) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j].equals("O") && board.array[i + 2][j].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    int diagonalCheck(int count) {
        for (int i = 0; i < board.column - 2; i++) {
            for (int j = 0; j < board.row - 2; j++) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j + 1].equals("O") && board.array[i + 2][j + 2].equals("S")) {
                    count++;
                }
            }
        }

        for (int i = 0; i < board.column - 2; i++) {
            for (int j = 2; j < board.row; j++) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j - 1].equals("O") && board.array[i + 2][j - 2].equals("S")) {
                    count++;
                }
            }
        }

        return count;
    }

    int incScore(int modo, Jugador jugador) {
        int count = 0;
        int puntaje = 0;

        count = horizontalCheck(count);
        count = verticalCheck(count);
        count = diagonalCheck(count);

        if (count > sosNum) {
            puntaje = count - sosNum;
            sosNum = count;
            if (count != 1) secondChance = !board.gameOver(modo, jugador);
        }
        return puntaje;
    }
}