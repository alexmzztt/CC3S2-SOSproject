import java.util.Random;

public class Computadora extends Jugador{
    public void play(Revisar check, int modo) {
        Random random = new Random();

        int row = random.nextInt(check.board.row);
        int column = random.nextInt(check.board.column);
        int letter = random.nextInt(2);

        if (check.board.isEmpty(row,column)) {
            if (letter == 0) {
                check.board.array[row][column] = "S";
            } else {
                check.board.array[row][column] = "O";
            }
        } else {
            play(check, modo);
        }

        puntaje += check.incScore(modo, this);
    }
}