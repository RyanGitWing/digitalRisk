import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Risk Starting Frame which asks the user how many players there are.
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 */

public class StarterFrame extends JFrame implements ActionListener
{
    public StarterFrame()
     {
         super("Risk Game");
         this.setLayout(new BorderLayout());
         this.setSize(750,100);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);

         //A panel for the buttons
         JPanel aPanel = new JPanel();
         aPanel.setLayout(new FlowLayout());

         //A label that shows a text requesting the user to do something
         JLabel label = new JLabel("\n Select the number of Players playing.");

         //Align the label to be centered to the frame
         label.setHorizontalAlignment(JLabel.CENTER);
         label.setVerticalAlignment(JLabel.CENTER);


         //Adding the label to North and the panel to the Center
         this.add(label, BorderLayout.NORTH);
         this.add(aPanel, BorderLayout.CENTER);

         //Creating the buttons for each number of players
         for (int i = 1; i <= 6; i++)
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
         this.setVisible(true);
         this.setResizable(false);
     }

     public static void main(String[] args) {
        new StarterFrame();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        char num = e.getActionCommand().charAt(0);
        int playerNum = Integer.parseInt(String.valueOf(num));
        dispose();
        RiskFrame riskFrame = new RiskFrame(playerNum);
        }

    }