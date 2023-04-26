public class Board {
    int row;
    int column;
    String[][] array;

    public Board() {
    }

    void IniBoard(int row, int column) {//iniciamos el tablero con el numero de filas y columnas elegido

        array = new String[row][column];

        for(int i = 0; i < row; ++i) { //recorremos filas
            for(int j = 0; j < column; ++j) { //recorremos columnas
                array[i][j] = " ";
            }
        }

    }

    void printBoard() { //imprimimos tablero
        System.out.print("\n  | ");
        //imprimimos numeros de las columnas
        int i;
        for(i = 1; i <= row; ++i) {
            System.out.print("" + i + " ");
        }

        System.out.println("\n--------------------------");

        for(i = 0; i < row; ++i) {
            System.out.print(i + 1 + " | ");

            for(int j = 0; j < column; ++j) {
                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    String getCell(int i, int j) {
        return array[i][j];
    } //obtener una celda especifica

    boolean isEmpty(int row, int column) {
        return getCell(row, column).equals(" ");
    } //saber si la celda esta vacia

    boolean gameOver(int modo, Jugador jugador) { //saber si termino el juego
        if (modo == '1') { //modo simple
            if (jugador.puntaje > 0) {
                return true;
            }
        }
        else { //modo general
            for (int i = 0; i < column; ++i) {
                for (int j = 0; j < row; ++j) {
                    if (isEmpty(i, j)) {
                        return true;
                    }
                }
            }

        }
    return true;
    }
}
