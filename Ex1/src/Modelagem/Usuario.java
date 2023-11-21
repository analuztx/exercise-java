/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anala
 */
public class Usuario {
    private String nome;
    private String email;
    private String login;
    private String senha;
    
    Conexao con = new Conexao();
    
    public Usuario(){
        this("", "", "", "");
    }

    public Usuario(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrarUsuario() throws SQLException{
        String sql = "INSERT INTO EX1 (nome, email, login, senha) VALUES ('" + this.nome + "', '" + this.email + "', '" + this.login + "', '" + this.senha + "')";
        con.executeSQL(sql);     
    }
    
    public void consultarUsuario(){
        String sql = "SELECT * FROM EX1 WHERE login = '" + this.login + "'";
        try {
            Conexao conexao = new Conexao();
            conexao.conecta();
            conexao.RetornarResultset(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    public void excluirUsuario() throws SQLException{
        String sql = "DELETE FROM EX1 WHERE login = '" + this.login + "'";
        con.executeSQL(sql);
    }
    
    public void alterarUsuario() throws SQLException{
        String sql = "UPDATE EX1 SET nome = '" + this.nome + "', email = '" + this.email + "', senha = '" + this.senha + "' WHERE login = '" + this.login + "'";
        con.executeSQL(sql);
    }
    
    public ResultSet listarUsuario() throws SQLException{
        ResultSet tabela = null;
        String sql = "SELECT * FROM EX1";
        
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
}
