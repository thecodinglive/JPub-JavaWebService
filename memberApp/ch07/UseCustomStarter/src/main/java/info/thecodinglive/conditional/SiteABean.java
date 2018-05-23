package info.thecodinglive.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(SiteAConfigCondition.class)
public class SiteABean implements MsgBean{
    @Override
    public void printMsg() {
        System.out.printf("Site A is working");
    }
}
