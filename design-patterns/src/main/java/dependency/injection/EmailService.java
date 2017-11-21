package dependency.injection;

/**
 * Created by jerry on 2017/11/21.
 */
public class EmailService {

    public void sendEmail(String message, String receiver) {
        System.out.println("Email sent to " + receiver + " with Message=" + message);
    }
}
