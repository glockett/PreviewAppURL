import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private DetailsPanel detailsPanel;

    public MainFrame(String title) {
        super (title);

        //Set Layout Manager
        setLayout(new BorderLayout());

        //Create Swing components
        detailsPanel = new DetailsPanel();

        //Add swing components to content pain
        Container c = getContentPane();

        c.add(detailsPanel, BorderLayout.WEST);

    }

}
