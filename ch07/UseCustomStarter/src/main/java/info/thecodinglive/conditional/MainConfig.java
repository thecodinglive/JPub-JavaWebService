package info.thecodinglive.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
   @Autowired
    MsgBean msgBean;
}
