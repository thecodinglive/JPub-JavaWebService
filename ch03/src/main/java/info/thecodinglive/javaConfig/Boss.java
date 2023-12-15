package info.thecodinglive.javaConfig;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Boss implements WorkManager {
    @Override
    public String doIt() {
        return "do boss";
    }

    @PostConstruct
    public void onCreated() {
        System.out.println("boss 초기화");
    }

    @PreDestroy
    public void onDestroyed() {
        System.out.println("boss 소멸");
    }
}
