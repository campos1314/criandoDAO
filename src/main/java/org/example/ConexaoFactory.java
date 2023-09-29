package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    String url = "jdbc:mariadb://localhost:3306/test"; // URL de conexão
    String username = "root"; // Nome de usuário do banco de dados
    String password = ""; // Senha do banco de dados
    public Connection getConnection() {

        //Connection conexao = null; // Declare a variável conexao aqui

        try {
            Connection conexao = DriverManager.getConnection(url, username, password);
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage(), e);
        }
    }
}
