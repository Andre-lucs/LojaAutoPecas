<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22/03/2024
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
</head>
<body>
    <form name="formLogin" action="login/submit">
        <input type="text" name="username" placeholder="Usuario" required/>
        <input type="text" name="password" placeholder="Senha" required/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
