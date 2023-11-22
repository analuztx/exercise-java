/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Usuario {
    Conexao con = new Conexao();
    
    private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    
    public Usuario(){
        this(0, "", "", "", "");
    }

    public Usuario(int id, String nome, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Conexao getCon() {
        return con;
    }

    public void setCon(Conexao con) {
        this.con = con;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
      String sql= "Insert into usuario(Nome,Email,Login,Senha)values "+
                "('"+ this.getNome()+"','"+this.getEmail()+"','"+this.getLogin()+"','"+ this.getSenha()+"' )";
        con.executeSQL(sql);
    }
 
 
      public ResultSet consultar() throws SQLException{
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from usuario";
        tabela = con.RetornarResultset(sql);
     return tabela;   
    }
      
     public ResultSet consultarCampoEspecifico(){
        ResultSet tabela;
        tabela = null;
    
        try{
          String sql="Select * from usuario where login like '"+ getLogin()+"%'";
          tabela= con.RetornarResultset(sql);                  
       
           }
           catch(Exception sqle){
                JOptionPane.showMessageDialog(null,"Atenção..."+sqle.getMessage());
           }
        return tabela;    
    }
     
      public void excluir() throws SQLException{
        String sql;
        sql= "Delete from usuario where id="+ getId();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso...");
    }     
    
    public void alterar() throws SQLException{
        String sql;
        sql="Update usuario set nome='"+ this.getNome()+"',email='"+this.getEmail()+"',login='"+this.getLogin()+"',senha='"+this.getSenha()+"' where id="+id;
        con.executeSQL(sql);
        
    }      

}
