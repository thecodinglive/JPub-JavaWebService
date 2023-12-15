package info.thecodinglive.javaConfig;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Employee implements WorkManager {
    @Override
    public String doIt() {
        return "do work";
    }

    @PostConstruct
    public void onCreated() {
        System.out.println("employee 초기화");
    }

    @PreDestroy
    public void onDestroyed() {
        System.out.println("employee 소멸");
    }
}
