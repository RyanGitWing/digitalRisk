import org.junit.*;

import static org.junit.Assert.*;

/**
 * Tests for the game class.
 *
 * @author Fareen. L
 * @version 10.09.2020
 */
public class GameTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBoardMap() {
        // setup
        Game game = new Game();

        // act and assess
        assertNotNull(game.getBoardMap());
    }

    @Test
    public void addRiskView() {
        // todo
    }

    @Test
    public void removeRiskView() {
        // todo
    }

    @Test
    public void getCurrentPlayer() {
        // setup
        Game game = new Game(2, 0);

        // act and assess
        assertEquals("Player1", game.getCurrentPlayer().getName());
    }

    @Test
    public void _getGameStatus() {
        // todo
    }

    @Test
    public void attackCMD() {
        // todo
    }

    @Test
    public void nextPlayer() {
        // setup and act
        Game game = new Game(2, 0);
        game.nextPlayer();
        String actual = game.getCurrentPlayer().getName();
        game.nextPlayer();

        // assess
        assertEquals("Player2", actual);
        assertEquals("Player1", game.getCurrentPlayer().getName());
    }
}