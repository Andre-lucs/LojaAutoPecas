package br.com.lojaautopecas.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    private String[] allowedPaths = {"/index.html", "/login", "/", "/login/submit", "/error",};
    private String[] allowedFolders = {"/resources/", "/WEB-INF/"};
    private String[] initialPaths = {"/", "/index.html", "/login", "/login/submit"};

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String path = httpReq.getServletPath();

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        String id = null;
        if (session != null) {
             id = ""+session.getAttribute("login");
        }

        if (id == null || id.equals("null") || id.isBlank() || id.isEmpty() || id.equals("-1")) {//not logged
            System.out.println("not logged");
            if(isValidPath(path)){
                System.out.println("path: " + path+" is valid");
                chain.doFilter(request, response);
                return;
            }
            ((HttpServletResponse) response).sendRedirect(httpReq.getContextPath()+"/login");
            return;
        } else {
            System.out.println("is logged id: "+id);
            if(isInInitialPaths(path)){
                ((HttpServletResponse) response).sendRedirect(httpReq.getContextPath()+"/main");
                return;
            }
            chain.doFilter(request, response);
        }
    }
    private boolean isValidPath(String path) {
        for (String validPath : allowedPaths) {
            if (path.equals(validPath)) {
                return true;
            }
        }
        for (String validFolderPath : allowedFolders){
            if (path.startsWith(validFolderPath)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInInitialPaths(String path){
        for (String validPath : initialPaths) {
            if (path.equals(validPath)) {
                return true;
            }
        }
        return false;
    }
}