import java.util.*;

/**
 * Represents the coutries
 *
 * Author: Vyasan. J
 * Version: 10.25.2020
 */
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
        armyOccupied = 0;
        adjCountries = new HashMap<>();
    }
    
    /**
     * Sets the ruler of the country
     *
     *@param ruler - the ruler of the country
     */
    public void setRuler(Player ruler){
        this.ruler = ruler;
    }
    
     /**
     * Sets the army occupied in the country
     *
     *@param army - amount of army in the country
     */
    public void addArmyOccupied(int army){
        armyOccupied = army;
    }
    
     /**
     * Sets the countries adjacent to the current country
     *
     *@param adj - adjacent country
     */
    public void setAdjCountry(CountryName country, List<CountryName> adj){
        adjCountries.put(country, adj);
    }
    
     /**
     * Returns countries name
     *
     *@return the name of the country
     */
    public CountryName getName(){
        return this.name;
    }
    
    /**
     * Returns countries ruler
     *
     *@return the ruler of the country
     */
    public Player getRuler(){
        return this.ruler;
    }
  
     /**
     * Returns army occupied in country
     *
     *@return the amount of army in countrty
     */
    public int getArmyOccupied(){
        return this.armyOccupied;
    }
        
     /**
     * Returns adjacent countries
     *
     *@return a list of adjacent countries
     */
    public List<CountryName> getAdjCountries(CountryName country){
        return adjCountries.get(country);
    }
}
