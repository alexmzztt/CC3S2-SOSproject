public class Board {
    int row;
    int column;
    String[][] array;

    void setBoard(int row, int column) {
        array = new String[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = " ";
            }
        }
    }

    void printBoard() {
        System.out.print("\n  | ");

        for (int i = 1; i <= row; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n--------------------------");
        for (int i = 0; i < row; i++) {
            System.out.print(i+1 + " | ");
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    String getCell(int i, int j) {
        return array[i][j];
    }

    boolean isEmpty(int row, int column) {
        return getCell(row,column).equals(" ");
    }

    boolean gameOver(int modo , Jugador jugador) {
        if (modo == 1){
            if (jugador.puntaje > 0) return true;
            return false;
        }
        else{
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (isEmpty(i,j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}