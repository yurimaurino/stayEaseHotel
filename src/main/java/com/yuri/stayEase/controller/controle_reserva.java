package com.yuri.stayEase.controller;

import com.yuri.stayEase.dao.ReservaDAO;
import com.yuri.stayEase.model.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "controle_reserva",
        urlPatterns = {"/controle_reserva"})
public class controle_reserva extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String op = request.getParameter("op");

            ReservaDAO rdao = new ReservaDAO();

            Reserva r = new Reserva();

            if (op.equals("CADASTRAR")) {

                r.setNomeCliente(
                        request.getParameter("txtNomeCliente"));

                r.setCpfCliente(
                        request.getParameter("txtCpfCliente"));

                r.setEmailCliente(
                        request.getParameter("txtEmailCliente"));

                r.setTelefoneCliente(
                        request.getParameter("txtTelefoneCliente"));

                r.setTipoQuarto(
                        request.getParameter("txtTipoQuarto"));

                r.setDataCheckin(
                        LocalDate.parse(
                                request.getParameter("txtDataCheckin")));

                r.setDataCheckout(
                        LocalDate.parse(
                                request.getParameter("txtDataCheckout")));

                r.setQuant_hospede(
                        Integer.parseInt(
                                request.getParameter("txtQuantHospede")));

                r.setStatusReserva(
                        request.getParameter("txtStatusReserva"));

                r.calcularValorTotal();

                try {

                    rdao.inserir(r);

                    request.setAttribute(
                            "message",
                            "Reserva cadastrada com sucesso!");

                    request.getRequestDispatcher(
                                    "resultado.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }

            else if (op.equals("CONSULTAR TODOS")) {

                try {

                    List<Reserva> lista =
                            rdao.consultarTodos();

                    request.setAttribute(
                            "listaReservas",
                            lista);

                    request.getRequestDispatcher(
                                    "consultarReservas.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }

            else if (op.equals("CONSULTAR BY ID")) {

                try {

                    r.setIdReserva(
                            Integer.parseInt(
                                    request.getParameter("txtId")));

                    Reserva reserva =
                            rdao.consultarById(r);

                    request.setAttribute(
                            "reserva",
                            reserva);

                    request.getRequestDispatcher(
                                    "consultarReservaID.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }

            else if (op.equals("DELETAR")) {

                try {

                    r.setIdReserva(
                            Integer.parseInt(
                                    request.getParameter("txtId")));

                    rdao.deletar(r);

                    List<Reserva> lista =
                            rdao.consultarTodos();

                    request.setAttribute(
                            "listaReservas",
                            lista);

                    request.getRequestDispatcher(
                                    "consultarReservas.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }

            else if (op.equals("ATUALIZAR")) {

                try {

                    r.setIdReserva(
                            Integer.parseInt(
                                    request.getParameter("txtId")));

                    Reserva reserva =
                            rdao.consultarById(r);

                    request.setAttribute(
                            "reserva",
                            reserva);

                    request.getRequestDispatcher(
                                    "atualizarReservas.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }

            else if (op.equals("EFETIVAR ATUALIZACAO")) {

                try {

                    r.setIdReserva(
                            Integer.parseInt(
                                    request.getParameter("txtId")));

                    r.setEmailCliente(
                            request.getParameter(
                                    "txtEmailCliente"));

                    r.setTelefoneCliente(
                            request.getParameter(
                                    "txtTelefoneCliente"));

                    r.setTipoQuarto(
                            request.getParameter(
                                    "txtTipoQuarto"));

                    r.setDataCheckin(
                            LocalDate.parse(
                                    request.getParameter(
                                            "txtDataCheckin")));

                    r.setDataCheckout(
                            LocalDate.parse(
                                    request.getParameter(
                                            "txtDataCheckout")));

                    r.setQuant_hospede(
                            Integer.parseInt(
                                    request.getParameter(
                                            "txtQuantHospede")));

                    r.calcularValorTotal();

                    rdao.atualizar(r);

                    request.setAttribute(
                            "message",
                            "Reserva atualizada com sucesso!");

                    request.getRequestDispatcher(
                                    "resultado.jsp")
                            .forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {

                    request.setAttribute(
                            "message",
                            ex.getMessage());

                    request.getRequestDispatcher(
                                    "erro.jsp")
                            .forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controle de Reservas";
    }
}
