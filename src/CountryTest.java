import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for Country class.
 *
 * @author Fareen Lavji
 * @version 11.08.2020
 */
public class CountryTest {

    Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country(CountryName.SouthernEurope);
    }

    @After
    public void tearDown() throws Exception {
        country = null;
        assertNull(country);
    }

    @Test
    public void getName() {
        assertEquals(CountryName.SouthernEurope, country.getCountryName());
    }

    @Test
    public void getRuler() {
        assertEquals(null, country.getRuler());
    }

    @Test
    public void setRuler() {
        Player player = new Player("Player");
        country.setRuler(player);
        assertEquals(player, country.getRuler());
    }

    @Test
    public void getArmyOccupied() {
        assertEquals(0, country.getArmyOccupied());
    }

    @Test
    public void setArmyOccupied() {
        country.setArmyOccupied(50);
        assertEquals(50, country.getArmyOccupied());
    }

    @Test
    public void getAdjCountry() {
        Country country = new Country(CountryName.SouthernEurope);
        assertEquals(0, country.getAdjCountries().size());
    }

    @Test
    public void setAdjCountries() {
        List<CountryName> adj= new ArrayList<>();
        adj.add(CountryName.Ukraine);
        adj.add(CountryName.NorthernEurope);
        adj.add(CountryName.WesternEurope);
        country.setAdjCountry(adj);
        assertEquals(adj, country.getAdjCountries());
    }
}