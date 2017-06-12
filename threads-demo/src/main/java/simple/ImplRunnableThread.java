package simple;

/**
 * Created by jerry on 2017/6/12.
 */
public class ImplRunnableThread implements Runnable {

    private int times = 5;


    public ImplRunnableThread(int times) {
        this.times = times;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread Name : " + name);

        for (int i=0; i<times; i++) {
            System.out.println("Runnable Thread Processing");
        }
    }
}
