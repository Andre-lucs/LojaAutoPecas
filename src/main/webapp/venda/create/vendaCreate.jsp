<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="br.com.lojaautopecas.model.Cliente" %>
<%@ page import="br.com.lojaautopecas.model.Servico" %>
<%@ page import="br.com.lojaautopecas.model.Peca" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<%
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
    List<Servico> servicos =  (List<Servico>) request.getAttribute("servicos");
    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");


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
        <% for (Cliente cliente : clientes) {%>
            <option value="<%=cliente.getId()%>"><%=cliente.getNome()+" - "+cliente.getCpf()%></option>
       <% }%>
    </select>
    <a onclick="">Cadastrar Novo Cliente</a>
    Data da venda: <input type="date" name="data" required value="<%=todayIso%>"}></input>

    <h3>Tipo do serviço:</h3>
    <select title="selectService" name="selectService" required>
        <% for (Servico servico : servicos) {%>
        <option value="<%=servico.getId()%>"><%=servico.getDescricao()%></option>
        <% }%>
    </select>

    <h3>Escolher Peça: </h3>
    <select title="selectPeca" name="selectPeca" required>
        <% for (Peca peca : pecas) {%>
            <option value="<%=peca.getId()%>"><%=peca.getNome()%></option>
       <% }%>
    </select>

    <!-- id vem do cookie login XXX<input type="text" name="funcionarioId" value="" readonly> -->
    <input type="submit" value="Cadastar">
</form>
</body>
</html>
