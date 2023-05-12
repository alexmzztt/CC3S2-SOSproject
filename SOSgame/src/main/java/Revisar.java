public class Revisar {
    Board board;
    boolean otroTurno = false; //jugar otro turno al realizar un SOS
    int cantSOS = 0; //cantidad de SOS

    public Revisar (Board board) {
        this.board = board;
    }

    //revisa si se realizo un SOS horizontal
    int SOShorizontal(int count) {
        for (int i = 0; i < board.column - 2; i++) {
            for (int j = 0; j < board.row - 1; j++) {
                if (board.array[i][j].equals("S") && board.array[i][j + 1].equals("O") && board.array[i][j + 2].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    //revisa si se realizo un SOS vertical
    int SOSvertical(int count) {
        for (int i = 0; i < board.column - 1; i++) {
            for (int j = 0; j < board.row - 2; j++) {
                if (board.array[i][j].equals("S") && board.array[i + 1][j].equals("O") && board.array[i + 2][j].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    //revisa si se realizo un SOS diagonal
    int SOSdiagonal(int count) {
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

    int incPuntaje(int modo, Jugador jugador) { //suma el puntaje
        int count = 0; //contador
        int puntaje = 0; //puntaje

        //suma los contadores
        count = SOShorizontal(count);
        count = SOSvertical(count);
        count = SOSdiagonal(count);

        if (count > cantSOS) {
            puntaje = count - cantSOS;
            cantSOS = count;
            if (count != 1) otroTurno = !board.gameOver(modo, jugador);
        }
        return puntaje;
    }
}