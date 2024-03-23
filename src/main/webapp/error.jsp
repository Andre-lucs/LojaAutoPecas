<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23/03/2024
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = request.getParameter("error");
    if (error!= null) {
        response.setStatus(404);
    }
%>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p>An error occurred:
    <% if (error != null) {
        switch (error){
            case "InvalidPath":
                out.print("Caminho invalido");
                break;
            default:
                out.print("Error: " + error);
        }
    %>
    <%out.print(error);%>
    <% } %>
    </p>
</body>
</html>
