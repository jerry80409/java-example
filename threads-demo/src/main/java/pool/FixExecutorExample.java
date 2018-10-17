package pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by jerry on 2018/10/15.
 *
 * @author jerry
 */
public class FixExecutorExample {

    private ExecutorService executorService;

    /** 初始化 ExecutorService */
    public FixExecutorExample() {
        this.executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());
    }

    /**
     * runnable 使用 ExecutorService
     * @param runnable
     * @return
     */
    public Future<String> useRunnable(Runnable runnable) {

        String invoke = "invoke";
        return executorService.submit(runnable, invoke);
    }

    /**
     * callable 使用 ExecutorService
     *
     * @param callable
     * @param <T>
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public <T> T useCallable(Callable<T> callable)
            throws ExecutionException, InterruptedException, TimeoutException {
        Future<T> future = executorService.submit(callable);

        // 呼叫 get(), 會等到 async 處理完成才回傳
        // return future.get();

        // 避免無限期 block, 可以設定 timeout, 會拋出 TimeoutException
        return future.get(10, TimeUnit.SECONDS);
    }

    /**
     * 關閉 threads pool
     */
    public void shutDown() throws InterruptedException {

        // 所有工作結束後, 才會 shutdown
        executorService.shutdown();

        // 如果 5 秒內, 工作還未完成, 強制 shutdown
        // executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

}
