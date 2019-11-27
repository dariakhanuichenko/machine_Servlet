package ua.training.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = session.getServletContext();
        System.out.println("------------------------------------------------");
        System.out.println(session);
        System.out.println(session.getAttribute("role")+" " +session.getAttribute("userEmail"));
        System.out.println("Auth filter work: "+ context.getAttribute("loggedUsers"));
        System.out.println("________________________________________________");

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
