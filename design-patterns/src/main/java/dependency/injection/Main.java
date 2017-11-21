package dependency.injection;

/**
 * Created by jerry on 2017/11/21.
 */
public class Main {

    public static void main(String[] args) {
        Application app = new Application();
        app.notification("nice to meet you", "someone");
    }
}
