import java.util.HashMap;

public class WorldMap
{
    private HashMap <ContinentName, Continent> worldMap,NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia;

    public WorldMap ()
    {
        worldMap = new HashMap<>();
        NorthAmerica = new HashMap<>();
        SouthAmerica = new HashMap<>();
        Europe = new HashMap<>();
        Asia = new HashMap<>();
        Africa = new HashMap<>();
        Australia = new HashMap<>();
        worldMap = setMap();
    }

    public HashMap<ContinentName, Continent> getWorldMap() {
        return worldMap;
    }

    public HashMap <ContinentName, Continent> setMapContinent (ContinentName continentName)
    {
        ContinentMap continentMap = new ContinentMap();
        HashMap <ContinentName, Continent> tempContinent = new HashMap<>();
        tempContinent.put(continentName, continentMap.setUpContinent(continentName));
        return tempContinent;
    }

   public HashMap<ContinentName, Continent> setMap ()
    {
        NorthAmerica.putAll(setMapContinent(ContinentName.NorthAmerica));
        SouthAmerica.putAll(setMapContinent(ContinentName.SouthAmerica));
        Europe.putAll(setMapContinent(ContinentName.Europe));
        Africa.putAll(setMapContinent(ContinentName.Africa));
        Asia.putAll(setMapContinent(ContinentName.Asia));
        Australia.putAll(setMapContinent(ContinentName.Australia));
        worldMap.putAll(NorthAmerica);
        worldMap.putAll(SouthAmerica);
        worldMap.putAll(Europe);
        worldMap.putAll(Africa);
        worldMap.putAll(Asia);
        worldMap.putAll(Australia);
        return worldMap;
    }
}

