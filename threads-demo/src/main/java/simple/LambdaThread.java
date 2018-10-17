package simple;

/**
 * Created by jerry on 2017/6/12.
 */
public class LambdaThread {

    private int times = 5;
    private Runnable task;

    public LambdaThread(int times) {
        this.times = times;
        this.task = initThread();
    }

    public Runnable getTask() {
        return this.task;
    }

    private Runnable initThread() {
        // 這一段 lambda 相等於 implement Runnable
        return () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread Name : " + name);

            for (int i = 0; i < times; i++) {
                System.out.println("Lambda Thread processing.");
            }
        };
    }
}
