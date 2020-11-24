import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;

/**
 * The JPanel containing the News Section.
 *
 * @author Ryan. N
 * @version 11.09.2020
 *
 * @author Vis. K
 * @version 11.11.2020
 */

public class RiskNews extends JPanel
{
    private final JTextArea worldNews;

    /**
     * This panel displays the information of the game, like the current state of the game.
     */
    public RiskNews(String status)
    {
        this.setBackground(Color.white);

        //Nice little design layout for the title of the panel
        this.setBorder(new TitledBorder(new EtchedBorder(), "World News"));
        this.setBackground(Color.red);

        //Make a text area that resides in the panel
        worldNews = new JTextArea(16, 130);
        worldNews.setBackground(Color.cyan);
        worldNews.setForeground(Color.black);
        worldNews.setEditable(false);

        // Add the status from Game to text area

        worldNews.setText(status);

        //Make it scrollable
        JScrollPane scroll = new JScrollPane(worldNews);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add the scroll to the panel
        this.add(scroll);

        //Scroll automatically goes at the bottom of the text
        DefaultCaret caret = (DefaultCaret) worldNews.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    /**
     *  This will update the WorldNews section by adding the given String status text
     * */
    public void updateNews(String status)
    {
        worldNews.append("\n" + status);
    }
}
