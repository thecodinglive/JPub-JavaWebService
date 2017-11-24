/**
 * ResourceAdvice.java 2017.10.26.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice
public class ResourceAdvice {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("versionResourceResolver")
    public ResourceUrlProvider versionResouceResolver() {
        return this.resourceUrlProvider;
    }
}
