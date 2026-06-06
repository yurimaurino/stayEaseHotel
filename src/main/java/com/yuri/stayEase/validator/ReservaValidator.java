package com.yuri.stayEase.validator;

import com.yuri.stayEase.model.Reserva;

import java.time.LocalDate;

public class ReservaValidator {

    public static void validar(Reserva reserva) {

        validarNome(reserva.getNomeCliente());
        validarCpf(reserva.getCpfCliente());
        validarEmail(reserva.getEmailCliente());
        validarTelefone(reserva.getTelefoneCliente());
        validarDatas(
                reserva.getDataCheckin(),
                reserva.getDataCheckout()
        );
        validarHospedes(reserva.getQuant_hospede());
    }

    private static void validarNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome do cliente é obrigatório."
            );
        }

        if (!nome.matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException(
                    "O nome deve conter apenas letras."
            );
        }
    }

    private static void validarCpf(String cpf) {

        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O CPF é obrigatório."
            );
        }

        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException(
                    "O CPF deve conter exatamente 11 números."
            );
        }
    }

    private static void validarEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O e-mail é obrigatório."
            );
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException(
                    "E-mail inválido."
            );
        }
    }

    private static void validarTelefone(String telefone) {

        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O telefone é obrigatório."
            );
        }

        if (!telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException(
                    "O telefone deve conter 10 ou 11 números."
            );
        }
    }

    private static void validarDatas(
            LocalDate checkin,
            LocalDate checkout) {

        if (checkin == null) {
            throw new IllegalArgumentException(
                    "A data de check-in é obrigatória."
            );
        }

        if (checkout == null) {
            throw new IllegalArgumentException(
                    "A data de check-out é obrigatória."
            );
        }

        if (checkin.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "O check-in não pode ser anterior à data atual."
            );
        }

        if (!checkout.isAfter(checkin)) {
            throw new IllegalArgumentException(
                    "O check-out deve ser posterior ao check-in."
            );
        }
    }

    private static void validarHospedes(int quantidade) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade de hóspedes deve ser maior que zero."
            );
        }
    }
}
