import java.util.Scanner;

public class SOS {


    static void mostrarPuntaje(Jugador player1, Jugador player2) { //muestra el puntaje de los jugadores
        System.out.println("Puntaje del jugador 1   : " + player1.puntaje);
        System.out.println("Puntaje del jugador 2 : " + player2.puntaje);
    }

    static void Winner(Jugador player1, Jugador player2) {// determinar el ganador
        if (player1.puntaje > player2.puntaje) {
            System.out.println("El jugador 1 es el ganador");
        } else if (player1.puntaje < player2.puntaje) {
            System.out.println("El jugador 2 es el ganador");
        } else {
            System.out.println("Es un empate");
        }

    }

    static void Turn(Jugador player1, Revisar check) { //Turno de cada jugador
        player1.play(check);
        check.board.printBoard();
        if (check.secondChance) {
            check.secondChance = false;
            Turn(player1, check);

        }
    }

        static void start () { //iniciar el juego
            Board board = new Board();
            Jugador player1 = new Jugador();
            Jugador player2 = new Jugador();
            Revisar check = new Revisar(board);
            Scanner scan = new Scanner(System.in);
            System.out.print("Ingrese el tamaño del tablero(tamaño minimo 3x3) : ");
            int size = scan.nextInt();
            while (size < 3) {
                System.out.println("Ingrese un tamaño valido");
                size = scan.nextInt();
            }
            //pedir modo de juego
            System.out.print("Ingrese el modo de juego siendo 1=modo simple y 2=modo general : ");
            int modo = scan.nextInt();
            while (modo < 1 || modo > 2) {
                System.out.println("Ingrese un modo de juego valido");
                modo = scan.nextInt();
            }

            //configura el tablero y modo de juego
            board.IniBoard(size, size);
            check.modo = modo;

            //bucle para cada turno hasta que el juego termine
            while (!board.gameOver(modo, player1)) {
                Turn(player1, check);
                mostrarPuntaje(player1, player2);
                if (!board.gameOver(modo, player2)) {
                    Turn(player2, check);
                    mostrarPuntaje(player1, player2);
                }
            }

            Winner(player1, player2);
        }

}