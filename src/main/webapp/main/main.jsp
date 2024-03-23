<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22/03/2024
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>
<%@ page import="br.com.lojaautopecas.model.Venda"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    System.out.println(request.getAttribute("vendas"));
    List<Venda> vendas = (ArrayList<Venda>) request.getAttribute("vendas");
%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Vendas</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <!--<header>
        <nav>
            <a href="main">Vendas</a>
            <a href="">Clientes</a>
            <a href=""><img src="./resources/images/user.png" alt="user"></a>
            <button>Sair</button>
        </nav>
    </header>-->
    <customTag:header></customTag:header>
    <div>
        <table>
            <thead>
            <th>
                <b>Tabela de Vendas</b>
                <a href="venda/create" class="button">Adicionar</a>
            </th>
            </thead>
            <tbody>
            <% for (Venda venda : vendas) {%>
                <tr>
                    <td><a href="venda?id=<%="venda.getId()"%>"> <%out.print("venda.getId()etc");%> </a></td>
                </tr>
            <% }%>
            </tbody>
        </table>

    </div>
</body>
</html>
