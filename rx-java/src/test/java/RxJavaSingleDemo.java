import org.junit.Test;
import rx.Single;
import rx.SingleSubscriber;

/**
 * Created by jerry on 2017/1/17.
 * Demo RxJava Single
 */
public class RxJavaSingleDemo {

    private static Integer addValue(int a, int b) {
        return a + b;
    }

    @Test
    public void single() {
        Single.just(addValue(1, 2))
                .subscribe(new SingleSubscriber<Integer>() {
                    @Override
                    public void onSuccess(Integer integer) {
                        System.out.println("Result: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
    }

    /**
     * 簡單的處理 "加法" 計算,
     * 結果小於 0 時會丟出 Exception
     */
    @Test
    public void singleWithLambdaCase1() {
        Single.just(addValue(1, 2))
                .map(input -> {
                    if (input < 0) {
                        throw new RuntimeException("negative number");
                    }
                    return input;
                }).subscribe(
                v -> System.out.println("Input: " + v),
                e -> System.out.println("Error: " + e.getMessage())
        );
    }

    /**
     * 簡單的處理 "加法" 計算,
     * 結果小於 0 時會丟出 Exception
     */
    @Test
    public void singleWithLambdaCase2() {
        Single.just(addValue(1, -2))
                .map(input -> {
                    if (input < 0) {
                        throw new RuntimeException("negative number");
                    }
                    return input;
                }).subscribe(
                v -> System.out.println("Input: " + v),
                e -> System.out.println("Error: " + e.getMessage())
        );
    }

    /**
     * compose 裡面可以自定義 stream 的運算邏輯,
     * 這個例子沒有很好, 這樣用感覺像脫褲子放屁
     */
    @Test
    public void singleWithCompose() {
        Single.just(addValue(1, 2))
                .compose(input -> input.map(integer -> Math.abs(integer)))
                .subscribe(
                        v -> System.out.println("Input: " + v),
                        e -> System.out.println("Error: " + e.getMessage())
                );
    }

    /**
     * Single 的集合, 有順序執行
     */
    @Test
    public void singleConcat() {
        Single.concat(
                Single.just("ACTION1"),
                Single.just("ACTION2"),
                Single.just("ACTION3")
        ).subscribe(act -> System.out.println(act));
    }
    
}
