import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailsPanel extends JPanel {

    public static boolean validateEmail(String email) {
        boolean status = false;
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-­]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\­.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 600;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Details"));

        //Set up my JImages

        //Setup my JLabels
        JLabel lbl1 = new JLabel("Please enter the Composer Preview URL");
        final JLabel errorMsg1 = new JLabel("Error1 msg here!");
        //errorMsg1.setForeground(Color.getColor(Red));
        JLabel lbl2 = new JLabel("Please enter the Email address (send the Preview link):");
        final JLabel errorMsg2 = new JLabel("Error2 msg here!");
        //errorMsg2.setForeground(Color.getColor(Red));

        //Set up my JTextFields
        final JTextField composerURL = new JTextField(10);
        final JTextField emailAddress = new JTextField(10);

        //Set up my JTextFields
        JButton send_btn = new JButton("Send email");

        send_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    if (composerURL.getText() == "") {
                        errorMsg1.setText("Please enter the composer Preview URL");
                    } else if (emailAddress.getText() == "") {
                        errorMsg2.setText("Please enter the composer Preview URL");
                        boolean status = validateEmail(emailAddress.getText());
                        if (status) {

                        } else {
                            errorMsg2.setText("Not Valid Email address");
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                PreviewAppURL.getAppPreviewURL(composerURL.getText());

                PreviewAppURL.sendEmail(emailAddress.getText());
            }
        });


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

        gc.anchor = GridBagConstraints.NORTH;
        gc.gridx = 1;
        gc.gridy = 3;
        add(errorMsg1, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(errorMsg2, gc);


    }


}
