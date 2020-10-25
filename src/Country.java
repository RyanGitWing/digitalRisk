import java.util.*;


public class Country {

    private final CountryName name;
    private Player ruler;
    int armyOccupied;
    private HashMap<CountryName, List<CountryName>> adjCountries;

    /**
     *Creates a new country object
     *
     * @param name - the name of the country
     */
    public Country(CountryName name){
        this.name = name;
        ruler = null;
        adjCountries = new HashMap<>();
        this.armyOccupied = 0;
    }

    public void setRuler(Player ruler){
        this.ruler = ruler;
    }

    public void addArmyOccupied(int army){
        armyOccupied += army;
    }

    public void setAdjCountry(CountryName country,List<CountryName> adj){
        adjCountries.put(country,adj);
    }

    public CountryName getName(){
        return this.name;
    }

    public Player getRuler(){
        return this.ruler;
    }

    public int getArmyOccupied(){
        return this.armyOccupied;
    }

    public List<CountryName> getAdjCountries(CountryName country){ // changed from string to list<countryname>
        return adjCountries.get(country);
    }
}