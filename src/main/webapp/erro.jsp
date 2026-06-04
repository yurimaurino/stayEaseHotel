<%-- 
    Document   : erro.jsp
    Created on : 1 de jun. de 2026, 23:26:31
    Author     : msant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
</head>
<body>

    <h1>Ocorreu um erro</h1>

    <h3 style="color:red;">
        <%= request.getAttribute("message") %>
    </h3>

    <a href="index.html">
        Voltar
    </a>

</body>
</html>

