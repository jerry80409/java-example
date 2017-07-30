package creational.singleton;

/**
 * Created by jerry on 2017/7/31.
 */
public class Main {

    public static void main(String[] args) {
        // 單執行緒的時候, s1, s2 確認為相同的物件
        SingletonGreed s1 = SingletonGreed.getInstance();
        SingletonGreed s2 = SingletonGreed.getInstance();

        System.out.println("S1:" + s1.hashCode());
        System.out.println("S2:" + s2.hashCode());

        // 多執行緒的時候
        Thread t1 = new SingletonThread("t1 thread");
        Thread t2 = new SingletonThread("t2 thread");
        Thread t3 = new SingletonThread("t3 thread");
        t1.start();
        t2.start();
        t3.start();
    }
}
