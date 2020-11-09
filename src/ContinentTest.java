import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Continent class.
 */
public class ContinentTest {

    Continent continent;

    @Before
    public void setUp() throws Exception {
        continent = new Continent(ContinentName.Africa);
    }

    @After
    public void tearDown() throws Exception {
        continent = null;
        assertNull(continent);
    }

    @Test
    public void getName() {
        assertEquals(ContinentName.Africa, continent.getName());
    }

    @Test
    public void getContinentEmpty() {
        assertEquals(0, continent.getContinent().size());
    }

    @Test
    public void addCountry() {
        continent.addCountry(new Country(CountryName.SouthernEurope));
        assertEquals(1, continent.getContinent().size());
        assertEquals(CountryName.SouthernEurope, continent.getContinent().get(0).getCountryName());
    }
}