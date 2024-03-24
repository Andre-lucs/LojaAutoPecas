<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
	 <a href="cliente/create">Criar cliente</a>
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
            <td><a href="cliente/update?id=<%=cliente.getId() %>">Atualizar</a> </td>
            <td><a href="cliente/delete?id=<%=cliente.getId() %>">Excluir</a> </td>
        </tr>
    <% } %>
</table>
</body>
</html>