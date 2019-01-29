package com.zhishang.servlet;

import com.zhishang.core.Request;
import com.zhishang.core.Response;
import com.zhishang.core.Servlet;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            19:14 2019-01-28
 */
public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("</head>");
        response.println("<body>");
        response.println("<h1>");
        response.println("Here is login." + request.getParameterValue("name"));
        response.println("</h1>");
        response.println("</body>");
        response.println("</html>");
    }
}
