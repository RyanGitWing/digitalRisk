import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * The Risk Fortify Controller.
 *
 * @author Ryan. N
 * @version 12.08.2020
 *
 * @author Vis. K
 * @version 12.09.2020
 */
public class FortifyController implements ActionListener {

    private final Game riskGame;
    private final Board board;

    /**
     * Creates a FortifyController object.
     *
     * @param riskGame The game object.
     */
    public FortifyController(Game riskGame) {
        this.riskGame = riskGame;
        this.board = riskGame.getBoardMap();
    }

    /**
     * Handles user interaction with WorldMapGUI and the phase of fortify countries.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String fortifyWC = e.getActionCommand();
        Country fortifyWCCountry = board.getCountry(fortifyWC);
        if (!riskGame.getCurrentPlayer().equals(fortifyWCCountry.getRuler())){
            String text = "";
            text += "You don't own this country. ";
            JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
        }
        List<String> ownedC = new ArrayList<>(); // List that will be used to story CountryNames of countries with > 1 army

        for (Country c : riskGame.getCurrentPlayer().getOwnedCountries()) {
            if (board.getCountry(c.getCountryName()).getArmyOccupied() > 1) {
                ownedC.add(c.getCountryName());
            }
        }

        String[] ownC = new String[ownedC.size()];
        for (int i = 0; i < ownC.length; i++)
        {
            ownC[i] = ownedC.get(i) +
                    " " + board.getCountry(ownedC.get(i)).getArmyOccupied();
        }

        String[] fortC = new String[riskGame.getCurrentPlayer().getOwnedCountries().size() - 1];
        for (int i = 0; i < fortC.length; i++) {
            if (!riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName().equals(fortifyWC)) {
                fortC[i] = riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName() +
                        " " + riskGame.getCurrentPlayer().getOwnedCountries().get(i).getArmyOccupied();
            }
        }
        String frtC = (String) JOptionPane.showInputDialog(null,
                "Choose a country to fortify", "List of own Countries",
                JOptionPane.INFORMATION_MESSAGE, null,
                fortC, "");

        String fortifyC = frtC.substring(0, frtC.indexOf(" "));

        if (frtC != null) {
            String[] armyDeploy = new String[fortifyWCCountry.getArmyOccupied() - 1];

            for (int i = 0; i < armyDeploy.length; i++) {
                armyDeploy[i] = String.valueOf(i + 1);
            }

            if ((riskGame.pathCheck(fortifyWC, new ArrayList<>(), fortifyC)))
            {
                String armyDpl = (String) JOptionPane.showInputDialog(null,
                        "Choose the amount of army to deploy", "Amount of army available to deploy",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        armyDeploy, "");
                riskGame.fortifyCMD(fortifyWC, fortifyC, Integer.parseInt(armyDpl));
                riskGame.update();
            }
            else {
                String text = "";
                text += "There was no path between these countries!";
                JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}