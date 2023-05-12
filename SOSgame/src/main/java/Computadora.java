import java.util.Random;

public class Computadora extends Jugador{
    public void jugada(Revisar check, int modo) {
        Random random = new Random();

        //elige una fila y columna al azar, y tambien una letra
        int row = random.nextInt(check.board.row);
        int column = random.nextInt(check.board.column);
        int letter = random.nextInt(2);

        //verifica que sea una celda vacia, si esta vacia asigna la letra
        if (check.board.isEmpty(row,column)) {
            if (letter == 0) {
                check.board.array[row][column] = "S";
            } else {
                check.board.array[row][column] = "O";
            }
        } else {
            jugada(check, modo);
        }

        //puntaje
        puntaje += check.incPuntaje(modo, this);
    }
}