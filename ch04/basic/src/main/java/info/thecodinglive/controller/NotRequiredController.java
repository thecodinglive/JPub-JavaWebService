package info.thecodinglive.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class NotRequiredController {

    @RequestMapping("/req")
    public String requreHi(@RequestParam String primary,
                           @RequestParam(value ="sub", required=false ) String sub, Model model){
        System.out.println(primary);
        return "home";
    }
}
