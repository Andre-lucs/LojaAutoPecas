<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@page import="br.com.lojaautopecas.model.Funcionario" %>
<%Funcionario funcionario = (Funcionario) request.getAttribute("funcionario"); %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Perfil</title>
</head>
<body>
    <customTag:header/>
	<main>
		<div>
			<div class="foto"></div>
			 <span><%=funcionario.getNome()%></span>
			 <ul>
			 	<li>CPF: <%=funcionario.getCpf()%></li>
			 	<li>Cargo: <%=funcionario.getCargo()%></li>
			 </ul>
			 <a href="funcionario/update">Atualizar</a>
			 <a href="funcionario/delete">Excluir</a>
		</div>
	</main>
</body>
</html>