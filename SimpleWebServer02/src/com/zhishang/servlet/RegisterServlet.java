package com.zhishang.servlet;

import com.zhishang.core.Request;
import com.zhishang.core.Response;
import com.zhishang.core.Servlet;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            19:15 2019-01-28
 */
public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("</head>");
        response.println("<body>");
        response.println("<h1>");
        response.println("Here is register." + request.getParameterValue("name"));
        response.println("</h1>");
        response.println("</body>");
        response.println("</html>");
    }
}
