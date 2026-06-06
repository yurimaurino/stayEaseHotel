<%--
    Document   : atualizarReservas
    Created on : 2 de jun. de 2026, 18:48:09
    Author     : msant
--%>

<%@ page import="com.yuri.stayEase.model.Reserva" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Reserva r = (Reserva) request.getAttribute("reserva");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="atualizarReserva.css">
        <title>Atualizar Reserva</title>
    </head>
    <body>
    <div class="card">

        <h1>Atualizar Reserva</h1>

        <form action="controle_reserva" method="POST">

            <input type="hidden" name="op" value="EFETIVAR ATUALIZACAO">
            <input type="hidden" name="txtId" value="<%= r.getIdReserva()%>">

            <div class="dados">

                <div class="campo">
                    <strong>Email</strong>
                    <input type="email"
                           name="txtEmailCliente"
                           value="<%= r.getEmailCliente()%>">
                </div>

                <div class="campo">
                    <strong>Telefone</strong>
                    <input type="text"
                           name="txtTelefoneCliente"
                           value="<%= r.getTelefoneCliente()%>">
                </div>

                <div class="campo">
                    <strong>Tipo de Quarto</strong>
                    <select name="txtTipoQuarto">
                        <option value="Simples"
                                <%= r.getTipoQuarto().equalsIgnoreCase("simples")
                                        ? "selected" : "" %>>
                            Simples
                        </option>

                        <option value="Luxo"
                                <%= r.getTipoQuarto().equalsIgnoreCase("luxo")
                                        ? "selected" : "" %>>
                            Luxo
                        </option>
                    </select>
                </div>

                <div class="campo">
                    <strong>Check-In</strong>
                    <input type="date"
                           name="txtDataCheckin"
                           value="<%= r.getDataCheckin()%>">
                </div>

                <div class="campo">
                    <strong>Check-Out</strong>
                    <input type="date"
                           name="txtDataCheckout"
                           value="<%= r.getDataCheckout()%>">
                </div>

                <div class="campo">
                    <strong>Hóspedes</strong>
                    <input type="number"
                           name="txtQuantHospede"
                           value="<%= r.getQuant_hospede()%>">
                </div>

                <div class="campo">
                    <strong>Status</strong>
                    <select name="txtStatusReserva">
                        <option value="confirmada"
                                <%= r.getStatusReserva().equalsIgnoreCase("confirmada")
                                        ? "selected" : "" %>>
                            Confirmada
                        </option>

                        <option value="pendente"
                                <%= r.getStatusReserva().equalsIgnoreCase("pendente")
                                        ? "selected" : "" %>>
                            Pendente
                        </option>

                        <option value="cancelada"
                                <%= r.getStatusReserva().equalsIgnoreCase("cancelada")
                                        ? "selected" : "" %>>
                            Cancelada
                        </option>
                    </select>
                </div>

            </div>

            <div class="acoes">
                <a href="index.html" class="btn-voltar">
                    Voltar
                </a>

                <button type="submit" class="btn-salvar">
                    Salvar Alterações
                </button>
            </div>

        </form>

    </div>
    </body>
</html>
