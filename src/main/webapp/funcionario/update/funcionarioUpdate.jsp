<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>

<%@page import="br.com.lojaautopecas.model.Funcionario" %>
<%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<%Funcionario funcionario = (Funcionario) request.getAttribute("funcionario"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Funcionário:</title>
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
    <customTag:header/>
    <form class="form-container" action="/LojaAutoPecas/funcionario/update/submit">
        <h2 class="form-title">Atualizar Funcionário:</h2>

		<input type="text" name="idFuncionario" readonly
        					value="<%out.print(funcionario.getId());%>">

        <label class="form-label" for="cpf">CPF:</label>
        <input class="form-input" type="text" id="cpf" name="cpf"  value="<%out.print(funcionario.getCpf());%>" required>

        <label class="form-label" for="nome">Nome:</label>
        <input class="form-input" type="text" id="nome" name="nome" value="<%out.print(funcionario.getNome());%>" required><br>

        <label class="form-label" for="cargo">Cargo:</label>
        <input class="form-input" type="text" id="cargo" name="cargo"  value="<%out.print(funcionario.getCargo());%>" required>

        <label class="form-label" for="senha">Senha:</label>
        <input class="form-input" type="password" id="senha"  value="<%out.print(funcionario.getSenha());%>" name="senha" required>

        <input class="form-button" type="submit" value="Enviar">
    </form>
</body>
</html>
