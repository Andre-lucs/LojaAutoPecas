<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

 <%@page import="br.com.lojaautopecas.model.Cliente" %>
 <%@page import="br.com.lojaautopecas.model.Veiculo" %>
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<%Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
<%Veiculo veiculo = (Veiculo) request.getAttribute("veiculo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Atualização Cliente:</title>
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
	<customTag:header/>
	<form class="form-container" action="/LojaAutoPecas/cliente/update/submit">

		<h2>Atualização do Cliente:</h2>

		<input type="text" name="idCliente" readonly
        					value="<%out.print(cliente.getId());%>">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%out.print(cliente.getNome());%>">

        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="<%out.print(cliente.getCpf());%>" required>

        <h2>Atualização do Veículo:</h2>

        <input type="text" name="idVeiculo" readonly value="<%out.print(veiculo.getId());%>">

        <label for="modelo" >Modelo:</label>
        <input type="text" id="modelo" name="modelo" value="<%out.print(veiculo.getModelo());%>" required>

        <label for="marca" >Marca:</label>
        <input type="text" id="marca" name="marca" value="<%out.print(veiculo.getMarca());%>" required>

        <label for="ano">Ano:</label>
        <input type="number" id="ano" name="ano"  value="<%out.print(veiculo.getAno());%>" required>

        <input type="submit" class="button" value="Atualizar">
    </form>
</body>
</html>