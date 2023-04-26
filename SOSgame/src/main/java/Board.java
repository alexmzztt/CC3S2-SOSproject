public class Board {
    int row;
    int column;
    String[][] array;

    public Board() {
    }

    void setBoard(int r, int c) {
        row = r;
        column = c;
        array = new String[row][column];

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                array[i][j] = " ";
            }
        }

    }

    void printBoard() {
        System.out.print("\n  | ");

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
    }

    boolean isEmpty(int r, int c) {
        return getCell(r, c).equals(" ");
    }

    boolean isOver(int modo, Jugador jugador) {
        if (modo ==1){
            if(jugador.score > 0){

                return false;
            }
        }
        else {
            for(int i = 0; i < column; ++i) {
                for(int j = 0; j < row; ++j) {
                    if (isEmpty(i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
