package com.yuri.stayEase.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/stayBD"; //Verificar em seu computador
        String USERNAME = "root"; //Verificar em seu computador
        String PASSWORD = ""; //Verificar em seu computador

        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName(DRIVER);
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
