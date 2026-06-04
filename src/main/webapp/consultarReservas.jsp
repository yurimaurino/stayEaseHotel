<%-- 
    Document   : consultarReservas.jsp
    Created on : 1 de jun. de 2026, 23:27:19
    Author     : msant
--%>


<%@page import="java.util.List"%>
<%@page import="com.yuri.stayEase.model.Reserva "%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Reserva> lista =
            (List<Reserva>) request.getAttribute("listaReservas");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="consultarReservas.css">
    <title>Lista de Reservas</title>


</head>
<body>

<h1>Reservas Cadastradas</h1>

<table>

    <tr>
        <th>ID</th>
        <th>Cliente</th>
        <th>Quarto</th>
        <th>Check-in</th>
        <th>Check-out</th>
        <th>Valor</th>
        <th>Status</th>
    </tr>

    <%
        for(Reserva r : lista){
    %>

    <tr>
        <td><%= r.getIdReserva() %></td>
        <td><%= r.getNomeCliente() %></td>
        <td><%= r.getTipoQuarto() %></td>
        <td><%= r.getDataCheckin() %></td>
        <td><%= r.getDataCheckout() %></td>
        <td>R$ <%= r.getValorTotal() %></td>
        <td><%= r.getStatusReserva() %></td>
    </tr>

    <%
        }
    %>

</table>

<br>

<a href="index.html">
    Voltar
</a>

</body>
</html>

