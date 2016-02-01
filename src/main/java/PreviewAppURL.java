import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;


public class PreviewAppURL {

    private final String USERNAME = "gwyn.lockett@gmail.com";
    private final String PWD = "password";
    private static String PREVIEW_URL;
    private static final String ENVIRONMENT_URL = "http://viewer.code.dev-gutools.co.uk/preview/";
    private static final String MAPI_URL = "x-gu://preview.mobile-apps.guardianapis.com/items";
    private static final String SENDER = "gumobtest@gmail.com";
    private static final String HOST = "localhost";

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

        String composerPreview_URL = user_input.next();

        //Create the PREVIEW_URL
        String s = composerPreview_URL.replace(ENVIRONMENT_URL, "");

        System.out.println(s);

        PREVIEW_URL = MAPI_URL + s;

        System.out.println(PREVIEW_URL);
    }

    public static void sendEmail(String emailAddress) {

        String to = emailAddress;
        String from = SENDER;
        String host = HOST;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

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
            message.setText("Open the link in the app: \n" + PREVIEW_URL);

            Transport.send(message);

            System.out.println("message sent successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}


