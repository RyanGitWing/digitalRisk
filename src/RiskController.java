import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Risk game.
 *
 * @author Vis. K
 * @version 11.11.2020
 */

public class RiskController implements ActionListener{

    private final Game riskGame;
    private final Board board;

    /**
     * Creates a RiskController object.
     * @param riskGame The game object.
     */
    public RiskController(Game riskGame) {
        this.riskGame = riskGame;
        board = riskGame.getBoardMap();
    }

    /**
     * Handles user interaction with WorldMapGUI and the phase of attacking countries.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String atkC = e.getActionCommand();
        String defC;
        String armyC;
        int armyCount;

        Country country = board.getCountry(CountryName.valueOf(atkC));
        List<CountryName> countryAdjList = country.getAdjCountries();

        if (!riskGame.getCurrentPlayer().equals(country.getRuler()))
        {
            String text = "";
            text += "You don't own this country. " + "\n" + "The current ruler is: " + country.getRuler().getName() + "\n" + "The current army is: " + country.getArmyOccupied();
            JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            List <Country> adjEnemy = new ArrayList<>();

            for (CountryName countryName : countryAdjList)
            {
                Country boardCountry = board.getCountry(countryName);
                if (!boardCountry.getRuler().equals(riskGame.getCurrentPlayer())) adjEnemy.add(boardCountry);
            }

            if (adjEnemy.size() != 0)
            {
                String[] adjEnemyArr = new String[adjEnemy.size()];
                for (int i = 0; i < adjEnemy.size(); i++)
                {
                    adjEnemyArr[i] = adjEnemy.get(i).getCountryName().toString();
                }
                defC = (String) JOptionPane.showInputDialog(null,
                        "Choose a country to attack", "List of Enemy Adj Countries",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        adjEnemyArr, "");

                if (defC != null)
                {
                    int size = country.getArmyOccupied();

                    if (size > 3)
                    {
                        size = 3;
                    }

                    String[] armyNum = new String[size];

                    for (int i = 0; i < armyNum.length; i++)
                    {
                        armyNum [i] = String.valueOf(i + 1);
                    }

                    if (armyNum.length > 1)
                    {
                        armyC = (String) JOptionPane.showInputDialog(null,
                                "Choose the amount of army to deploy", "Amount of army available to deploy",
                                JOptionPane.INFORMATION_MESSAGE, null,
                                armyNum, "");

                        if (armyC != null)
                        {
                            armyCount = Integer.parseInt(armyC);

                            if (armyCount > 0) {

                                riskGame.attackCMD(atkC, armyCount, defC);
                                riskGame.update();
                                JOptionPane.showMessageDialog(null, riskGame.getAtkOutput() , "Alert", JOptionPane.WARNING_MESSAGE);
                                if (riskGame.turnOutcome()) {

                                    String[] occArmy = new String[country.getArmyOccupied() - 1];

                                    for (int i = 0; i < occArmy.length; i++)
                                    {
                                        occArmy [i] = String.valueOf(i + 1);
                                    }

                                    String armyD = (String) JOptionPane.showInputDialog(null,
                                            "How many troops would you like to allocate to the new Country?", "Amount of army to move",
                                            JOptionPane.INFORMATION_MESSAGE, null,
                                            occArmy, "");

                                    riskGame.getBoardMap().getCountry(CountryName.valueOf(defC)).setArmyOccupied(Integer.parseInt(armyD));
                                    riskGame.getBoardMap().getCountry(CountryName.valueOf(atkC)).setArmyOccupied(country.getArmyOccupied() - Integer.parseInt(armyD));
                                    riskGame.update();
                                }

                                int cont = JOptionPane.showConfirmDialog(null, "Would you like to continue to attack?",
                                        "Attack Phase", JOptionPane.YES_NO_OPTION);

                                if (cont == JOptionPane.NO_OPTION) {

                                    List<CountryName> ownedC = new ArrayList<>(); // List that will be used to story CountryNames of countries with > 1 army

                                    for (Country c : riskGame.getCurrentPlayer().getOwnedCountries()) {
                                        if (riskGame.getBoardMap().getCountry(c.getCountryName()).getArmyOccupied() > 1) {
                                            ownedC.add(c.getCountryName());
                                        }
                                    }

                                    String[] ownC = new String[ownedC.size()];
                                    for (int i = 0; i < ownC.length; i++)
                                    {
                                        ownC[i] = ownedC.get(i).toString() +
                                                " " + riskGame.getBoardMap().getCountry(ownedC.get(i)).getArmyOccupied();
                                    }
                                    String ourC = (String) JOptionPane.showInputDialog(null,
                                            "Choose a country to fortify with", "List of own Countries",
                                            JOptionPane.INFORMATION_MESSAGE, null,
                                            ownC, "");

                                    if (ourC != null) {

                                        String[] fortC = new String[riskGame.getCurrentPlayer().getOwnedCountries().size() - 1];
                                        for (int i = 0; i < fortC.length; i++)
                                        {
                                            String compare = ourC.substring(0,ourC.indexOf(" "));
                                            if (!riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName().toString().equals(compare))
                                            {
                                                fortC[i] = riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName().toString() +
                                                        " " + riskGame.getCurrentPlayer().getOwnedCountries().get(i).getArmyOccupied();
                                            }
                                        }
                                        String frtC = (String) JOptionPane.showInputDialog(null,
                                                "Choose a country to fortify", "List of own Countries",
                                                JOptionPane.INFORMATION_MESSAGE, null,
                                                fortC, "");

                                        if (frtC != null) {

                                            String name = ourC.substring(0,ourC.indexOf(" "));
                                            String[] armyDeploy = new String[riskGame.getBoardMap().getCountry(CountryName.valueOf(name)).getArmyOccupied()-1];

                                            for (int i = 0; i < armyDeploy.length; i++)
                                            {
                                                armyDeploy [i] = String.valueOf(i + 1);
                                            }

                                            String fortifyC = frtC.substring(0,frtC.indexOf(" "));
                                            String fortifyWC = ourC.substring(0,ourC.indexOf(" "));
                                            if ((riskGame.pathCheck(fortifyWC, new ArrayList<>(), fortifyC))) {
                                                String armyDpl = (String) JOptionPane.showInputDialog(null,
                                                        "Choose the amount of army to deploy", "Amount of army available to deploy",
                                                        JOptionPane.INFORMATION_MESSAGE, null,
                                                        armyDeploy, "");
                                                riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyC)).setArmyOccupied(riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyC)).getArmyOccupied() + Integer.parseInt(armyDpl));
                                                riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyWC)).setArmyOccupied(riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyWC)).getArmyOccupied() - Integer.parseInt(armyDpl));
                                                riskGame.nextPlayer();
                                                riskGame.update();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else JOptionPane.showMessageDialog(null, "You own all nearby countries." + "\n" + countryAdjList, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}