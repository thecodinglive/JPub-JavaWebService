package info.thecodinglive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * Created by ysj on 2017-11-06.
 */
@ControllerAdvice
public class ResourceAdvice {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("verionResourceResolver")
    public ResourceUrlProvider versionResourceResolver() {
        return this.resourceUrlProvider;
    }
}
