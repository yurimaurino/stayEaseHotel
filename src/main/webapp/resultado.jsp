<%--
  Created by IntelliJ IDEA.
  User: yuri
  Date: 04/06/26
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado</title>
</head>
<body>

<h1>Operação Realizada</h1>

<h3>
    <%= request.getAttribute("message") %>
</h3>

<a href="index.html">
    Voltar
</a>

</body>
</html>