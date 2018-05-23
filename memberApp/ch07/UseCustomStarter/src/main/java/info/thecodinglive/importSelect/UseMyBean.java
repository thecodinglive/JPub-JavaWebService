package info.thecodinglive.importSelect;

import org.springframework.beans.factory.annotation.Autowired;

public class UseMyBean {
    @Autowired
    private MyBean myBean;

    public void printMsg() {
        System.out.println(myBean.getMsg());
    }
}
