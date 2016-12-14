package info.thecodinglive.service;

/**
 * Created by yun_dev1 on 2016-08-30.
 */
public class ConsoleHello implements HelloService{
    @Override
    public void hi() {
        System.out.println("hello in console");
    }
}
