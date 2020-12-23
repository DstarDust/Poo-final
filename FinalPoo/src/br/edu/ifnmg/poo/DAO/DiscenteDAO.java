/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.DAO;

import br.edu.ifnmg.poo.factory.ConnectionFactory;
import br.edu.ifnmg.poo.model.Discente;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


/**
 *
 * @author Diego
 */
public class DiscenteDAO {
    
    private Connection connection;
   
    String nome;
    String email;
    String senha;
    Boolean regular;
    
   // private ResultSet rs;
   // private Statement st;
    private ArrayList<Discente> listad = new ArrayList<>();
    
    public DiscenteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public void adiciona(Discente discente){ 
        String sql = "INSERT INTO Discente(nome,email,senha,regular) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, discente.getNome());
            stmt.setString(2, discente.getEmail());
            stmt.setString(3, discente.getSenha());
            
            System.out.println(""+discente.getRegular());
            
            stmt.setBoolean(4, discente.getRegular());
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
    public ArrayList<Discente> listarTodos() throws SQLException{
        
        String sql = "SELECT * FROM Discente";
        
        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         //PreparedStatement stmt=connection.prepareStatement(sql);
         ResultSet rs;
         rs= stmt.executeQuery(sql);
        
       
        while(rs.next()){
        
            Discente discente = new Discente();
            discente.setNome(rs.getString("Nome"));
            discente.setEmail(rs.getString("Email"));
            discente.setSenha(rs.getString("Senha"));
            discente.setRegular(rs.getBoolean("Regular"));
            
            listad.add(discente);
            
        }
     
        
        return listad;
    }
    
}
