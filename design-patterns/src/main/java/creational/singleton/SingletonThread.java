package creational.singleton;

import java.util.Objects;

/**
 * Created by jerry on 2017/7/31.
 */
public class SingletonThread extends Thread {
    private String id;

    public SingletonThread(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        SingletonGreed singleton = SingletonGreed.getInstance();

        if(Objects.nonNull(singleton)) {
            System.out.println(id + " Singleton: " + singleton.hashCode());
        }
    }
}
