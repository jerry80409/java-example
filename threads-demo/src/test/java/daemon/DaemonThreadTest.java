package daemon;

import org.junit.Test;

/**
 * Created by jerry on 2017/6/12.
 */
public class DaemonThreadTest {

    @Test
    public void daemonThreadTest() throws InterruptedException {
        new JavaDaemonThread();
    }
}
