import java.util.Scanner;

public class SOS {


    static void showStatus(Jugador player1, Jugador player2) {
        System.out.println("Puntaje del jugador 1   : " + player1.score);
        System.out.println("Puntaje del jugador 2 : " + player2.score);
    }

    static void showWinner(Jugador player1, Jugador player2) {
        if (player1.score > player2.score) {
            System.out.println("El jugador 1 es el ganador");
        } else if (player1.score < player2.score) {
            System.out.println("El jugador 2 es el ganador");
        } else {
            System.out.println("Es un empate");
        }

    }

    static void oneTurn(Jugador player, Revisar check) {
        player.play(check);
        check.board.printBoard();
        if (check.secondChance) {
            check.secondChance = false;
            oneTurn(player, check);

        }

    }

    static void start () {
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
        System.out.print("Ingrese el modo de juego siendo 1=modo simple y 2=modo general : ");
        int modo = scan.nextInt();
        while (modo < 1 || modo > 2) {
            System.out.println("Ingrese un modo de juego valido");
            modo = scan.nextInt();
        }
        board.setBoard(size, size);
        check.modo = modo;
        while (!board.isOver(modo, player1)) {
            oneTurn(player1, check);
            showStatus(player1, player2);
            if (!board.isOver(modo, player2)) {
                oneTurn(player2, check);
                showStatus(player1, player2);
            }
        }
        showWinner(player1, player2);
    }
}