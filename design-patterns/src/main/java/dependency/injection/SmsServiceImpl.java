package dependency.injection;

/**
 * Created by jerry on 2017/11/22.
 */
public class SmsServiceImpl implements MessageService {

    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("SMS sent to " + receiver + " with Message=" + message);
    }
}
