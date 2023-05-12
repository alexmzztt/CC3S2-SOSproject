import java.util.Scanner;

public class SOS {
    static void showStatus(Jugador jugador1, Jugador jugador2) {
        System.out.println("Player Score   : " + jugador1.puntaje);
        System.out.println("Computer Score : " + jugador2.puntaje);
    }

    static void showWinner(Jugador jugador1, Jugador jugador2) {
        if (jugador1.puntaje > jugador2.puntaje) {
            System.out.println("Player wins!");
        } else if (jugador1.puntaje < jugador2.puntaje) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a draw.");
        }
    }

    static void oneTurn(Jugador jugador, Revisar check, int modo) {
        jugador.play(check, modo);
        check.board.printBoard();
        if (check.secondChance) {
            check.secondChance = false;
            oneTurn(jugador,check, modo);
        }
    }

    static void start() {
        Board board = new Board();
        Jugador jugador = new Jugador();
        Computadora computadora = new Computadora();
        Revisar check = new Revisar(board);
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el tamañodel tablero siendo el minimo 3x3 : ");
        int size = scan.nextInt();

        if (size < 3) {
            System.out.println("Como ingresó un numero menor a 3, el tamaño del tablero asignado sera 3");
            size = 3;
        }

        System.out.print("Ingrese el modo de juego siendo 1=modo simple y 2=modo general : ");
        int modo = scan.nextInt();
        while (modo < 1 || modo > 2) {
            System.out.println("Ingrese un modo de juego valido");
            modo = scan.nextInt();
        }

        board.setBoard(size,size);

        while (!(board.gameOver(modo, computadora) || board.gameOver(modo, jugador))) {
            oneTurn(jugador,check, modo);
            showStatus(jugador,computadora);

            if (!(board.gameOver(modo, computadora) || board.gameOver(modo, jugador))) {
                oneTurn(computadora,check, modo);
                showStatus(jugador,computadora);
            }
        }
        showWinner(jugador,computadora);
    }
}
