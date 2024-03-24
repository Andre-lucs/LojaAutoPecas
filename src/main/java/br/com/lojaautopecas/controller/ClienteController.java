package br.com.lojaautopecas.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaautopecas.dao.ClienteDao;
import br.com.lojaautopecas.dao.VeiculoDao;
import br.com.lojaautopecas.model.Cliente;
import br.com.lojaautopecas.model.Veiculo;



@WebServlet(urlPatterns = {"/cliente", "/cliente/create", "/cliente/update", "/cliente/delete"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao = new ClienteDao();
	private VeiculoDao veiculoDao = new VeiculoDao();
   
    public ClienteController() throws SQLException {
      
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
        if(action.equals("/cliente")){
            pageClientes(request, response);
        }else if(action.equals("/cliente/create")){
            pageClienteCreate(request, response);
        } else if (action.equals("/cliente/create/submit")) {
            clienteCreate(request, response);
        } else if(action.equals("/cliente/update")) {
        	pageClienteUpdate(request, response);
        } else if (action.equals("/cliente/update/submit")) {
        	clienteUpdate(request, response);
        } else if (action.equals("/cliente/delete")) {
        	clienteDelete(request, response);
        }
	}

	 private void clienteCreate(HttpServletRequest request, HttpServletResponse response) {
	        Cliente cliente = new Cliente();
	        Veiculo veiculo = new Veiculo();
	        
	        cliente.setNome(request.getParameter("name"));
	        cliente.setCpf(request.getParameter("cpf"));
	        
	        veiculo.setAno(Integer.parseInt(request.getParameter("ano")));
	        veiculo.setMarca(request.getParameter("marca"));
	        veiculo.setModelo(request.getParameter("modelo"));
	        
	        try {
				clienteDao.inserirCliente(cliente);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        try {
	            request.getRequestDispatcher("cliente").forward(request,response);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	  private void pageClienteCreate(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            request.getRequestDispatcher("create/clienteCreate.jsp").forward(request,response);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        }
	    }
	  
	  
	  private void pageClientes(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            List<Cliente> clientes = clienteDao.listarCliente();
	            
	            request.setAttribute("clientes", clientes);
	            request.getRequestDispatcher("cliente/cliente.jsp").forward(request,response);
	            
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        }
	    }

	  private void pageClienteUpdate (HttpServletRequest request, HttpServletResponse response) {
	        try {
	        	int id = Integer.parseInt(request.getParameter("id"));
	        	Cliente cliente = clienteDao.buscarClientePorId(id);
	        	Veiculo veiculo = veiculoDao.buscarVeiculoPorId(cliente.getId());
	        	
	        	request.setAttribute("cliente", cliente);
	        	request.setAttribute("veiculo", veiculo);
	        	
	            request.getRequestDispatcher("update/clienteUpdate.jsp").forward(request,response);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        }
	    }
	  
	  private void clienteUpdate(HttpServletRequest request, HttpServletResponse response) {
	        
		  	int idCliente = Integer.parseInt(request.getParameter("idClient"));
		  	int idVeiculo = Integer.parseInt(request.getParameter("idVeiculo"));
		  
		  	Cliente cliente = new Cliente();
	        Veiculo veiculo = new Veiculo();
	        
	        cliente.setNome(request.getParameter("name"));
	        cliente.setCpf(request.getParameter("cpf"));
	        
	        veiculo.setAno(Integer.parseInt(request.getParameter("ano")));
	        veiculo.setMarca(request.getParameter("marca"));
	        veiculo.setModelo(request.getParameter("modelo"));
	        
	        clienteDao.atualizarCliente(idCliente, cliente);;
	        veiculoDao.atualizarVeiculo(idVeiculo, veiculo);
	        
	        try {
	            request.getRequestDispatcher("cliente").forward(request,response);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	  
	  private void clienteDelete(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            int id = Integer.parseInt(request.getParameter("id"));
	            clienteDao.deletarCliente(id);
	            request.getRequestDispatcher("cliente/cliente.jsp").forward(request,response);
	            
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
