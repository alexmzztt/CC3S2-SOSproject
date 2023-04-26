import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class BoardTest {

    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }


    @Test
    void testMode() {

    }

    // AC 1.2 Elección de tamaño de tablero válido
    @Test
    void testValidSize() {
        Board board = new Board();
        board.setSize(3);
        assertEquals(board.getSize(), 3);
    }

    // AC 1.3 Elección de tamaño de tablero inválido
    @Test
    void testInvalidSize() {
        Board board = new Board();
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> { board.setSize(2); });
        assertEquals("Debe elegir un número entero mayor o igual a tres",
                exception.getMessage());
    }

    @Test
    void



    // AC 3.1 Comienzo de un nuevo juego exitoso
    @Test
    void testNewBoard() {
        Board board = new Board();
        for (int row = 0; row<8; row++) {
            for (int column = 0; column<8; column++) {
                assertEquals(board.getCell(row, column), "");
            }
        }
        assertEquals(board.getTurn(), "Blue");
    }
}