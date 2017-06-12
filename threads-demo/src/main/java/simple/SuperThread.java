package simple;

/**
 * Created by jerry on 2017/6/12.
 * <p>
 * 繼承 thread class
 */
public class SuperThread extends Thread {

    private int times = 5;

    public SuperThread(int times) {
        this.times = times;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread Name : " + name);

        for (int i = 0; i < times; i++) {
            System.out.println("Extends Thread Processing");
        }
    }
}
