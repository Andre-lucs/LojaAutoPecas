package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.VendaDao;
import br.com.lojaautopecas.model.Venda;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/main"})
public class MainController extends HttpServlet {
    private VendaDao vendaDao = new VendaDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        pageMain(request, response);
    }

    private void pageMain(HttpServletRequest request, HttpServletResponse response) {
        List<Venda> vendaList = vendaDao.listarVendas();
        var v = new Venda();
        v.setId(1);
        v.setData(new Date());
        v.setId_Cliente(1);
        v.setId_Funcionario(1);
        v.setValor_Total(1000d);
        vendaList.add(v);
        request.setAttribute("vendas", vendaList);
        RequestDispatcher rd = request.getRequestDispatcher("main/main.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}