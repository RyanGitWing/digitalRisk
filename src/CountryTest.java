import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for Country class.
 *
 * @author Fareen. L
 * @version 11.09.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 */
public class CountryTest {

    Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country("SouthernEurope", "Europe");
    }

    @After
    public void tearDown() throws Exception {
        country = null;
        assertNull(country);
    }

    @Test
    public void getName() {
        // act and assert
        assertEquals("SouthernEurope", country.getCountryName());
    }

    @Test
    public void getRuler() {
        // act and assert
        assertEquals(null, country.getRuler());
    }

    @Test
    public void setRuler() {
        // setup
        Player player = new Player("Player");
        country.setRuler(player);

        // act and assess
        assertEquals(player, country.getRuler());
    }

    @Test
    public void getArmyOccupied() {
        // act and assert
        assertEquals(0, country.getArmyOccupied());
    }

    @Test
    public void setArmyOccupied() {
        // setup
        country.setArmyOccupied(50);

        // act and assert
        assertEquals(50, country.getArmyOccupied());
    }

    @Test
    public void getAdjCountry() {
        // setup
        Country country = new Country("SouthernEurope", "Europe");

        // act and assert
        assertEquals(0, country.getAdjCountries().size());
    }

    @Test
    public void setAdjCountries() {
        // setup
        List<String> adj= new ArrayList<>();
        adj.add("Ukraine");
        adj.add("NorthernEurope");
        adj.add("WesternEurope");
        country.setAdjCountry(adj);

        // act and assert
        assertEquals(adj, country.getAdjCountries());
    }
}