/**
 * ImageFilter.java 2017.11.29.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(urlPatterns = {"*.png", "*.jpg", "*.gif"})
public class ImageFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {
		System.out.println("ImageProtectorFilter");
		HttpServletRequest httpServletRequest =
			(HttpServletRequest)request;
		String referrer = httpServletRequest.getHeader("referer");
		System.out.println("referrer:" + referrer);
		if (referrer != null) {
			chain.doFilter(request, response);
		} else {
			throw new ServletException("Image not available");
		}
	}

	@Override
	public void destroy() {

	}
}
