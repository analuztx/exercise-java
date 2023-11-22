/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Conexao {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1/atividade_8";
    private final String usuario = "root";
    private final String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean conecta() throws SQLException {
        boolean result = true;

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            // JOptionPane.showMessageDialog(null,"Conectou com o Banco de Dados");

        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver nao localizado: " + Driver);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: " + Fonte);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        boolean result = true;
        try {
            conexao.close();
            // JOptionPane.showMessageDialog(null,"Banco fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados" + fecha);
            result = false;
        }
    }

    public void executeSQL(String sql) throws SQLException {
        // chamada do metodo conecta para abrir a conexão com o db
        conecta();
        try {
            statement = conexao.createStatement();
            statement.execute(sql);
            // desconecta();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL: " + sqle.getMessage());
        } finally {
            desconecta();
        }
    }

    public ResultSet RetornarResultset(String sql) throws SQLException {
        ResultSet resultSet = null;
        conecta();
        try {
            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar resultset" + e.getMessage());
        }
        return resultSet;
    }
}
