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
<link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <customTag:header/>
	<main>
		<div id="perfil">
			<div class="foto"></div>
			 <span><%=funcionario.getNome()%></span>
			 <ul>
			 	<li>CPF: <%=funcionario.getCpf()%></li>
			 	<li>Cargo: <%=funcionario.getCargo()%></li>
			 </ul>
			 
			 <a href="funcionario/update" class="button">Atualizar</a>
            <a href="funcionario/delete" class="button delete-button">Excluir</a>
			
		</div>
	</main>
</body>
</html>
