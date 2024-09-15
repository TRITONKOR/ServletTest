package org.example.servlettest.persistence;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/info")
public class SimpleHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(true);
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("counter", counter);

        resp.setContentType("text/html");
        resp.getWriter().write("<html><body>");
        resp.getWriter().write("<h1>Request Information</h1>");
        resp.getWriter().write("<p>Context Path: " + req.getContextPath() + "</p>");
        resp.getWriter().write("<p>Servlet Path: " + req.getServletPath() + "</p>");
        resp.getWriter().write("<p>Path Info: " + req.getPathInfo() + "</p>");
        resp.getWriter().write("<p>Query String: " + req.getQueryString() + "</p>");
        resp.getWriter().write("<p>Parameter 'param1': " + req.getParameter("param1") + "</p>");
        resp.getWriter().write("<p>Parameter 'param2': " + req.getParameter("param2") + "</p>");
        resp.getWriter().write("<p>User-Agent: " + req.getHeader("User-Agent") + "</p>");
        resp.getWriter().write("<p>Session Counter: " + counter + "</p>");
        resp.getWriter().write("</body></html>");
    }
}
