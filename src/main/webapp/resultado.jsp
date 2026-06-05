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
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="card">

    <div class="icone">✅</div>

    <h1>Operação Realizada</h1>

    <p class="mensagem">
        <%= request.getAttribute("message") %>
    </p>

    <a href="index.html" >
        <button class="btn">Voltar ao inicio</button>
    </a>

</div>

</body>
</html>