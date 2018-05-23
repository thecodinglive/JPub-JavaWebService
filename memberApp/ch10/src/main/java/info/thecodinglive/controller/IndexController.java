package info.thecodinglive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yun_dev1 on 2016-12-20.
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String indexController(){
        return "info";
    }
}
