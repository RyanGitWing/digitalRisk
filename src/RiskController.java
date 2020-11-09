import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskController implements ActionListener {

    RiskFrame frame = new RiskFrame();

    @Override
    public void actionPerformed(ActionEvent e) {


        String event = e.getActionCommand();

        if (e.getSource() instanceof JButton) {
            String country = e.getActionCommand();
            frame.adjSource(country);

        }

    }
}
