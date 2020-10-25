import java.util.HashMap;
import java.util.List;

public class WorldMap
{
    private HashMap <ContinentName, List <Country> > worldMap, NorthAmerica,SouthAmerica,Europe,Africa,Asia,Australia;

    public WorldMap ()
    {
        worldMap = new HashMap<>();
        NorthAmerica = new HashMap<>();
        SouthAmerica = new HashMap<>();
        Europe = new HashMap<>();
        Africa = new HashMap<>();
        Asia = new HashMap<>();
        Australia = new HashMap<>();
        worldMap = setMap();
    }

    public HashMap <ContinentName, List<Country> > setMapContinent (ContinentName continentName)
    {
        ContinentMap continentMap = new ContinentMap();
        if (continentName == ContinentName.NorthAmerica)
        {
           return NorthAmerica = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.SouthAmerica)
        {
           return SouthAmerica = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Europe)
        {
            return Europe = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Africa)
        {
            return Africa = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Asia)
        {
            return Asia = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Australia)
        {
            return Australia = continentMap.setUpContinent(continentName);
        }
        else return null;
    }

    public HashMap <ContinentName, List <Country> > setMap ()
    {
        this.NorthAmerica = setMapContinent(ContinentName.NorthAmerica);
        this.SouthAmerica = setMapContinent(ContinentName.SouthAmerica);
        this.Europe = setMapContinent(ContinentName.Europe);
        this.Africa = setMapContinent(ContinentName.Africa);
        this.Asia = setMapContinent(ContinentName.Asia);
        this.Australia = setMapContinent(ContinentName.Australia);
        worldMap.putAll(NorthAmerica);
        worldMap.putAll(SouthAmerica);
        worldMap.putAll(Europe);
        worldMap.putAll(Africa);
        worldMap.putAll(Asia);
        worldMap.putAll(Australia);
        return this.worldMap;
    }
}

