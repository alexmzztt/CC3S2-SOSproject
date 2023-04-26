import java.util.Scanner;

public class SOS {
    public SOS() {
    }

    static void showStatus(Jugador.Player player1, Jugador.Player player2) {
        System.out.println("Puntaje del jugador 1   : " + player1.score);
        System.out.println("Puntaje del jugador 2 : " + player2.score);
    }

    static void showWinner(Jugador.Player player1, Jugador.Player player2) {
        if (player1.score > player2.score) {
            System.out.println("El jugador 1 es el ganador");
        } else if (player1.score < player2.score) {
            System.out.println("El jugador 2 es el ganador");
        } else {
            System.out.println("Es un empate");
        }

    }

    static void oneTurn(Jugador.Player player1, Revisar check) {
        player1.play(check);
        check.board.printBoard();
        if (check.secondChance) {
            check.secondChance = false;
            oneTurn(player1, check);
        }

    }

    static void start() {
        Board board = new Board();
        Jugador.Player player1 = new Jugador.Player();
        Jugador.Player player2 = new Jugador.Player();
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
        while (modo<1 || modo>2){
            System.out.println("Ingrese un modo de juego valido");
            modo = scan.nextInt();
        }

        check.modo = modo;

        board.setBoard(size, size);



        while(!board.isOver(modo, player1)) {
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