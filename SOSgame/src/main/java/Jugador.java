import java.util.Scanner;

    public class Jugador {
        public int score = 0;
        Scanner scan;

        public void Jugador() {

            scan = new Scanner(System.in);
        }

        public void play(Revisar check) {
            System.out.println("Ingrese la fila y columna");
            System.out.print("Fila: ");
            int row = scan.nextInt() - 1;
            System.out.print("Columna: ");
            int column = scan.nextInt() - 1;
            System.out.print("Ingrese la letra que desea añadir: ");
            String letter = scan.next();
            letter = letter.toUpperCase();
            if (!letter.equals("S") && !letter.equals("O")) {
                System.out.println("Letra invalida");
                play(check);
            } else if (check.board.isEmpty(row, column)) {
                check.board.array[row][column] = letter;
            } else {
                System.out.println("\nThe cell is not empty, enter other row and column numbers...\n");
                play(check);
            }

            score += check.incScore();
        }
    }
