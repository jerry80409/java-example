package daemon;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jerry on 2017/6/12.
 *
 * note - 應該避免在 Daemon Thread 記錄任何狀態，因為他隨時可能被 Interrupted
 */
@Slf4j
public class DaemonThread implements Runnable {

    private Boolean isThreadStart = Boolean.TRUE;

    @Override
    public void run() {
        while (isThreadStart) {
            try {
                System.out.println("Processing Daemon Thread");
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                log.error("Daemon Thread is Interrupted Exception: {}", e.getMessage());
            }
        }
    }
}
