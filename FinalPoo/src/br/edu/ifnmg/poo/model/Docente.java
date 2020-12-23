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
public class Docente extends Usuario
{
    
    String titulo;
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
}

