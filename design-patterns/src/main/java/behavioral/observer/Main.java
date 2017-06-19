package behavioral.observer;

/**
 * Created by jerry on 2017/6/16.
 *
 * Observer 觀察者模式
 * 優點:
 * 1. 保持物件與物件之間的關係, subject 變動就通知 observers
 * 2. Subject 不需要知道被誰觀察
 *
 * 缺點:
 * 1. 無法知道 observer 發生了什麼變化
 * 2. observer 應該盡量避免對 subject 的操作，避免循環問題
 */
public class Main {
    public static void main(String[] args) {
        // 主題
        Subject subject = new Subject();

        // 訂閱者
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObesrver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        System.out.println("Second state change 200");
        subject.setState(200);
    }
}
