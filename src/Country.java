import java.util.*;


public class Country {

    private final String name;
    private Player ruler;
    private int armyOccupied;
    private HashMap<CountryName, List<CountryName>> adjCountries;

    /**
     *Creates a new country object
     *
     * @param name - the name of the country
     */
    public Country(CountryName name){
        this.name = name;
        ruler = null;
        armyOccupied = 0;
        adjCountries = new HashMap<>();
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

    public String getAdjCountries(CountryName country){
        return adjCountries.get(country);
    }
}
