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
public class Vendas {
    private int id;
    private String nomeVendedor;
    private String produtoVendido;
    
    Conexao con = new Conexao();
    
    public Vendas(){
        this(0, "", "");
    }

    public Vendas(int id, String nomeVendedor, String produtoVendido) {
        this.id = id;
        this.nomeVendedor = nomeVendedor;
        this.produtoVendido = produtoVendido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public Conexao getCon() {
        return con;
    }

    public void setCon(Conexao con) {
        this.con = con;
    }
    
        public void cadastrarVenda() throws SQLException{
         String sql= "Insert into venda(nomeVendedor,produtoVendido)values "+"('"+ this.getNomeVendedor()+"','"+ this.getProdutoVendido()+"' )";
        con.executeSQL(sql);
    }
    
    public ResultSet consultar() throws SQLException{
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from venda";
        tabela = con.RetornarResultset(sql);
        return tabela;   
    }
      
     public ResultSet consultarCampoEspecifico(){
        ResultSet tabela;
        tabela = null;
    
        try{
          String sql="Select * from venda where nomeVendedor like '"+ getNomeVendedor()+"%'";
          tabela= con.RetornarResultset(sql);                  
       
           }
           catch(Exception sqle){
                JOptionPane.showMessageDialog(null,"Atenção..."+sqle.getMessage());
           }
        return tabela;    
    }
     
      public void excluir() throws SQLException{
        String sql;
        sql= "Delete from venda where id="+ getId();
        con.executeSQL(sql);
    }     
    
    public void alterar() throws SQLException{
        String sql="Update venda set nomeVendedor='"+ this.getNomeVendedor()+"',produtoVendido='"+this.getProdutoVendido()+"' where id="+id;
        con.executeSQL(sql);
        
    }      
}
