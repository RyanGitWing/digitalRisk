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
     *
     * @param riskGame The current game.
     */
    public void aiAttack(Game riskGame){
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
     * Method used for AI to deploy bonus armies
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
