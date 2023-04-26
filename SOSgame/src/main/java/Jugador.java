import java.util.Scanner;

    public class Jugador {
        public static Jugador jugador;
        public int puntaje = 0;
        Scanner scan;

        public void Jugador () {

            scan = new Scanner(System.in); //leer entradas
        }

        public void play(Revisar check) {
            System.out.println("Ingrese la fila y columna");
            System.out.print("Fila: ");
            int row = scan.nextInt() - 1; //lee la fila
            System.out.print("Columna: ");
            int column = scan.nextInt() - 1; //lee la columna
            System.out.print("Ingrese la letra que desea añadir: ");
            String letter = scan.next(); //lee la letra
            letter = letter.toUpperCase();
            if (!letter.equals("S") && !letter.equals("O")) { //verifica si la letra es S u O
                System.out.println("Letra invalida");
                play(check);
            } else if (check.board.isEmpty(row, column)) { //verifica si la celda esta vacia, si lo esta añade la letra
                check.board.array[row][column] = letter;
            } else { //sino pide ingresar otra fila y columna
                System.out.println("\nThe cell is not empty, enter other row and column numbers...\n");
                play(check);
            }

            puntaje += check.Score();
        }
    }
