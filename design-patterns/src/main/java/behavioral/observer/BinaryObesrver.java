package behavioral.observer;

/**
 * Created by jerry on 2017/6/16.
 */
public class BinaryObesrver extends Observer {

    public BinaryObesrver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
