/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.DAO;

import br.edu.ifnmg.poo.factory.ConnectionFactory;
import br.edu.ifnmg.poo.model.Docente;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class DocenteDAO {
 
     private Connection connection;
   
    String nome;
    String email;
    String senha;
    String titulo;
    
    private ArrayList<Docente> listad = new ArrayList<>();
    
    public DocenteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Docente docente){ 
        String sql = "INSERT INTO Docente(nome,email,senha,titulo) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, docente.getNome());
            stmt.setString(2, docente.getEmail());
            stmt.setString(3, docente.getSenha());
            stmt.setString(4, docente.getTitulo());
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
     public ArrayList<Docente> listarTodos() throws SQLException{
        
        String sql = "SELECT * FROM Docente";
        
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
        
       
        while(rs.next()){
        
            Docente docente = new Docente();
            docente.setNome(rs.getString("Nome"));
            docente.setEmail(rs.getString("Email"));
            docente.setSenha(rs.getString("Senha"));
            docente.setTitulo(rs.getString("titulo"));
            
            listad.add(docente);
            
        }
     
        
        return listad;
    }
   
    
}
