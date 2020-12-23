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
public class Discente extends Usuario{
    
    Boolean regular;
    
    public void setRegular(Boolean regular){
        this.regular = regular;
    }
    
    public Boolean getRegular(){
        return regular;
    }
}
