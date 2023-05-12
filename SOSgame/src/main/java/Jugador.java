import java.util.Scanner;

public class Jugador{
    int puntaje = 0;

    //para recepcionar
    Scanner scan = new Scanner(System.in);

    public void jugada(Revisar check, int modo) {
        //pide la fila y columna
        System.out.println("Ingrese la fila y columna");
        //pide la fila
        System.out.print("Fila: ");
        int row = scan.nextInt() - 1; //recepciona el valor

        System.out.print("Columna: "); //pide la columna
        int column = scan.nextInt() - 1; //recepciona el valor

        System.out.print("Ingrese la letra: "); //pide la letra
        String letter = scan.next(); //recepciona la letra

        letter = letter.toUpperCase(); //la convierte a mayuscula

        if (letter.equals("S") || letter.equals("O")) { //si la letra es S u O entra
            if (check.board.isEmpty(row, column)) { //verifica que la celda este vacia
                check.board.array[row][column] = letter; //si la celda esta vacia entonces la reemplaza por la letra elegida
            } else { //si no esta vacia entonces pide ingresar otra fila y columna
                System.out.println("\nLa celda esta ocupada, por favor igrese otra fila y columna \n");
                jugada(check, modo);
            }
        } else { //si no es S u O muestra un mensaje de letra invalida y pide ingresar una letra nuevamente
            System.out.println("Letra invalida");
            jugada(check, modo);
        }
        //puntaje
        puntaje += check.incPuntaje(modo, this);


    }
}