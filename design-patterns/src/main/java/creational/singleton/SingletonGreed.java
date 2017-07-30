package creational.singleton;

import java.util.Objects;

/**
 * Created by jerry on 2017/7/31.
 * <p>
 * 單例模式：保證一個 class 只會產生一個 Instance，並且提供統一的存取方法。
 * 這種模式又被稱為 “貪婪模式”，但我不是很理解這個名稱的由來。
 */
public class SingletonGreed {

    private static SingletonGreed instance;

    // private construct 可以用來避免此 class 被實例化 (new Instance)
    private SingletonGreed() {
    }

    /**
     * 統一存取 Instance 的介面
     * 透過 synchronized 來確保多執行緒運作時，不會產生新的 instance
     *
     * @return {@link SingletonGreed}
     */
    public static SingletonGreed getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (SingletonGreed.class) {
                if (Objects.isNull(instance)) {
                    instance = new SingletonGreed();
                }
            }
        }
        return instance;
    }
}
