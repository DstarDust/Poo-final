/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.model;

/**
 *
 * @author Diego
 */
public class Usuario {
    
    int id;
    String nome;
    String email;
    String senha;
    
    // get ----------------------
    
    public int getId(){
       return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    //---------------------------
   
    
    // set ----------------------
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        
        this.nome = nome;
        
    }
    
    public void setEmail(String email){
        
        this.email = email;
        
    }
    
    public void setSenha(String senha){
        
        this.senha = senha;
        
    }
    
    //---------------------------
}
