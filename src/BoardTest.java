import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Test class for the game board.
 *
 * @author Fareen. L
 * @version 11.09.2020
 */
public class BoardTest {

    Board board;
    TestWorldMap map = new TestWorldMap();
    HashMap<ContinentName, Continent> testMap = new HashMap<>();
    Country c1;

    @Before
    public void setUp() throws Exception {
        testMap.put(ContinentName.Australia, new Continent(ContinentName.Australia));
        c1 = new Country(CountryName.EasternAustralia);
        c1.setAdjCountry(Arrays.asList(new CountryName[] { CountryName.NewGuinea}));
        Country c2 = new Country(CountryName.Indonesia);
        c1.setAdjCountry(Arrays.asList(new CountryName[] { CountryName.NewGuinea}));
        Country c3 = new Country (CountryName.NewGuinea);
        c1.setAdjCountry(Arrays.asList(new CountryName[] { CountryName.NewGuinea}));
        Country c4 = new Country(CountryName.WesternAustralia);
        c1.setAdjCountry(Arrays.asList(new CountryName[] { CountryName.NewGuinea}));
        testMap.get(ContinentName.Australia).addCountry(c1);
        testMap.get(ContinentName.Australia).addCountry(c2);
        testMap.get(ContinentName.Australia).addCountry(c3);
        testMap.get(ContinentName.Australia).addCountry(c4);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        map = null;
        testMap = null;
        c1 = null;
        assertNull(board);
        assertNull(map);
        assertNull(testMap);
        assertNull(c1);
    }

    @Test
    public void getBoardMap() {
        // setup
        board = new Board(this.map);

        // assert
        assertNotNull(board.getBoardMap());
        assertEquals(testMap.size(), board.getBoardMap().size());;
    }

    @Test
    public void getCountry() {
        // setup
        board = new Board(this.map);

        // act
        Country actual = board.getCountry(CountryName.EasternAustralia);

        // assert
        assertNotNull(actual);
        assertEquals(c1.getCountryName(), actual.getCountryName());
        assertEquals(c1.getArmyOccupied(), actual.getArmyOccupied());
        assertEquals(c1.getRuler(), actual.getRuler());
    }

    @Test
    public void setupPlayers() {
        // setup
        board = new Board(this.map);
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player1"));
        players.add(new Player("Player2"));

        // act
        board.setupPlayers(players);

        // assert
        assertNotNull(players.get(0).getOwnedCountries());
        assertEquals(50, players.get(0).getArmyCount());

        for (Player p: players) {
            for (Country c : p.getOwnedCountries()) {
                assertNotNull(c.getArmyOccupied());
                assertEquals(p, c.getRuler());
            }
        }
    }

    @Test
    public void defaultGameBoardMap() {
        // setup
        board = new Board();

        // assert
        assertNotNull(board.getBoardMap());
    }

    @Test
    public void defaultGameGetCountry() {
        // setup
        board = new Board();
        Country expected = new Country(CountryName.EasternAustralia);
        CountryName[] adjCountries = new CountryName[] {CountryName.NewGuinea, CountryName.WesternAustralia };
        expected.setAdjCountry(Arrays.asList(adjCountries));

        // act
        Country actual = board.getCountry(CountryName.EasternAustralia);

        // assess
        assertNotNull(actual);
        assertEquals(c1.getCountryName(), actual.getCountryName());
        assertEquals(c1.getArmyOccupied(), actual.getArmyOccupied());
        assertEquals(c1.getRuler(), actual.getRuler());
    }
}