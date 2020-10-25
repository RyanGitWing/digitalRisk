import java.util.HashMap;

public class WorldMap
{
    private HashMap <ContinentName, ContinentMap> worldMap,NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia;

    public WorldMap ()
    {
        worldMap = new HashMap<>();
        worldMap = setMap();
    }

    public HashMap <ContinentName, ContinentMap> setMapContinent (ContinentName continentName)
    {
        ContinentMap continentMap = new ContinentMap();
        HashMap <ContinentName, ContinentMap> tempContinent = new HashMap<>();
        continentMap.setUpContinent(continentName);
        tempContinent.put(continentName, continentMap);
        return tempContinent;
    }

   public HashMap<ContinentName, ContinentMap> setMap ()
    {
        NorthAmerica = setMapContinent(ContinentName.NorthAmerica);
        SouthAmerica = setMapContinent(ContinentName.SouthAmerica);
        Europe = setMapContinent(ContinentName.Europe);
        Africa = setMapContinent(ContinentName.Africa);
        Asia = setMapContinent(ContinentName.Asia);
        Australia = setMapContinent(ContinentName.Australia);
        worldMap.putAll(NorthAmerica);
        worldMap.putAll(SouthAmerica);
        worldMap.putAll(Europe);
        worldMap.putAll(Africa);
        worldMap.putAll(Asia);
        worldMap.putAll(Australia);
        return worldMap;
    }

    public static void main(String[] args) {
        WorldMap t = new WorldMap();
        System.out.println(t.setMapContinent(ContinentName.Asia));
    }
}

