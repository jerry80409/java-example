package simple;

/**
 * Created by jerry on 2018/10/15.
 *
 * @author jerry
 */
public class OopsThread implements Runnable {

    private int sum = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= 5; i++) {
                sum += i;
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread name: " + threadName + " sum: " + sum);
            }
            System.out.println("===");
        }
    }
}
