import java.util.HashMap;
import java.util.List;

public class WorldMap
{
    private HashMap <ContinentName, List <Country> > WorldMap, NorthAmerica,SouthAmerica,Europe,Africa,Asia,Australia;

    public WorldMap ()
    {
        WorldMap = new HashMap<>();
        NorthAmerica = new HashMap<>();
        SouthAmerica = new HashMap<>();
        Europe = new HashMap<>();
        Africa = new HashMap<>();
        Asia = new HashMap<>();
        Australia = new HashMap<>();
        this.setMap();
    }

    public void setMapContinent (ContinentName continentName)
    {
        ContinentMap continentMap = new ContinentMap();
        if (continentName == ContinentName.NorthAmerica)
        {
            NorthAmerica = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.SouthAmerica)
        {
            SouthAmerica = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Europe)
        {
            Europe = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Africa)
        {
            Africa = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Asia)
        {
            Asia = continentMap.setUpContinent(continentName);
        }
        if (continentName == ContinentName.Australia)
        {
            Australia = continentMap.setUpContinent(continentName);
        }
    }

    public void setMap ()
    {
        setMapContinent(ContinentName.NorthAmerica);
        setMapContinent(ContinentName.SouthAmerica);
        setMapContinent(ContinentName.Europe);
        setMapContinent(ContinentName.Africa);
        setMapContinent(ContinentName.Asia);
        setMapContinent(ContinentName.Australia);
    }
}

