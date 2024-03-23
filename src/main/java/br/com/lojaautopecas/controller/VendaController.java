package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.*;
import br.com.lojaautopecas.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/venda", "/venda/create", "/venda/create/submit"})
public class VendaController extends HttpServlet {
    private VendaDao vendaDao = new VendaDao();
    private ClienteDao clienteDao = new ClienteDao();
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private ServicoDao servicoDao = new ServicoDao();
    private PecaDao pecaDao = new PecaDao();

    public VendaController() throws SQLException {
    }

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
            List<Cliente> clientes = clienteDao.listarCliente();
            List<Servico> servicos = servicoDao.listarServicos();
            List<Peca> pecas = pecaDao.listarPeca();
            request.setAttribute("clientes", clientes);
            request.setAttribute("servicos", servicos);
            request.setAttribute("pecas", pecas);
            request.getRequestDispatcher("create/vendaCreate.jsp").forward(request,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void pageVenda(HttpServletRequest request, HttpServletResponse response) {
        try {
            String id = request.getParameter("id");
            //checar se pode ser um id mesmo
            Venda v = vendaDao.buscarVendaPorId(Integer.parseInt(id));
            Cliente c = clienteDao.buscarClientePorId(v.getId_Cliente());
            Funcionario f = funcionarioDao.buscarFuncionarioPorId(v.getId_Funcionario());
            request.setAttribute("venda", v);
            request.setAttribute("cliente", c);
            request.setAttribute("funcionario", f);
            request.getRequestDispatcher("venda/venda.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}