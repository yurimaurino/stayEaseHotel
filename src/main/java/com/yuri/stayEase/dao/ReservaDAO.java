package com.yuri.stayEase.dao;

import com.yuri.stayEase.connection.conexaoBD;
import com.yuri.stayEase.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
        public void inserir(Reserva reserva) throws ClassNotFoundException, SQLException{
            Connection con = conexaoBD.getConexao();
            PreparedStatement comando = con.prepareStatement("insert into reserva (nome_cliente, cpf_cliente, email_cliente, telefone_cliente, tipo_quarto, data_checkin, data_checkout, quant_hospede, valor_total, status_reserva) values (?, ?, ?,?, ?, ?, ?,?, ?, ?)");
            comando.setString(1, reserva.getNomeCliente());
            comando.setString(2, reserva.getCpfCliente());
            comando.setString(3, reserva.getEmailCliente());
            comando.setString(4, reserva.getTelefoneCliente());
            comando.setString(5, reserva.getTipoQuarto());
            comando.setDate(6,java.sql.Date.valueOf(reserva.getDataCheckin()));
            comando.setDate(7,java.sql.Date.valueOf(reserva.getDataCheckout()));
            comando.setInt(8, reserva.getQuant_hospede());
            comando.setDouble(9, reserva.getValorTotal());
            comando.setString(10, reserva.getStatusReserva());
            comando.execute();
            con.close();
        }

        public void deletar(Reserva reserva) throws ClassNotFoundException, SQLException{
            Connection con = conexaoBD.getConexao();
            PreparedStatement comando = con.prepareStatement("delete from reserva where id_reserva = ?");
            comando.setInt(1,reserva.getIdReserva());
            comando.execute();
            con.close();
        }

        public void atualizar(Reserva reserva) throws ClassNotFoundException, SQLException{
            Connection con = conexaoBD.getConexao();
            PreparedStatement comando = con.prepareStatement("update reserva set email_cliente = ?,telefone_cliente = ?, tipo_quarto = ?, data_checkin = ?, data_checkout = ?, quant_hospede = ?, valor_total = ?, status_reserva = ? where id_reserva = ?");
            comando.setString(1, reserva.getEmailCliente());
            comando.setString(2, reserva.getTelefoneCliente());
            comando.setString(3, reserva.getTipoQuarto());
            comando.setDate(4, java.sql.Date.valueOf(reserva.getDataCheckin()));
            comando.setDate(5, java.sql.Date.valueOf(reserva.getDataCheckout()));
            comando.setInt(6, reserva.getQuant_hospede());
            comando.setDouble(7, reserva.getValorTotal());
            comando.setString(8, reserva.getStatusReserva());
            comando.setInt(9, reserva.getIdReserva());
            comando.execute();
            con.close();
        }

        public Reserva consultarById(Reserva r) throws ClassNotFoundException, SQLException {
            Connection con = conexaoBD.getConexao();
            PreparedStatement comando = con.prepareStatement("select * from reserva where id_reserva = ?");
            comando.setInt(1, r.getIdReserva());
            ResultSet rs = comando.executeQuery();
            Reserva resv = new Reserva();
            if (rs.next()){
                resv.setIdReserva(rs.getInt("id_reserva"));
                resv.setNomeCliente(rs.getString("nome_cliente"));
                resv.setCpfCliente(rs.getString("cpf_cliente"));
                resv.setEmailCliente(rs.getString("email_cliente"));
                resv.setTelefoneCliente(rs.getString("telefone_cliente"));
                resv.setTipoQuarto(rs.getString("tipo_quarto"));
                resv.setDataCheckin(rs.getDate("data_checkin").toLocalDate());
                resv.setDataCheckout(rs.getDate("data_checkout").toLocalDate());
                resv.setQuant_hospede(rs.getInt("quant_hospede"));
                resv.setValorTotal(rs.getDouble("valor_total"));
                resv.setStatusReserva(rs.getString("status_reserva"));
            }
            return resv;
        }

        public List<Reserva> consultarTodos() throws ClassNotFoundException, SQLException{
            Connection con = conexaoBD.getConexao();
            PreparedStatement comando = con.prepareStatement("select * from reserva");
            ResultSet rs = comando.executeQuery();

            List<Reserva> lresv = new ArrayList<Reserva>();
            while(rs.next()){
                Reserva resv = new Reserva();
                resv.setIdReserva(rs.getInt("id_reserva"));
                resv.setNomeCliente(rs.getString("nome_cliente"));
                resv.setCpfCliente(rs.getString("cpf_cliente"));
                resv.setEmailCliente(rs.getString("email_cliente"));
                resv.setTelefoneCliente(rs.getString("telefone_cliente"));
                resv.setTipoQuarto(rs.getString("tipo_quarto"));
                resv.setDataCheckin(rs.getDate("data_checkin").toLocalDate());
                resv.setDataCheckout(rs.getDate("data_checkout").toLocalDate());
                resv.setQuant_hospede(rs.getInt("quant_hospede"));
                resv.setValorTotal(rs.getDouble("valor_total"));
                resv.setStatusReserva(rs.getString("status_reserva"));

                lresv.add(resv);
            }
            return lresv;
        }

    }
