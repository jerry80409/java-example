package pool;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * Created by jerry on 2018/10/16.
 *
 * @author jerry
 */
public class FixExecutorExampleTest {

    private FixExecutorExample fixExecutor;

    @Before
    public void setUp() {
        this.fixExecutor = new FixExecutorExample();
    }

    @After
    public void tearDown() throws InterruptedException {
        fixExecutor.shutDown();
    }

    @Test
    public void testRunnable() throws InterruptedException, ExecutionException {
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread Name : " + name);
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda Thread processing.");
            }
        };

        // act
        Future<String> result = fixExecutor.useRunnable(task);
        Assert.assertEquals("invoke", result.get());
    }

    @Test
    public void testCallable()
            throws InterruptedException, ExecutionException, TimeoutException {

        Callable<Integer> task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread Name : " + name);
            int sum = 0;
            for (int i = 0; i <= 5; i++) {
                sum += i;
            }
            Thread.sleep(3000);
            System.out.println("Sum (0~5): " + sum);
            return sum;
        };

        // act
        Integer result = fixExecutor.useCallable(task);

        // assert
        Assert.assertEquals(new Integer(15), result);
    }
}
