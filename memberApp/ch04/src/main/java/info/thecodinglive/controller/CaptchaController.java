/**
 * CaptchaController.java 2017.11.23.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.controller;

import info.thecodinglive.util.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CaptchaController {
    @RequestMapping("/ch")
    public void genCh(HttpServletRequest req, HttpServletResponse resp,
                      HttpSession session) {
        /*
        Captcha captcha = new Captcha
                .Builder(250, 60)
                .addText()
                .addBackground()
                .addNoise()
                .addBorder()
                .build();

        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");

        CaptchaUtil.writeImage(resp, captcha.getImage());
        //req.getSession().setAttribute("correctAnswer", captcha.getAnswer());
        session.setAttribute("correctAnswer", captcha.getAnswer());
        System.out.println("captcha 자동가입방지 문자" + captcha.getAnswer());
        */
    }

    @RequestMapping("/chjoin")
    public ModelAndView joinP(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chjoin");
        String answer = (String) session.getAttribute("correctAnswer");
        System.out.println("answer::" + answer);
        return mv;
    }
}
