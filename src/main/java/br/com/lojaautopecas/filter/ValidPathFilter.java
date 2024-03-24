package br.com.lojaautopecas.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ValidPathFilter", urlPatterns = {"/*"})
public class ValidPathFilter implements Filter {
    private final String[] validPaths = {
            "/", "/index.html", "/error", "/main",
            "/login", "/login/submit", "/logout",
            "/venda", "/venda/create", "/venda/create/submit",
            "/cliente", "/cliente/create", "/cliente/update", "/cliente/delete",
    };
    public void init(FilterConfig config) throws ServletException {
    } 

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        String path = httpReq.getServletPath();
        System.out.print(path);
        if (isValidPath(path) || path.startsWith("/resources/")) {
            System.out.println(" passou");
            chain.doFilter(request, response);
        } else {
            Cookie cookie = new Cookie("login", "");
            cookie.setMaxAge(0);
            httpResp.addCookie(cookie);
            httpResp.sendRedirect(httpReq.getContextPath()+"/error?error=InvalidPath");//pagina de error
        }
    }

    private boolean isValidPath(String path) {
        for (String validPath : validPaths) {
            if (path.equals(validPath)) {
                return true;
            }
        }
        return false;
    }
}