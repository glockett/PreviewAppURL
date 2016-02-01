import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;


public class PreviewAppURL {

    private static String ComposerPreview_URL;
    private static String PreviewApp_URL;
    private static final String Environment_URL = "http://viewer.code.dev-gutools.co.uk/preview/";
    private static final String MAPI_URL = "x-gu://preview.mobile-apps.guardianapis.com/items";
    private static final String SenderAddress = "gumobtest@gmail.com";
    private static final String Host = "localhost";

    public static void main(String[] args) {

        getAppPreviewURL();

        Scanner user_input = new Scanner(System.in);
        System.out.print("Please enter the email Address you wish to send the link too:\n");
        String emailAddress = user_input.next();

        sendEmail(emailAddress);
    }

    public static void getAppPreviewURL() {

        Scanner user_input = new Scanner(System.in);

        System.out.print("Please enter the Composer Preview URL:\n");

        ComposerPreview_URL = user_input.next();
        //Make the correct ComposerURL
        String s = ComposerPreview_URL.replace(Environment_URL, "");

        //System.out.println(s);

        PreviewApp_URL = MAPI_URL + s;

        //System.out.println(PreviewApp_URL);
    }

    public static void sendEmail(String emailAddress) {

        String to = emailAddress;
        String from = "gumobtest@gmail.com";
        String host = "local";
        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Mobile App Preview Link");
            message.setText("Open the link in the app: " + PreviewApp_URL);

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


