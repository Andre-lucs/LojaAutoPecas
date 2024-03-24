package br.com.lojaautopecas.controller;

import br.com.lojaautopecas.dao.*;
import br.com.lojaautopecas.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/venda", "/venda/create", "/venda/create/submit",
        "/venda/servico/delete", "/venda/servico/add",
        "/venda/peca/delete", "/venda/peca/add",
})
public class VendaController extends HttpServlet {
    private VendaDao vendaDao = new VendaDao();
    private ClienteDao clienteDao = new ClienteDao();
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private ServicoDao servicoDao = new ServicoDao();
    private PecaDao pecaDao = new PecaDao();
    private VendaServicoDao vendaServicoDao = new VendaServicoDao();
    private VendaPecaDao vendaPecaDao = new VendaPecaDao();

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
        } else if (action.equals("/venda/servico/delete")) {
            deleteServicoFromVenda(request, response);
        } else if (action.equals("/venda/servico/add")) {
            addServicoToVenda(request, response);
        }else if (action.equals("/venda/peca/delete")) {
            deletePecaFromVenda(request, response);
        } else if (action.equals("/venda/peca/add")) {
            addPecaToVenda(request, response);
        }
    }

    private void addServicoToVenda(HttpServletRequest request, HttpServletResponse response) {
        //nova pagina?
    }

    private void deleteServicoFromVenda(HttpServletRequest request, HttpServletResponse response) {
        try {
            String vid = request.getParameter("vid");
            int idVenda = Integer.parseInt(vid);
            String sid = request.getParameter("sid");
            int idServico = Integer.parseInt(sid);
            Optional<VendaServico> vendaServicoOptional = vendaServicoDao.listarVendaServicosPorIdVenda(idVenda)
                    .stream().filter(vs -> vs.getId_Servico() == idServico).findFirst();
            if(vendaServicoOptional.isPresent()){
                vendaServicoDao.deletarVendaServico(vendaServicoOptional.get().getId());
            }
            request.getRequestDispatcher("venda?id="+vid).forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    private void addPecaToVenda(HttpServletRequest request, HttpServletResponse response) {
        //nova pagina?
    }

    private void deletePecaFromVenda(HttpServletRequest request, HttpServletResponse response) {
        try {
            String vid = request.getParameter("vid");
            int idVenda = Integer.parseInt(vid);
            String pid = request.getParameter("pid");
            int idPeca = Integer.parseInt(pid);
            Optional<VendaPeca> vendaPecaOptional = vendaPecaDao.listarVendaPecasPorIdVenda(idVenda)
                    .stream().filter(vs -> vs.getId_Peca() == idPeca).findFirst();
            if(vendaPecaOptional.isPresent()){
                vendaPecaDao.deletarVendaPeca(vendaPecaOptional.get().getId());
            }
            request.getRequestDispatcher("venda?id="+vid).forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
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
            List<Servico> servicos_venda = vendaServicoDao.listarVendaServicosPorIdVenda(v.getId()).stream().
                    map(VendaServico::getId_Servico).map(sid -> servicoDao.buscarServicoPorId(sid))
                    .collect(Collectors.toList());
            List<Peca> pecas_venda = vendaPecaDao.listarVendaPecasPorIdVenda(v.getId()).stream()
                    .map(VendaPeca::getId_Peca).map(pid -> pecaDao.buscarPecaPorId(pid))
                    .collect(Collectors.toList());
            request.setAttribute("venda", v);
            request.setAttribute("cliente", c);
            request.setAttribute("funcionario", f);
            request.setAttribute("servicos", servicos_venda);
            request.setAttribute("pecas", pecas_venda);
            request.getRequestDispatcher("venda/venda.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}