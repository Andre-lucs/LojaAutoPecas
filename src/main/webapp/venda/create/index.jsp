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
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="formVenda" action="submit" >
    <h3>Cliente: </h3>
    <select title="selectClient" name="selectClient" required>
        <% for (int i = 0; i < clients.size(); i++) {%>
            <option value="<%=String.valueOf(i)%>"><%=i%></option>
       <% }%>
    </select>
    <a onclick="">Cadastrar Novo Cliente</a>
    <h3>Escolher Veiculo: </h3>
    <select title="selectVehicle" name="selectVehicle">
        <% for (int i = 0; i < clients.size(); i++) {%>
            <option value="<%=String.valueOf(i)%>"> <%=i%></option>
       <% }%>
    </select>
    <input type="submit" value="Cadastar">
</form>
</body>
</html>
