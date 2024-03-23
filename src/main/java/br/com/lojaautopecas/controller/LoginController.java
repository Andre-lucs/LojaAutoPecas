package br.com.lojaautopecas.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/login/submit", "/logout"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/login")){
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }else if(action.equals("/login/submit")){
            loginFunctionary(request, response);
        }else if(action.equals("/logout")){
            logoutFunctionary(request, response);
        }
    }

    private void logoutFunctionary(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logout");
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie cookie = new Cookie("login", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginFunctionary(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //login
        //int id = funcionarioDao.login(username, password);
        //salvar sessao
        //Cookie loginCookie = new Cookie("login", id);
        //loginCookie.setMaxAge(60*60*12);//12 horas
        //response.addCookie(loginCookie);
        //HttpSession session = request.getSession(true);
        //session.setAttribute("login", id);
        try {
            response.sendRedirect("../main");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}