package basic;

/**
 * Created by yun_dev1 on 2016-03-25.
 */
public class Employee implements WorkManager{
    @Override
    public String doIt() {
        return "do work";
    }
}
