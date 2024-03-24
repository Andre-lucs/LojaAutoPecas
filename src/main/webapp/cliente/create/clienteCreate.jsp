<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Cliente:</title>
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
<customTag:header/>
<form class="form-container" action="/LojaAutoPecas/cliente/create/submit" >
    <h2>Cadastro do Cliente:</h2>
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>
    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" required>
    <h2>Cadastro do Veículo:</h2>
    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo" required>
    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" required>
    <label for="ano">Ano:</label>
    <input type="number" id="ano" name="ano" required>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
