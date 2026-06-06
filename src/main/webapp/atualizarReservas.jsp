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
        <h1>Atualizar Reserva</h1>
        
        <form action="controle_reserva" method="POST">
            <input type="hidden" name="op" value="EFETIVAR ATUALIZACAO">
            <input type="hidden" name="txtId" value="<%= r.getIdReserva()%>">
            
            Email:
            <input type="text" name="txtEmailCliente" value="<%= r.getEmailCliente()%>">
            <br><br> 
            
            Telefone:
            <input type="text" name="txtTelefoneCliente" value="<%= r.getTelefoneCliente()%>">
            <br><br>
            
            Tipo de Quarto:

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

<br><br>
            <br><br>       
            Check-in:
            <input type="date" name="txtDataCheckin" value="<%= r.getDataCheckin()%>">
            <br><br>
            
            Check-out:
            <input type="date" name="txtDataCheckout" value="<%= r.getDataCheckout() %>">
            <br><br>
            
            Hóspedes:
            <input type="number" name="txtQuantHospede" value="<%= r.getQuant_hospede() %>">
            <br><br>

            Status Reserva:
            <select name="txtStatusReserva">
                <option value="Confirmada"
                        <%= r.getStatusReserva().equalsIgnoreCase("confirmada")
                                ? "selected" : "" %>>
                    Confirmada
                </option>

                <option value="Pendente"
                        <%= r.getStatusReserva().equalsIgnoreCase("pendente")
                                ? "selected" : "" %>>
                    Pendente
                </option>

                <option value="Cancelada"
                        <%= r.getStatusReserva().equalsIgnoreCase("cancelada")
                                ? "selected" : "" %>>
                    Cancelada
                </option>
            </select>

            <button type="submit"> Salvar Alterações </button>
        </form>
    </body>
</html>
