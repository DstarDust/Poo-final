/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.DAO;

import br.edu.ifnmg.poo.factory.ConnectionFactory;
import br.edu.ifnmg.poo.model.Discente;
import br.edu.ifnmg.poo.model.Docente;
import br.edu.ifnmg.poo.model.Orientacao;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class OrientacaoDAO {
 
       private Connection connection;
   
    LocalDate dataInicio;
    LocalDate dataFim;
    String relatorio;
    Boolean aprovado;
    
    public OrientacaoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public void adiciona(Orientacao orientacao, String Combobox1, String Combobox2){ 
        String sql = "INSERT INTO Orientacao(dataInicio,dataFim,idDocente,idDiscente,relatorio,aprovado) VALUES(?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            Date dataInicio = Date.valueOf(orientacao.getDInicio());
            Date dataFim = Date.valueOf(orientacao.getDFim());
            
            Docente idDocente = buscarIdDocente(Combobox1);
            Discente idDiscente = buscarIdDiscente(Combobox2);
            
            stmt.setDate(1, dataInicio);
            stmt.setDate(2, dataFim);
            stmt.setInt(3, idDocente.getId());
            stmt.setInt(4, idDiscente.getId());
            stmt.setString(5, orientacao.getRelatorio());
            stmt.setBoolean(6, orientacao.getAprovado());
          
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
    public Docente buscarIdDocente(String docente) throws SQLException{
    
        String sql="select *from Docente where nome like '%"+ docente +"%'";
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         Docente tempdocente = new Docente();
         
         tempdocente.setId(rs.getInt("Id"));
         
         return tempdocente;
    }
    
    public Discente buscarIdDiscente(String discente) throws SQLException{
    
        String sql="select *from Discente where nome like '%"+ discente +"%'";
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
         rs.first();
         
         Discente tempdiscente = new Discente();
         
         tempdiscente.setId(rs.getInt("Id"));
         
         return tempdiscente;
    }
    
}
