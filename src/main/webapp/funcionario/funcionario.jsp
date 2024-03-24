<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="br.com.lojaautopecas.model.Funcionario" %>    
<%Funcionario funcionario = (Funcionario) request.getAttribute("funcionario"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
</head>
<body>
	<main>
		<div>
			<div class="foto"></div>
			 <span><%funcionario.getNome();%></span>
			 <ul>
			 	<li>CPF: <%funcionario.getCpf();%></li>
			 	<li>Cargo: <%funcionario.getCargo();%></li>
			 </ul>
		</div>
	</main>
</body>
</html>