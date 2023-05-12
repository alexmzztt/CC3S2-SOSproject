public class SosGame {
    public enum Cell {
        EMPTY(""), S("S"), O("O");
        private String content;
        Cell(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
    private Cell[][] grid;
    public enum Player {
        BLUE("Red", Cell.S),
        RED("Blue", Cell.S);
        private String name;
        private Cell move;
        static private Player currentPlayer = BLUE;

        Player(String name, Cell move) {
            this.name = name;
            this.move = move;
        }
        public static Cell getMove() {
            return currentPlayer.move;
        }
        public void setMove(Cell move) {
            currentPlayer.move = move;
        }
        public static Player getCurrentPlayer() {
            return currentPlayer;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    private int boardSize = 10;
    public SosGame() {
        initGame();
    }

    private void initGame() {
        grid = new Cell[boardSize][boardSize];
        for (int row = 0; row < boardSize; ++row) {
            for (int col = 0; col < boardSize; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
    }

    public void resetGame() {
        initGame();
    }

    public int getBoardSize() {
        return boardSize;
    }
    public void setBoardSize(String size) throws IllegalArgumentException {
        try {
            int newSize = Integer.parseInt(size);
            if (newSize >= 3) {
                boardSize = newSize;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Debe ingresar un número entero mayor o igual a tres.");
        }
    }

    public Cell getCell(int row, int column) {
        if (row >= 0 && row < boardSize && column >= 0 && column < boardSize) {
            return grid[row][column];
        } else {
            return null;
        }
    }
    public String getCurrentMove() {
        return Player.currentPlayer.move.toString();
    }

    public void makeMove(int row, int column) {
        if (row >= 0 && row < boardSize && column >= 0 && column < boardSize) {
            if (grid[row][column] == Cell.EMPTY) {
                grid[row][column] = Player.getMove();
                Player.currentPlayer = (Player.currentPlayer == Player.BLUE) ? Player.RED : Player.BLUE;
            }
        }
    }
    public void setMove(Cell move) {
        Player.currentPlayer.setMove(move);
    }
}

