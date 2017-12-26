package info.thecodinglive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by jins on 2017-06-06.
 */
@Controller
public class IndexController {

	@RequestMapping("/")
    public ModelAndView home(){
       // return new ModelAndView("home");
        ModelAndView mv=new ModelAndView("home");
        mv.addObject("title", "Jpub Spring WEB");
        mv.addObject("today", new Date().toString());

        return mv;
    }
}
