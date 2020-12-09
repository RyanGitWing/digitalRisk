import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Test class for the game board.
 *
 * @author Fareen. L
 * @version 11.09.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 */
public class BoardTest {

    Board board;
    ArrayList<Player> players = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        board = new Board();

        players.add(new Player("Player1"));
        players.add(new Player("Player2"));
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        assertNull(board);
    }

    @Test
    public void getCountry() {
        // setup and act
        Country actual = board.getCountry("EasternAustralia");

        // assert
        assertNotNull(actual);
    }

    @Test
    public void setupPlayers() {
        // setup and act
        board.setupPlayers(players);

        // assert
        for (Player p: players) {
            for (Country c : p.getOwnedCountries()) {
                assertNotNull(c.getArmyOccupied());
                assertEquals(p, c.getRuler());
            }
        }
    }
}