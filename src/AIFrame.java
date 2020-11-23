import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Secondary frame for Risk to initialize AI players if there is no more
 * space for AI players does not become visible
 *
 * @author Vyasan. J
 * @version 11.22.2020
 */

public class AIFrame extends JFrame implements ActionListener
{
    private static int AIPlayers = 0;

    public AIFrame()
    {

        super("Risk Game");
        this.setLayout(new BorderLayout());
        this.setSize(600,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        if(StarterFrame.getHumanPlayers() == 6){
            setVisible(false);
            RiskFrame riskFrame = new RiskFrame(StarterFrame.getHumanPlayers(),AIFrame.getAIPlayers());
        }
        else{
            this.setVisible(true);
        }


        //A panel for the buttons
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        //A label that shows a text requesting the user to do something
        JLabel label = new JLabel("\n Select the number of AI Players playing.");

        //Align the label to be centered to the frame
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);


        //Adding the label to North and the panel to the Center
        this.add(label, BorderLayout.NORTH);
        this.add(aPanel, BorderLayout.CENTER);



        //Creating the buttons for each number of players
        for (int i = 1; i <= 6-StarterFrame.getHumanPlayers(); i++)
        {
            JButton button = new JButton(i + " Players");
            button.addActionListener(this);

            //Adding the buttons to the panel
            aPanel.add(button);
        }

        //Spacing the panel away from the label
        aPanel.add(Box.createVerticalStrut(50));

        //Centering the frame to be in the middle of the screen
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public static int getAIPlayers(){
        return AIPlayers;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        char num = e.getActionCommand().charAt(0);
        AIPlayers = Integer.parseInt(String.valueOf(num));
        dispose();
        RiskFrame riskFrame = new RiskFrame(StarterFrame.getHumanPlayers(),AIFrame.getAIPlayers());


    }

}