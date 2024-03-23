<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22/03/2024
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.lojaautopecas.model.Venda"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    System.out.println(request.getAttribute("vendas"));
    List<Venda> vendas = (ArrayList<Venda>) request.getAttribute("vendas");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
    <header>
        <nav>
            <a href="">Vendas</a>
            <a href="">Clientes</a>
            <a href=""><img src="./resources/images/user.png" alt="user"></a>
            <button>Sair</button>
        </nav>
    </header>
    <div>
        <table>
            <thead>
            <th>
                <h1>Tabela de Vendas</h1>
            </th>
            <th>
                <button>Adicionar</button>
            </th>
            </thead>
            <tbody>
            <% for (Venda venda : vendas) {%>
                <tr>
                    <td><%out.print("venda.getId()etc");%></td>
                </tr>
            <% }%>
            </tbody>
        </table>

    </div>
</body>
</html>
