package com.yuri.stayEase.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private int idReserva;
    private String nomeCliente;
    private String cpfCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String tipoQuarto;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private int quant_hospede;
    private double valorTotal;
    private String statusReserva;

    public int getIdReserva() {
        return idReserva;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public int getQuant_hospede() {
        return quant_hospede;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public void setQuant_hospede(int quant_hospede) {
        this.quant_hospede = quant_hospede;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void calcularValorTotal() {
        long dias = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);

        if (getTipoQuarto().equalsIgnoreCase("simples")) {
            valorTotal = dias * 150;
        } else if (getTipoQuarto().equalsIgnoreCase("luxo")) {
            valorTotal = dias * 300;
        }
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}