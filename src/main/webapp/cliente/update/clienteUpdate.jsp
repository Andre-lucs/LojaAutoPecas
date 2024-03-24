<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="br.com.lojaautopecas.model.Cliente" %>    
 <%@page import="br.com.lojaautopecas.model.Veiculo" %>  
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<%Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
<%Veiculo veiculo = (Veiculo) request.getAttribute("veiculo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Cliente:</title>
</head>
<body>
	<customTag:header/>
	<form action="create/update" method="">
	
		<h2>Cadastro do Cliente:</h2>
		
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%cliente.getNome();%>">
        
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" value="<%cliente.getCpf();%>" required>
        
        <h2>Cadastro do Veículo:</h2>
        
        <label for="modelo" >Modelo:</label>
        <input type="text" id="modelo" name="modelo" value="<%veiculo.getModelo();%>" required>
        
        <label for="marca" >Marca:</label>
        <input type="text" id="marca" name="marca" value="<%veiculo.getMarca();%>" required>
        
        <label for="ano">Ano:</label>
        <input type="number" id="ano" name="ano"  value="<%veiculo.getAno();%>" required>
        
        <input type="submit" value="Enviar">
    </form>
</body>
</html>