<%@ page import="com.yuri.stayEase.model.Reserva" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Reserva r = (Reserva) request.getAttribute("reserva");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="consultarReservaID.css">
    <title>Consulta de Reserva</title>

</head>

<body>

<div class="card">

    <h1>Detalhes da Reserva</h1>

    <% if(r != null){ %>

    <div class="dados">

        <div class="campo">
            <strong>ID</strong>
            <span class="valor"><%= r.getIdReserva() %></span>
        </div>

        <div class="campo">
            <strong>Cliente</strong>
            <span class="valor"><%= r.getNomeCliente() %></span>
        </div>

        <div class="campo">
            <strong>CPF</strong>
            <span class="valor"><%= r.getCpfCliente() %></span>
        </div>

        <div class="campo">
            <strong>E-mail</strong>
            <span class="valor"><%= r.getEmailCliente() %></span>
        </div>

        <div class="campo">
            <strong>Telefone</strong>
            <span class="valor"><%= r.getTelefoneCliente() %></span>
        </div>

        <div class="campo">
            <strong>Tipo de Quarto</strong>
            <span class="valor"><%= r.getTipoQuarto() %></span>
        </div>

        <div class="campo">
            <strong>Check-in</strong>
            <span class="valor"><%= r.getDataCheckin() %></span>
        </div>

        <div class="campo">
            <strong>Check-out</strong>
            <span class="valor"><%= r.getDataCheckout() %></span>
        </div>

        <div class="campo">
            <strong>Quantidade de Hóspedes</strong>
            <span class="valor"><%= r.getQuant_hospede() %></span>
        </div>

        <div class="campo">
            <strong>Valor Total</strong>
            <span class="valor">
                R$ <%= String.format("%.2f", r.getValorTotal()) %>
            </span>
        </div>

        <div class="campo">
            <strong>Status</strong>
            <span class="valor"><%= r.getStatusReserva() %></span>
        </div>

    </div>

    <% } else { %>

        <h3 style="text-align:center;color:red;">
            Reserva não encontrada.
        </h3>

    <% } %>

    <div class="acoes">

        <a href="index.html" class="btn">
            Voltar
        </a>

    </div>

</div>

</body>
</html>