import java.io.Serializable;
import java.util.List;

/**
 * This class models an AIPlayer which is an extension of the Player class
 *
 * @author Vyasan. J
 * @version 11.22.2020
 */

public class AIPlayer extends Player implements Serializable {

    /**
     * Creates an AI player.
     *
     * @param name The name of the AI player.
     */
    AIPlayer(String name){
        super(name);
    }


    /**
     * Method used to imitate a regular player attack in the game.
     * The aiAttacks with countries that it owns which also has more than 
     * or equal to 4 army occupied and will attack any adjacent countries that
     * the ai does not own and has an army that is less than the attacking country
     *
     * @param riskGame The current game.
     */
    public void aiAggroAttack(Game riskGame){
        int ownedCountriesSize = getOwnedCountries().size();


        for(int i = 0; i < ownedCountriesSize; i++){
            int adjCountriesSize = getOwnedCountries().get(i).getAdjCountries().size();
            if(getOwnedCountries().get(i).getArmyOccupied() >= 4){
                for(int j = 0; j < adjCountriesSize; j++){
                    Country adj = riskGame.getBoardMap().getCountry(getOwnedCountries().get(i).getAdjCountries().get(j));
                    if(getOwnedCountries().get(i).getArmyOccupied()>adj.getArmyOccupied() && !adj.getRuler().equals(this) && getOwnedCountries().get(i).getArmyOccupied() >= 4){
                        riskGame.attackCMD(getOwnedCountries().get(i).getCountryName().toString(),3,adj.getCountryName().toString());
                    }
                }
            }

        }

    }
    
    /**
     * Method used to imitate a regular player attack in the game.
     * The aiAttacks with countries that it owns which also has more than 
     * or equal to 7 army occupied and will attack any adjacent countries that
     * the ai does not own and has an army that is less than the attacking country
     *
     * @param riskGame The current game.
     */
    public void aiPassiveAttack(Game riskGame){
        int ownedCountriesSize = getOwnedCountries().size();


        for(int i = 0; i < ownedCountriesSize; i++){
            int adjCountriesSize = getOwnedCountries().get(i).getAdjCountries().size();
            if(getOwnedCountries().get(i).getArmyOccupied() >= 7){
                for(int j = 0; j < adjCountriesSize; j++){
                    Country adj = riskGame.getBoardMap().getCountry(getOwnedCountries().get(i).getAdjCountries().get(j));
                    if(getOwnedCountries().get(i).getArmyOccupied()>adj.getArmyOccupied() && !adj.getRuler().equals(this) && getOwnedCountries().get(i).getArmyOccupied() >= 4){
                        riskGame.attackCMD(getOwnedCountries().get(i).getCountryName().toString(),3,adj.getCountryName().toString());
                    }
                }
            }

        }

    }

    /**
     * Method used for AI to deploy bonus armies
     * The ai will go through all the countries that it owns 
     * and deploy its bonus army to the country with the lowest army count
     *
     * @param riskGame - current game that's running
     */
    public void aiDeploy(Game riskGame) {
        int bonus = riskGame.getBoardMap().getBonusArmy(this);
        List<Country> owned = this.getOwnedCountries();
        int ownedSize = owned.size();
        int weakestIndex = 0;

        for (int i = 0; i < ownedSize; i++) {
            if (owned.get(i).getArmyOccupied() < owned.get(weakestIndex).getArmyOccupied()) {
                weakestIndex = i;
            }
        }

        owned.get(weakestIndex).setArmyOccupied(owned.get(weakestIndex).getArmyOccupied()+bonus);
    }


    /**
     * Checks to see if the player is AI.
     *
     * @return True.
     */
    @Override
    public boolean isAI(){
        return true;
    }


}
