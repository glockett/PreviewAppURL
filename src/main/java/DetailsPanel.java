import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel {

    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 500;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Details"));

        JLabel lbl1 = new JLabel("Please enter the Composer Preview URL");
        JLabel lbl2 = new JLabel("Please enter the Email address (send the Preview link):");

        final JTextField composerURL = new JTextField(10);
        final JTextField emailAddress = new JTextField(10);

        JButton send_btn = new JButton("Send email");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Column1
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(lbl1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(lbl2, gc);

        //Column2
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(composerURL, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(emailAddress, gc);

        //Column3
        gc.weighty = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(send_btn, gc);






        //Add behaviours
        send_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                PreviewAppURL.getAppPreviewURL(composerURL.getText());
                PreviewAppURL.sendEmail(emailAddress.getText());
            }
        });


    }


}
