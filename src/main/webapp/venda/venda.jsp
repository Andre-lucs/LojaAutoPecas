<%@ page import="br.com.lojaautopecas.model.Venda" %>
<%@ page import="br.com.lojaautopecas.model.Cliente" %>
<%@ page import="br.com.lojaautopecas.model.Funcionario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Venda venda = (Venda) request.getAttribute("venda");
    Cliente cliente = (Cliente) request.getAttribute("cliente");
    Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes Venda</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <div id="venda-options">
        <button>Excluir</button>
        <button>Editar</button>
    </div>
    <div id="venda-info">
        <h2>Informações:</h2>
        <div>
            <span>ID: <%out.print(venda.getId());%></span>
            <div>
                <h3>Cliente:</h3>
                <span>Nome: <%out.print(cliente.getNome());%></span>
                <span>Nome: <%out.print(cliente.getCpf());%></span>
            </div>
            <div>
                <h3>Funcionário:</h3>
                <span>Nome: <%out.print(funcionario.getNome());%></span>
                <span>CPF: <%out.print(funcionario.getCpf());%></span>
            </div>
            <span>Data: <%out.print(venda.getData());%></span>
            <span>Valor Total: <%out.print(venda.getValor_Total());%></span>
        </div>
    </div>
    <div id="venda-servicos">
        <h2>Serviços:</h2>
        <div>
            Lista dos serviços...
        </div>
    </div>
    <div id="venda-pecas">
        <h2>Peças:</h2>
        <div>
            Lista das peças...
        </div>
    </div>

</body>
</html>
