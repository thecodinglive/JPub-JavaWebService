package info.thecodinglive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping(value = "/th")
    public String templatePage(Model model){
        model.addAttribute("message", "boot template");

        return "th";
    }
}
