import java.util.HashMap;

public class WorldMap
{
    private HashMap <CountryName, Integer> WorldMap, NorthAmerica,SouthAmerica,Europe,Africa,Asia,Australia;

    public WorldMap ()
    {
        WorldMap = new HashMap<>();
        NorthAmerica = new HashMap<>();
        SouthAmerica = new HashMap<>();
        Europe = new HashMap<>();
        Africa = new HashMap<>();
        Asia = new HashMap<>();
        Australia = new HashMap<>();
        this.setContinents();
        this.setMap();
    }

    public void setCountry (CountryName country, HashMap map)
    {
        map.put(country,0);
    }

    public void setContinent (ContinentName continent)
    {
        if (continent == ContinentName.NorthAmerica)
        {
            setCountry(CountryName.Alaska, NorthAmerica);
            setCountry(CountryName.WesternCanada, NorthAmerica);
            setCountry(CountryName.CentralAmerica, NorthAmerica);
            setCountry(CountryName.EasternUS, NorthAmerica);
            setCountry(CountryName.Greenland, NorthAmerica);
            setCountry(CountryName.NorthwestTerritories, NorthAmerica);
            setCountry(CountryName.CentralCanada, NorthAmerica);
            setCountry(CountryName.EasternCanada, NorthAmerica);
            setCountry(CountryName.WesternUS, NorthAmerica);
        }
        if (continent == ContinentName.SouthAmerica)
        {
            setCountry(CountryName.Argentina, SouthAmerica);
            setCountry(CountryName.Brazil, SouthAmerica);
            setCountry(CountryName.Peru,SouthAmerica);
            setCountry(CountryName.Venezuela, SouthAmerica);
        }
        if (continent == ContinentName.Europe)
        {
            setCountry(CountryName.GreatBritain, Europe);
            setCountry(CountryName.Iceland,Europe);
            setCountry(CountryName.NorthernEurope, Europe);
            setCountry(CountryName.Scandinavia, Europe);
            setCountry(CountryName.SouthernEurope, Europe);
            setCountry(CountryName.Ukraine, Europe);
            setCountry(CountryName.WesternEurope, Europe);
        }
        if (continent == ContinentName.Africa)
        {
            setCountry(CountryName.Congo, Africa);
            setCountry(CountryName.EastAfrica, Africa);
            setCountry(CountryName.Egypt, Africa);
            setCountry(CountryName.Madagascar, Africa);
            setCountry(CountryName.NorthAfrica, Africa);
            setCountry(CountryName.SouthAfrica, Africa);
        }
        if (continent == ContinentName.Asia)
        {
            setCountry(CountryName.Afghanistan, Asia);
            setCountry(CountryName.China, Asia);
            setCountry(CountryName.India, Asia);
            setCountry(CountryName.Irkutsk, Asia);
            setCountry(CountryName.Japan, Asia);
            setCountry(CountryName.Kamchatka, Asia);
            setCountry(CountryName.MiddleEast, Asia);
            setCountry(CountryName.Mongolia, Asia);
            setCountry(CountryName.Siam, Asia);
            setCountry(CountryName.Siberia, Asia);
            setCountry(CountryName.Ural, Asia);
            setCountry(CountryName.Yakutsk, Asia);
        }
        if (continent == ContinentName.Australia)
        {
            setCountry(CountryName.EasternAustralia, Australia);
            setCountry(CountryName.Indonesia, Australia);
            setCountry(CountryName.NewGuinea, Australia);
            setCountry(CountryName.WesternAustralia, Australia);
        }
    }

    public void setContinents()
    {
        setContinent(ContinentName.NorthAmerica);
        setContinent(ContinentName.SouthAmerica);
        setContinent(ContinentName.Europe);
        setContinent(ContinentName.Africa);
        setContinent(ContinentName.Asia);
        setContinent(ContinentName.Australia);
    }

    public void setMap()
    {
        WorldMap.putAll(NorthAmerica);
        WorldMap.putAll(SouthAmerica);
        WorldMap.putAll(Europe);
        WorldMap.putAll(Africa);
        WorldMap.putAll(Asia);
        WorldMap.putAll(Australia);
    }

    public void randAllocation (int PlayerCount)
    {

    }
}
