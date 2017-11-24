/**
 * HelloServlet.java 2017.11.10.
 * <p>
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 메소드 호출");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        //contenTtype 정의
        response.setContentType("text/html");
        writer.println("<html>");
        writer.println("<head>jpub java webservice</head>");
        writer.println("<body> get 요청 예제입니다.. </body>");
        writer.println("<html>");
    }
}
