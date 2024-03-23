<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22/03/2024
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> clients = new ArrayList<>();
    clients.add("<NAME>");
    clients.add("<NAME1>");
    clients.add("<NAME2>");
    request.setAttribute("clients", clients);
%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Venda</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/styles.css"/>
</head>
<body>
<form name="formVenda" action="submit" >
    <h3>Cliente: </h3>
    <select title="selectClient" name="selectClient" required>
        <% for (int i = 0; i < clients.size(); i++) {%>
            <option value="<%=String.valueOf(i)%>"><%=clients.get(i)%></option>
       <% }%>
    </select>
    <input type="text" name="funcionarioId" value="" readonly>
    <a onclick="">Cadastrar Novo Cliente</a>
    <input type="submit" value="Cadastar">
</form>
</body>
</html>
