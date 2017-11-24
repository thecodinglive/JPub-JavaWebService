/**
 * JsonPControllerAdvice.java 2017.11.07.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class JsonPControllerAdvice extends AbstractJsonpResponseBodyAdvice {
    /*
    public JsonPControllerAdvice(String... queryParamNames) {
        super(queryParamNames);
    }
    */
    public JsonPControllerAdvice() {
        super("bootCallback");
    }
}
