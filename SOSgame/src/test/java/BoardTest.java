import static org.junit.Assert.*;
import org.junit.After;
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
    void testConfig() {}
    Board board = new Board();


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