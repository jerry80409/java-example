package simple;

/**
 * Created by jerry on 2017/6/12.
 *
 * 建立 Thread 的方法有 2 種
 * 1. 繼承 thread
 * 2. 實作 Runnable Interface
 */
public class SimpleThread {


    public SimpleThread(SuperThread superThread) {
        superThread.start();
    }

    public SimpleThread(ImplRunnableThread implRunnableThread) {
        implRunnableThread.run();
    }

    public SimpleThread(LambdaThread lambdaThread) {
        Thread thread = new Thread(lambdaThread.getTask());
        thread.run();
    }
}
