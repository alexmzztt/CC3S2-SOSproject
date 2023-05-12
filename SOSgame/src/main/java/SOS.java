import java.util.Scanner;

public class SOS {
    //muestra los puntajes
    static void mostrarPuntaje(Jugador jugador1, Jugador jugador2) {
        System.out.println("Puntaje del jugador   : " + jugador1.puntaje);
        System.out.println("Puntaje de la computadora : " + jugador2.puntaje);
    }

    //muestra el ganador
    static void mostrarGanador(Jugador jugador1, Jugador jugador2) {
        if (jugador1.puntaje > jugador2.puntaje) {
            System.out.println("¡El jugador gana!");
        } else if (jugador1.puntaje < jugador2.puntaje) {
            System.out.println("¡La computadora gana!");
        } else {
            System.out.println("Empate.");
        }
    }

    //verifica el turno y si hay un turno extra por realizar un SOS
    static void Turno(Jugador jugador, Revisar check, int modo) {
        jugador.jugada(check, modo);
        check.board.printBoard();
        if (check.otroTurno) {
            check.otroTurno = false;
            Turno(jugador,check, modo);
        }
    }

    //inicia el juego
    static void start() {
        Board board = new Board();
        Jugador jugador = new Jugador();
        Computadora computadora = new Computadora();
        Revisar check = new Revisar(board);
        Scanner scan = new Scanner(System.in);

        //pide el tamaño del tablero
        System.out.print("Ingrese el tamañodel tablero siendo el minimo 3x3 : ");
        int size = scan.nextInt();

        if (size < 3) { //si se ingresa un numero menor a 3 entonces el tamaño se asigna a 3
            System.out.println("Como ingresó un numero menor a 3, el tamaño del tablero asignado sera 3");
            size = 3;
        }

        //modo de juego
        System.out.print("Ingrese el modo de juego siendo 1=modo simple y 2=modo general : ");
        int modo = scan.nextInt();
        while (modo < 1 || modo > 2) { //si el numero no es 1 ni 2 pide ingresar un modo de juego valido
            System.out.println("Ingrese un modo de juego valido");
            modo = scan.nextInt();
        }

        //tablero
        board.iniBoard(size,size);

        while (!(board.gameOver(modo, computadora) || board.gameOver(modo, jugador))) {
            Turno(jugador,check, modo);
            mostrarPuntaje(jugador,computadora);

            if (!(board.gameOver(modo, computadora) || board.gameOver(modo, jugador))) {
                Turno(computadora,check, modo);
                mostrarPuntaje(jugador,computadora);
            }
        }
        mostrarGanador(jugador,computadora);
    }
}
