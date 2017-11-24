/**
 * CaptchaBuilder.java 2017.11.23.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.util;

import jj.play.ns.nl.captcha.Captcha;

public class CaptchaBuilder {
    public Captcha basicCaptcha() {
        Captcha captcha = new Captcha.Builder(200, 50)
                .addText()
                .build();
        return captcha;

    }
}
