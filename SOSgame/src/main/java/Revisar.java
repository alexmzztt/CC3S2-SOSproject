public class Revisar {
    Board board;
    boolean secondChance = false; //si se tiene una segunda oportunidad
    int cantSOS = 0; //cantidad de SOS
    public int modo;
    public int oponente;
    public Revisar(Board board) {
        board = board;
    }

    //SOS horizontal
    int horizontalCheck(int count) {
        for(int i = 0; i < board.column - 3; ++i) { //columnas
            for(int j = 0; j < board.row - 1; ++j) {  //filas
                //el contador aumenta si se encuentra un SOS
                if (board.array[i][j].equals("S") && board.array[i][j + 1].equals("O") && board.array[i][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    //SOS vertical
    int verticalCheck(int count) {
        for(int i = 0; i < board.column - 1; ++i) { //columnas
            for(int j = 0; j < board.row - 3; ++j) { //filas
                //si encuentra SOS el cont aumenta
                if (board.array[i][j].equals("S") && board.array[i + 1][j].equals("O") && board.array[i + 2][j].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    //SOS diagonal
    int diagonalCheck(int count) {
        int i;
        int j;
        for(i = 0; i < board.column - 2; ++i) {
            for(j = 0; j < board.row - 2; ++j) {
                //el cont aumenta si encuentra un SOS
                if (board.array[i][j].equals("S") && board.array[i + 1][j + 1].equals("O") && board.array[i + 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 0; i < board.column - 2; ++i) {
            for(j = 2; j < board.row; ++j) {
                //el cont aumenta si encuentra un SOS
                if (board.array[i][j].equals("S") && board.array[i + 1][j - 1].equals("O") && board.array[i + 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < board.column; ++i) {
            for(j = 0; j < board.row - 2; ++j) {
                //el cont aumenta si encuentra un SOS
                if (board.array[i][j].equals("S") && board.array[i - 1][j + 1].equals("O") && board.array[i - 2][j + 2].equals("S")) {
                    ++count;
                }
            }
        }

        for(i = 2; i < board.column; ++i) {
            for(j = 2; j < board.row; ++j) {
                //el cont aumenta si encuentra un SOS
                if (board.array[i][j].equals("S") && board.array[i - 1][j - 1].equals("O") && board.array[i - 2][j - 2].equals("S")) {
                    ++count;
                }
            }
        }

        return count;
    }

    int Score() {
        int count = 0; //inicializamos contador en 0
        int puntaje = 0; //inicializamos puntaje en 0
        //verificamos
        count = horizontalCheck(count);
        count = verticalCheck(count);
        count = diagonalCheck(count);
        //se aumenta la puntuacion
        if (count > cantSOS) {
            puntaje = count - cantSOS;
            cantSOS = count;
            //segunda oportunidad si el juego aun no acaba
            secondChance = !board.gameOver(modo, Jugador.jugador);
        }

        return puntaje;
    }
}
