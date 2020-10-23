import java.util.*;


public class Country {

    private String name;
    private int armyBonus;
    private String continent;
    private Player ruler;
    private int armyOccupied;
    private ArrayList<Country> adjCountries;

    /**
     *Creates a new country object
     *
     * @param name - the name of the country
     * @param armyBonus - the bonus army u get for owning the country
     * @param continent - the continent the country is in
     */
    public Country(String name,int armyBonus, String continent){
        this.name = name;
        this.armyBonus = armyBonus;
        this.continent = continent;
        ruler = null;
        armyOccupied = 0;
        adjCountries = new ArrayList<>();
    }
    
    public void setRuler(Player ruler){
        this.ruler = ruler;
    }

    public void addArmyOccupied(int army){
        armyOccupied += army;
    }

    public void addAdjCountry(Country c){ adjCountries.add(c); }

    public String getName(){
        return this.name;
    }

    public int getArmyBonus(){
        return this.armyBonus;
    }

    public String getContinent(){
        return this.continent;
    }

    public Player getRuler(){
        return this.ruler;
    }

    public int getArmyOccupied(){
        return this.armyOccupied;
    }
}
