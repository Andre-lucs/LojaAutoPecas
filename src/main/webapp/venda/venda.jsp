<%@ page import="java.util.List" %>
<%@ page import="br.com.lojaautopecas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="customTag" uri="../WEB-INF/CustomTags.tld" %>

<%
    Venda venda = (Venda) request.getAttribute("venda");
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
    List<Servico> servicos = (List<Servico>) request.getAttribute("servicos");
    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");
%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes Venda</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <customTag:header/>
    <div class="default-page">

    <div class="info">
        <div>
            <h2>Informações: </h2>
            <button onclick="confirmAction('deletar esta venda', 'venda/delete?id=<%=venda.getId()%>')" class="delete-button">Excluir</button>
        </div>
        <div>
            <b>ID: <%out.print(venda.getId());%></b>
            <div>
                <h3>Cliente:</h3>
                <b>Nome: <%out.print(cliente.getNome());%></b>
                <b>Nome: <%out.print(cliente.getCpf());%></b>
            </div>
            <div>
                <h3>Funcionário:</h3>
                <b>Nome: <%out.print(funcionario.getNome());%></b>
                <b>CPF: <%out.print(funcionario.getCpf());%></b>
            </div>
            <b>Data: <%out.print(venda.getData());%></b>
            <b>Valor Total: <%out.print(venda.getValor_Total());%></b>
        </div>
    </div>
    <div id="venda-servicos">
        <div>
            <table>
                <div class="table-top">
                    <b>Serviços</b>
                    <a href="venda/servico/add" class="button">Adicionar</a><!--popup?-->
                </div>
                <thead>
                <th>ID</th>
                <th>Descrição</th>
                <th>Preco</th>
                <th></th>
                </thead>
                <tbody>
                <% for(Servico servico : servicos) { %>
                <tr>
                    <td><%=servico.getId()%></td>
                    <td><%=servico.getDescricao()%></td>
                    <td><%=servico.getPreco()%></td>
                    <td>
                        <a class="button" href="venda/servico/delete?sid=<%=servico.getId()%>&vid=<%=venda.getId()%>">Deletar</a>
                    </td>
                </tr>
                <% }%>
                </tbody>
            </table>
        </div>
    </div>
    <div id="venda-pecas">
        <div>
            <table>
                <div class="table-top">
                    <b>Peças</b>
                    <a href="venda/peca/add" class="button">Adicionar</a><!--popup?-->
                </div>
                <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Preco</th>
                <th></th>
                </thead>
                <tbody>
                <% for(Peca peca : pecas) { %>
                <tr>
                    <td><%=peca.getId()%></td>
                    <td><%=peca.getNome()%></td>
                    <td><%=peca.getPreco()%></td>
                    <td>
                        <a class="button" href="venda/peca/delete?pid=<%=peca.getId()%>&vid=<%=venda.getId()%>">Deletar</a>
                    </td>
                </tr>
                <% }%>
                </tbody>
            </table>
        </div>
    </div>

    </div>
<script type="text/javascript" src="resources/scripts/redirect.js"></script>
</body>
</html>
