package dependency.injection;

/**
 * Created by jerry on 2017/11/21.
 */
public class Application {

    private EmailService emailService = new EmailService();

    public void notification(String message, String receiver) {
        this.emailService.sendEmail(message, receiver);
    }
}
