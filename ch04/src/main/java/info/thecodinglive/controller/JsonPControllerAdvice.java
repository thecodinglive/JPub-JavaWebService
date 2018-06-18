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
