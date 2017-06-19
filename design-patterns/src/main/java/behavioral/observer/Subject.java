package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 2017/6/16.
 * <p>
 * Subject 應該只提供註冊與通知功能。
 * Subject 變動時，會主動通知 Observer。
 * 並驅動 observer 的 update 處理。
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    // 加入這個主題的訂閱
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 當主題更新時，通知訂閱者
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
