<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Cliente:</title>
</head>
<body>
	<form action="submit" >
	
		<h2>Cadastro do Cliente:</h2>
		
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required><br><br>
        
        <h2>Cadastro do Veículo:</h2>
        
        <label for="modelo">Modelo:</label>
        <input type="text" id="modelo" name="modelo" required><br><br>
        
        <label for="marca">Marca:</label>
        <input type="text" id="marca" name="marca" required><br><br>
        
        <label for="ano">Ano:</label>
        <input type="number" id="ano" name="ano" required><br><br>
        
        <input type="submit" value="Enviar">
    </form>
</body>
</html>