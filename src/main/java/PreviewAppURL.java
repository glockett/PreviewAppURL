import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class PreviewAppURL {

    private static String USERNAME = "gwyn.lockett@guardian.co.uk";
    private static String PWD = "vtzqpptoodgwpoks";
    private static String PREVIEW_URL;
    private static final String ENVIRONMENT_URL = "http://viewer.code.dev-gutools.co.uk/preview/";
    private static final String MAPI_URL = "http://x-gu://preview.mobile-apps.guardianapis.com/items/";
    private static final String SENDER = "gumobtest@gmail.com";
    private static final String HOST = "localhost";

    public static void main(String[] args) {

        getPreviewURL();

        String emailAddress = JOptionPane.showInputDialog("Please enter the email Address you wish to send the link too: ");

        sendEmail(emailAddress);



    }

    public static String getPreviewURL() {

        String composerPreview_URL = JOptionPane.showInputDialog("Please enter the ComposerURL:");

        //composerPreview_URL = "http://viewer.code.dev-gutools.co.uk/preview/global/2015/nov/17/tech-briefing";

        //Create the PREVIEW_URL
        String s = composerPreview_URL.replace(ENVIRONMENT_URL, "");

        System.out.println(s);

        PREVIEW_URL = MAPI_URL + s;

        //System.out.println(PREVIEW_URL);

        return PREVIEW_URL;
    }

    public static void sendEmail(String emailAddress) {

        //String to = emailAddress;
        String from = SENDER;
        //String host = HOST;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PWD);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailAddress));
            message.setSubject("Mobile App - Preview Link");
//            message.setContent(message, "text/html");
//            message.setText("Open the link in the app: \n" + PREVIEW_URL);

            message.setContent("<p>Please click the link to launch in the app and follow the on-board authentication " +
                    "prompts.</p><p>(Note: You must be signed in with a Guardian Email address)</p> " +
                            "<a href=//"+ PREVIEW_URL + ">" + PREVIEW_URL + "</a>", "text/html");

            Transport.send(message);

            JOptionPane.showMessageDialog(null, "The preview Link has been sent", "PREVIEW LINK SENT", JOptionPane.PLAIN_MESSAGE);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}


