package simple;

import org.junit.Test;

/**
 * Created by jerry on 2017/6/12.
 */
public class SimpleThreadTest {

    @Test
    public void superThreadTest() {
        new SimpleThread(
                new SuperThread(5));

    }

    @Test
    public void implThreadTest() {
        new SimpleThread(
                new ImplRunnableThread(5)
        );
    }

    @Test
    public void lambdaThreadTest() {
        new SimpleThread(
                new LambdaThread(5)
        );
    }

}
