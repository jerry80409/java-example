package daemon;

/**
 * Created by jerry on 2017/6/12.
 * Daemon Threads
 *
 */
public class JavaDaemonThread {

    public JavaDaemonThread() throws InterruptedException {
        // 建立 Daemon thread , 名稱為 test-daemon-thread
        Thread thread = new Thread(new DaemonThread(), "test-daemon-thread");

        // 設定為 Daemon
        thread.setDaemon(true);

        // start thread
        thread.start();
        thread.sleep(10000);

        System.out.println("Finishing Program");
    }
}
