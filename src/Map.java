import java.util.HashMap;

public class Map
{
    private HashMap <CountryName, Integer> Map;
    private CountryName countryName;

    public Map ()
    {
        Map = new HashMap<>();
        this.setCountries();
    }

    public void setCountry (CountryName country)
    {
        this.Map.put(country,0);
    }

    public void setCountries ()
    {
        for (CountryName country : CountryName.values())
        {
            this.setCountry(country);
        }
    }

    public void randAllocation (int PlayerCount)
    {

    }
}
