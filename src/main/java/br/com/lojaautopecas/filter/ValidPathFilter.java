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
            "/venda", "/venda/create", "/venda/create/submit", "/venda/delete",
            "/venda/servico/delete", "/venda/servico/add", "/venda/peca/delete", "/venda/peca/add",
            "/cliente", "/cliente/create", "/cliente/create/submit", "/cliente/update", "/cliente/update/submit", "/cliente/delete",
            "/funcionario/create", "/funcionario/create/submit", "/funcionario/update", "/funcionario/update/submit", "/funcionario", "/funcionario/delete", "/funcionarios",

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
            httpResp.sendError(404);
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