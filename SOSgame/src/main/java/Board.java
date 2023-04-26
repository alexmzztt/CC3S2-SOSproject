public class Board {
    int row;
    int column;
    String[][] array;

    public Board() {
    }

    void setBoard(int r, int c) {
        this.row = r;
        this.column = c;
        this.array = new String[this.row][this.column];

        for(int i = 0; i < this.row; ++i) {
            for(int j = 0; j < this.column; ++j) {
                this.array[i][j] = " ";
            }
        }

    }

    void printBoard() {
        System.out.print("\n  | ");

        int i;
        for(i = 1; i <= this.row; ++i) {
            System.out.print("" + i + " ");
        }

        System.out.println("\n--------------------------");

        for(i = 0; i < this.row; ++i) {
            System.out.print(i + 1 + " | ");

            for(int j = 0; j < this.column; ++j) {
                System.out.print(this.array[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    String getCell(int i, int j) {
        return this.array[i][j];
    }

    boolean isEmpty(int r, int c) {
        return this.getCell(r, c).equals(" ");
    }

    boolean isOver(int modo, Jugador.Player jugador) {
        if (modo ==1){
            if(jugador.score > 0){
                System.out.println("hola gaaaa");
                return false;
            }
        }
        else {
            for(int i = 0; i < this.column; ++i) {
                for(int j = 0; j < this.row; ++j) {
                    if (this.isEmpty(i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
