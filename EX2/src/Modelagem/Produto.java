/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author anala
 */
public class Produto {
    private int id;
    private String nomeProduto;
    private String descricao;
    
    Conexao con = new Conexao();
    
    public Produto(){
        this(0, "", "");
    }

    public Produto(int id, String nomeProduto, String descricao) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conexao getCon() {
        return con;
    }

    public void setCon(Conexao con) {
        this.con = con;
    }
    
    
    public void cadastrarProduto() throws SQLException{
         String sql= "Insert into produto(NomeProduto,Descricao)values "+"('"+ this.getNomeProduto()+"','"+ this.getDescricao()+"' )";
        con.executeSQL(sql);
    }
    
    public ResultSet consultar() throws SQLException{
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from produto";
        tabela = con.RetornarResultset(sql);
        return tabela;   
    }
      
     public ResultSet consultarCampoEspecifico(){
        ResultSet tabela;
        tabela = null;
    
        try{
          String sql="Select * from produto where nomeproduto like '"+ getNomeProduto()+"%'";
          tabela= con.RetornarResultset(sql);                  
       
           }
           catch(Exception sqle){
                JOptionPane.showMessageDialog(null,"Atenção..."+sqle.getMessage());
           }
        return tabela;    
    }
     
      public void excluir() throws SQLException{
        String sql;
        sql= "Delete from produto where id="+ getId();
        con.executeSQL(sql);
    }     
    
    public void alterar() throws SQLException{
        String sql="Update produto set nomeProduto='"+ this.getNomeProduto()+"',descricao='"+this.getDescricao()+"' where id="+id;
        con.executeSQL(sql);
        
    }      
}
