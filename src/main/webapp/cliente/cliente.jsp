<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@page import="br.com.lojaautopecas.model.Cliente" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>
<%List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
<title>Clientes</title>
</head>
<body>
	 <customTag:header/>
	 <a href="cliente/create" class="button">Criar Cliente</a>
	<table>
    <tr>
        <th>ID</th>
        <th>CPF</th>
        <th>Nome</th>
        <th>Opções</th>
    </tr>
    <% for(Cliente cliente : clientes) { %>
        <tr>
            <td><%= cliente.getId() %></td>
            <td><%= cliente.getCpf() %></td>
            <td><%= cliente.getNome() %></td>
            <td class="flexhor flexend">
                <a href="cliente/update?id=<%=cliente.getId() %>" class="button">Atualizar</a>
                <a onclick="confirmAction('deletar este cliente', 'cliente/delete?id=<%=cliente.getId()%>')" class="button delete-button">Excluir</a>
            </td>
        </tr>
    <% } %>
</table>
 <script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
