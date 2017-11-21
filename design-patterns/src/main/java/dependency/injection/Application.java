package dependency.injection;

/**
 * Created by jerry on 2017/11/21.
 */
public class Application {

    private MessageService messageService;

    public Application(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notification(String message, String receiver) {
        this.messageService.sendMessage(message, receiver);

    }
}
