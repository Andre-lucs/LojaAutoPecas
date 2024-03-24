package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.FuncionarioDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/index.html","/login", "/login/submit", "/logout"})
public class LoginController extends HttpServlet {
    FuncionarioDao funcionarioDao = new FuncionarioDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/index.html")){
          response.sendRedirect("login");
        } else if(action.equals("/login")){
            System.out.println("Login");
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }else if(action.equals("/login/submit")){
            loginFunctionary(request, response);
        }else if(action.equals("/logout")){
            logoutFunctionary(request, response);
        }
    }

    private void logoutFunctionary(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logout");
        HttpSession session = request.getSession(false);
        session.invalidate();

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
        int id = funcionarioDao.validarCpfSenha(username, password);
        System.out.println("login id : "+id);
        if(id != -1){//passou
            //salvar sessao
            HttpSession session = request.getSession(true);
            session.setAttribute("login", id);
            try {
                response.sendRedirect("../main");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}