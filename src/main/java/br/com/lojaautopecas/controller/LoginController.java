package br.com.lojaautopecas.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/functionaryLogin"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/functionaryLogin")){
            loginFunctionary(request, response);
        }
    }

    private void loginFunctionary(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //login

        //salvar sessao

        RequestDispatcher rd = request.getRequestDispatcher("MainController");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}