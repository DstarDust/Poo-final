/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.model;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Orientacao {
    
    LocalDate dataInicio;
    LocalDate dataFim;
    String relatorio;
    Boolean aprovado; 
    
    // set ----------------------
    
    public void setDInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }
    
    public void setDFim(LocalDate dataFim){
        this.dataFim = dataFim;
    }
    
    public void setRelatorio(String relatorio){
        this.relatorio = relatorio;
    }
    
    public void setAprovado(Boolean aprovado){
        this.aprovado = aprovado;
    }
    
    //---------------------------
    
    // get ----------------------
    
    public LocalDate getDInicio(){
        return dataInicio;
    }
    
    public LocalDate getDFim(){
        return dataFim;
    }
    
    public String getRelatorio(){
        return relatorio;
    }
    
    public Boolean getAprovado(){
        return aprovado;
    }
    
    //---------------------------
    
    
}
