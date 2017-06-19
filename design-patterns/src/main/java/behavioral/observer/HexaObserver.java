package behavioral.observer;

/**
 * Created by jerry on 2017/6/16.
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        // 轉為 16 進制, 大寫
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
