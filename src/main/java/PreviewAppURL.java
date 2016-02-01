import java.util.Scanner;


public class PreviewAppURL {

    private static String ComposerPreview_URL;
    private static String PreviewApp_URL;
    private static final String Environment_URL = "http://viewer.code.dev-gutools.co.uk/preview/";
    private static final String MAPI_URL = "x-gu://preview.mobile-apps.guardianapis.com/items/";


    public static void main(String[] args) {

        getAppPreviewURL();

        //sendEmail()
    }

    public static void getAppPreviewURL() {

        Scanner user_input = new Scanner(System.in);

        System.out.print("Please enter the Composer Preview URL:\n");

        ComposerPreview_URL = user_input.next();
        //Make the correct ComposerURL
        String s = ComposerPreview_URL.replace(Environment_URL, "");

        System.out.println(s);

        PreviewApp_URL = MAPI_URL + s;

        System.out.println(PreviewApp_URL);
    }


}
