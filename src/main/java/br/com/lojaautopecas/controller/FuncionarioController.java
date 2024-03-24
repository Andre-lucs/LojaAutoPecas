package br.com.lojaautopecas.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.com.lojaautopecas.model.Cliente;
import br.com.lojaautopecas.model.Funcionario;
import br.com.lojaautopecas.model.Veiculo;
import br.com.lojaautopecas.utils.ManageCookies;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaautopecas.dao.FuncionarioDao;


@WebServlet(urlPatterns = {"/funcionario", "/funcionario/create", "/funcionario/create/submit", "/funcionario/update", "/funcionario/update/submit", "/funcionario/delete"})
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FuncionarioDao funcionarioDao = new FuncionarioDao();
   
    public FuncionarioController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if(action.equals("/funcionario")){
			pageFuncionario(request, response);
		}else if(action.equals("/funcionario/create")){
			pageFuncionarioCreate(request, response);
		} else if (action.equals("/funcionario/create/submit")) {
			try {
				funcionarioCreate(request, response);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else if(action.equals("/funcionario/update")) {
			pageFuncionarioUpdate(request, response);
		} else if (action.equals("/funcionario/update/submit")) {
			funcionarioUpdate(request, response);
		} else if (action.equals("/funcionario/delete")) {
			funcionarioDelete(request, response);
		}
	}

	private void pageFuncionarioCreate(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("create/funcionarioCreate.jsp").forward(request,response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	private void funcionarioCreate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome(request.getParameter("nome"));
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setSenha(request.getParameter("senha"));

		funcionarioDao.inserirFuncionario(funcionario);
		String context = getServletContext().getContextPath();

		try {
			response.sendRedirect(context+"/funcionario");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	private void pageFuncionario(HttpServletRequest request, HttpServletResponse response) {
		try {
			//int id = Integer.parseInt(ManageCookies.getLoginCookie(request));
			Funcionario funcionario = funcionarioDao.buscarFuncionarioPorId(1);
			request.setAttribute("funcionario", funcionario);

			request.getRequestDispatcher("funcionario/funcionario.jsp").forward(request,response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}


	private void pageFuncionarioUpdate (HttpServletRequest request, HttpServletResponse response) {
		try {

			int id = 1;
			Funcionario funcionario = funcionarioDao.buscarFuncionarioPorId(id);
			request.setAttribute("funcionario", funcionario);

			request.getRequestDispatcher("update/funcionarioUpdate.jsp").forward(request,response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	private void funcionarioUpdate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entrei no funcionarioUpdate");
		//int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
		int idFuncionario = 1;

		Funcionario funcionario = new Funcionario();

		funcionario.setNome(request.getParameter("nome"));
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setSenha(request.getParameter("senha"));

		funcionarioDao.atualizarFuncionario(idFuncionario, funcionario);

		String context = getServletContext().getContextPath();

		try {
			response.sendRedirect(context+"/funcionario");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void funcionarioDelete(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			funcionarioDao.deletarFuncionario(id);
			request.getRequestDispatcher("/").forward(request,response);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

}
