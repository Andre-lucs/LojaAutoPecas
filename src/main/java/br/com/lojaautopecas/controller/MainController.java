package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.VendaDao;
import br.com.lojaautopecas.model.Venda;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private VendaDao vendaDao = new VendaDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Venda> vendaList = new ArrayList<>();//vendaDao.findAll();
        vendaList.add(new Venda());
        vendaList.add(new Venda());
        vendaList.add(new Venda());
        System.out.println("vendaList");
        request.setAttribute("vendas", vendaList);
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");

        rd.forward(request, response);
    }
}