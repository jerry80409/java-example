import org.junit.Test;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by jerry on 2017/1/17.
 * 完整的範例說明, 參閱 @see
 * <a href="https://github.com/Froussios/Intro-To-RxJava/blob/master/Part%201%20-%20Getting%20Started/2.%20Key%20types.md>
 * https://github.com/Froussios/Intro-To-RxJava/blob/master/Part%201%20-%20Getting%20Started/2.%20Key%20types.md</a>
 */
public class RxJavaSubjectDemo {

    /**
     * 基本的 publishSubject,
     * 這邊註冊一個 function 為 System.out.println()
     * 當 publish 事件發生後, subscribe 會自動監聽, 依據 function 去做處理。
     * function 的部分, 可以用 java8 lambda 的方式處理。
     */
    @Test
    public void publishSubject() {
        // 發布者
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);

        // 訂閱者
        subject.subscribe(System.out::println);

        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
    }

    /**
     * ReplaySubject 可以做 caching, 但不確定 caching 的大小,
     * 全部 publish 事件都會被 caching,
     * 當後續的 subscribe 被註冊, caching 的資料都會被 subscribe 的 function 處理。
     */
    @Test
    public void replaySubject() {
        ReplaySubject<Integer> replay = ReplaySubject.create();
        replay.subscribe(i -> System.out.println("Early: " + i));
        replay.onNext(1);
        replay.onNext(2);
        replay.subscribe(i -> System.out.println("Late: " + i));
        replay.onNext(3);
        replay.onNext(4);
    }

    /**
     * ReplaySubject 可以做 caching, 這邊指定 caching 的大小, caching 只保留最新（後）的資料。
     * 這邊指定 size 為 2, 所以最一開始的 onNext(0) 的資料會遺失,
     * 因為超出 caching 的範圍。
     */
    @Test
    public void replaySubjectWithSize() {
        ReplaySubject<Integer> replay = ReplaySubject.createWithSize(2);
        replay.onNext(0);                               // 這筆資料會遺失
        replay.onNext(1);
        replay.onNext(2);
        replay.subscribe(i -> System.out.println("Late: " + i));
        replay.onNext(3);
    }

    /**
     * ReplaySubject 可以做 caching, 這邊指定 caching 的時間,
     * Schedulers 參閱 @see <a href="http://reactivex.io/documentation/scheduler.html#collapseRxJava 1․x>
     * http://reactivex.io/documentation/scheduler.html#collapseRxJava 1․x</a>
     */
    @Test
    public void replaySubjectWithTime() throws InterruptedException {
        // 設定快取在 150 ms 後, Schedulers 為目前的 threads
        ReplaySubject<Integer> replay = ReplaySubject.createWithTime(
                150, TimeUnit.MILLISECONDS, Schedulers.immediate());
        replay.onNext(0);
        Thread.sleep(100);
        replay.onNext(1);
        Thread.sleep(100);
        replay.onNext(2);
        replay.subscribe(i -> System.out.println("Late: " + i));
        replay.onNext(3);
    }

    /**
     * BehaviorSubject 類似 ReplaySubject,
     * 差異是 BehaviorSubject 固定 caching 最後 1 筆資料 (onNext(2))
     */
    @Test
    public void behaviorSubject() {
        BehaviorSubject<Integer> behavior = BehaviorSubject.create();
        behavior.onNext(0);
        behavior.onNext(1);
        behavior.onNext(2);
        behavior.subscribe(i -> System.out.println("Late: " + i));
        behavior.onNext(3);
    }

    /**
     * create(0) 可以初始化一筆 stream 的資料
     */
    @Test
    public void behaviorSubjectWithInit() {
        BehaviorSubject<Integer> behavior = BehaviorSubject.create(0);
        behavior.subscribe(i -> System.out.println("Last: " + i));
        behavior.onNext(1);
    }

    /**
     * onCompleted 會釋放 caching 的資料,
     * 之後的 publish 的資料就無法再經過 subscribe function 處理。
     */
    @Test
    public void behaviorSubjectOnCompleted() {
        BehaviorSubject<Integer> behavior = BehaviorSubject.create();
        behavior.onNext(0);
        behavior.onNext(1);
        behavior.onNext(2);
        behavior.onCompleted();

        behavior.onNext(3);
        behavior.subscribe(
                v -> System.out.println("Late: " + v),
                e -> System.out.println("Error: " + e.getMessage()),
                () -> System.out.println("Completed")
        );
    }

    /**
     * AsyncSubject 一樣只 caching 最後一筆 stream 資料,
     *
     */
    @Test
    public void asyncSubject() {
        AsyncSubject<Integer> async = AsyncSubject.create();
        async.subscribe(i -> System.out.println("Late: " + i));
        async.onNext(0);
        async.onNext(1);
        async.onNext(2);
        async.onNext(3);
        async.onNext(4);
        async.onCompleted();
    }
}
