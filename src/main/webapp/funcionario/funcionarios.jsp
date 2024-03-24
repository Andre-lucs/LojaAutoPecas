<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@page import="br.com.lojaautopecas.model.Funcionario" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>
<% List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
    <title>Funcionários</title>
</head>
<body>
<customTag:header/>
<a href="funcionario/create" class="button">Criar Funcionário</a>
<table>
    <tr>
        <th>ID</th>
        <th>CPF</th>
        <th>Nome</th>
        <th>Cargo</th>
        <th>Opções</th>
    </tr>
    <% for(Funcionario funcionario : funcionarios) { %>
        <tr>
            <td><%= funcionario.getId() %></td>
            <td><%= funcionario.getCpf() %></td>
            <td><%= funcionario.getNome() %></td>
            <td><%= funcionario.getCargo() %></td>
            <td>
                <a href="funcionario/update?id=<%=funcionario.getId() %>" class="button">Atualizar</a>
                <a onclick="confirmAction('deletar este funcionário', 'funcionario/delete?id=<%=funcionario.getId()%>')" class="button delete-button">Excluir</a>
            </td>
        </tr>
    <% } %>
</table>
<script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
