<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22/03/2024
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<%
    List<String> clients = new ArrayList<>();
    clients.add("<NAME>");
    clients.add("<NAME1>");
    clients.add("<NAME2>");
    List<String> services = new ArrayList<>();
    services.add("<NAME>");
    services.add("<NAME1>");
    services.add("<NAME2>");
    List<String> pecas = new ArrayList<>();
    pecas.add("<NAME>");
    pecas.add("<NAME1>");
    pecas.add("<NAME2>");


    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
    df.setTimeZone(tz);
    String todayIso = df.format(new Date()).substring(0,10);

%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Venda</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
<customTag:header/>
<form name="formVenda" action="submit" >
    <h3>Cliente: </h3>
    <select title="selectClient" name="selectClient" required>
        <% for (int i = 0; i < clients.size(); i++) {%>
            <option value="<%=String.valueOf(i)%>"><%=clients.get(i)%></option>
       <% }%>
    </select>
    <a onclick="">Cadastrar Novo Cliente</a>
    Data da venda: <input type="date" name="data" required value="<%=todayIso%>"}></input>

    <h3>Tipo do serviço:</h3>
    <select title="selectService" name="selectService" required>
        <% for (int i = 0; i < services.size(); i++) {%>
        <option value="<%=String.valueOf(i)%>"><%=services.get(i)%></option>
        <% }%>
    </select>

    <h3>Escolher Peça: </h3>
    <select title="selectPeca" name="selectPeca" required>
        <% for (int i = 0; i < pecas.size(); i++) {%>
            <option value="<%=String.valueOf(i)%>"><%=pecas.get(i)%></option>
       <% }%>
    </select>

    <!-- id vem do cookie login XXX<input type="text" name="funcionarioId" value="" readonly> -->
    <input type="submit" value="Cadastar">
</form>
</body>
</html>
