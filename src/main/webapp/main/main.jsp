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
    <customTag:header/>
    <div>
        <!-- se der tempo https://www.w3schools.com/howto/howto_js_sort_table.asp -->
        <table>
            <div id="table-top">
                <b>Tabela de Vendas</b>
                <a href="venda/create" class="button">Adicionar</a>
            </div>
            <thead>
                <th>ID</th>
                <th>ID Funcionário</th>
                <th>ID Cliente</th>
                <th>Data</th>
                <th>Valor Total</th>
            </thead>
            <tbody>
            <% for (Venda venda : vendas) {%>
                <tr class="clickable" onclick="toVenda(<%=venda.getId()%>)" >
                        <td><%=(venda.getId())%></td>
                        <td><%=(venda.getId_Funcionario())%></td>
                        <td><%=(venda.getId_Cliente())%></td>
                        <td><%=venda.getData()%></td>
                        <td><%=venda.getValor_Total()%></td>
                </tr>
            <% }%>
            </tbody>
        </table>

    </div>
<script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
