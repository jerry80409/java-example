package complete;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jerry on 2018/10/16.
 *
 * @author jerry
 */
public class CompleteExampleTest {

    /**
     * <code>runAsync()</code> 沒有回傳值的 async
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void runAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Invoke some api...");
        });

        future.get();
    }

    /**
     * <code>supplyAsync()</code> 有回傳值的 async
     */
    @Test
    public void supplyAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Invoke some api...");
            return "Invoke some api...";
        });

        String result = future.get();
        System.out.println("After invoke some api: " + result);
    }

    @Test
    public void thenApplyExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Invoke A api...");
            return "Invoke A api...";
        });

        future.thenApply(result -> applyCallback(result));
        String result = future.get();
        System.out.println("After invoke A api: " + result);
    }

    private String applyCallback(String apiResult) {
        if (Objects.nonNull(apiResult)) {
            System.out.println("Handle A api result to do something...");
            return "processing done";
        }

        System.out.println("Invoke A api failed");
        return null;
    }

    @Test
    public void thenComposeExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name: " + threadName + ", Invoke A api...");
            return "Invoke A api...";
        });

        future.thenCompose(result -> composeInvokeApi(result));
        String result = future.get();
        System.out.println("After invoke api: " + result);
    }

    private CompletableFuture<String> composeInvokeApi(String apiResult) {
        return CompletableFuture.supplyAsync(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Handle A api result [" + apiResult + "] to do something...");
            System.out.println("Thread name: " + threadName + ", Invoke B api...");
            return "Invoke B api...";
        });
    }

    @Test
    public void multipleFuturesParallelExample()
            throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " account 1 call api...");
            return "account 1 api result";
        });
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " account 2 call api...");
            return "account 2 api result";
        });
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " account 3 call api...");
            return "account 3 api result";
        });

        CompletableFuture<Void> parallelFuture
                = CompletableFuture.allOf(future1, future2, future3);
        //        = CompletableFuture.anyOf(future1, future2, future3);

        parallelFuture.get();

        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());
    }
}
