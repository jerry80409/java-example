package behavioral.observer;

/**
 * Created by jerry on 2017/6/16.
 */
public abstract class Observer {
    // 觀察者要觀察的主題
    protected Subject subject;

    // 當主題變動時，要處理的動作
    public abstract void update();
}
