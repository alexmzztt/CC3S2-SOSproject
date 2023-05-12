import java.util.Scanner;

public class Jugador{
    int puntaje = 0;

    Scanner scan = new Scanner(System.in);

    public void play(Revisar check, int modo) {
        System.out.println("Ingrese la fila y columna");

        System.out.print("Fila: ");
        int row = scan.nextInt() - 1;

        System.out.print("Columna: ");
        int column = scan.nextInt() - 1;

        System.out.print("Ingrese la letra: ");
        String letter = scan.next();

        letter = letter.toUpperCase();

        if (letter.equals("S") || letter.equals("O")) {
            if (check.board.isEmpty(row, column)) {
                check.board.array[row][column] = letter;
            } else {
                System.out.println("\nLa celda esta ocupada, por favor igrese otra fila y columna \n");
                play(check, modo);
            }
        } else {
            System.out.println("Letra invalida");
            play(check, modo);
        }

        puntaje += check.incPuntaje(modo, this);


    }
}