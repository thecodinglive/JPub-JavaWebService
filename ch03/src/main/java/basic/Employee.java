package basic;

/**
 * Created by yun_dev1 on 2016-03-25.
 */
public class Employee implements WorkManager{
    @Override
    public String doIt() {
        return "do work";
    }

    public void onCreated() {
        System.out.println("Employee 생성");
    }

    public void onDestroyed() {
        System.out.println("Employee 소멸");
    }
}
