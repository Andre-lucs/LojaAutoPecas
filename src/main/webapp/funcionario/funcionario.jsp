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
			 
			  <a class="button" href="funcionario/update?id=<%=funcionario.getId()%>">Atualizar</a>
            <a onclick="confirmAction('exclusão de sua conta no sistema permanentemente', 'funcionario/delete?deleteSelf=true&id=<%=funcionario.getId()%>')" class="button delete-button">Excluir</a>
			
		</div>
	</main>
	<script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
