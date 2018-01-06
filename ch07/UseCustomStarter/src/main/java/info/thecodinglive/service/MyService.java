package info.thecodinglive.service;

import info.thecodinglive.config.MyAnnotation;

public class MyService {
    @MyAnnotation(strValue = "hi", intValue = 0607)
    public void printSomething() {
        System.out.println("test my annotation");
    }
}
