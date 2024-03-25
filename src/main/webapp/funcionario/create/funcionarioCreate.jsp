<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="customTag" uri="../../WEB-INF/CustomTags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Funcionário</title>
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
    <customTag:header/>

    <form class="form-container" action="/LojaAutoPecas/funcionario/create/submit" >

        <h2>Cadastro de Funcionário</h2
        <label class="form-label" for="cpf">CPF:</label>
        <input class="form-input" type="text" id="cpf" name="cpf" required>

        <label class="form-label" for="nome">Nome:</label>
        <input class="form-input" type="text" id="nome" name="nome" required>

        <label class="form-label" for="cargo">Cargo:</label>
        <input class="form-input" type="text" id="cargo" name="cargo" required>

        <label class="form-label" for="senha">Senha:</label>
        <input class="form-input" type="password" id="senha" name="senha" required>

        <input class="form-button button" type="submit" value="Cadastrar">
    </form>
</body>
</html>
