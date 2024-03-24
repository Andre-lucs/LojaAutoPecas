<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Funcionário</title>
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css"/>
</head>
<body>
    <h1 class="form-title">Cadastro de Funcionário</h1>
    <form class="form-container" action="/LojaAutoPecas/funcionario/create/submit" >
        <label class="form-label" for="cpf">CPF:</label>
        <input class="form-input" type="text" id="cpf" name="cpf" required>

        <label class="form-label" for="nome">Nome:</label>
        <input class="form-input" type="text" id="nome" name="nome" required>

        <label class="form-label" for="cargo">Cargo:</label>
        <input class="form-input" type="text" id="cargo" name="cargo" required>

        <label class="form-label" for="senha">Senha:</label>
        <input class="form-input" type="password" id="senha" name="senha" required>

        <input class="form-button" type="submit" value="Cadastrar">
    </form>
</body>
</html>
