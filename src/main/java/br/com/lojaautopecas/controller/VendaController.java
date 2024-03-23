package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.VendaDao;
import br.com.lojaautopecas.model.Venda;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/venda", "/venda/create", "/venda/create/submit"})
public class VendaController extends HttpServlet {
    private VendaDao vendaDao = new VendaDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/venda")){
            pageVenda(request, response);
        }else if(action.equals("/venda/create")){
            pageVendaCreate(request, response);
        } else if (action.equals("/venda/create/submit")) {
            vendaCreate(request, response);
        }
    }

    private void vendaCreate(HttpServletRequest request, HttpServletResponse response) {
        Venda venda = new Venda();
        //getatributtes
        //salva a venda
        try {
            request.getRequestDispatcher("venda").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pageVendaCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("create/vendaCreate.jsp").forward(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void pageVenda(HttpServletRequest request, HttpServletResponse response) {
        try {
            var id = request.getAttribute("id");
            request.setAttribute("id", id);
            request.getRequestDispatcher("venda.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}