/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.entities;

import java.sql.Date;
import java.time.LocalDate;



/**
 *
 * @author user
 */
public class Propriete {
    private int idP;
    private String nomP;
    private String gouvernoratP; 
    private int nbreChambre;
    private String  dateajout;
    
    public Propriete() {
    }

    
    

    public Propriete(int idP,String nomP, String gouvernoratP,int nbreChambre,String dateajout) {
        this.idP = idP;
        this.nomP = nomP;
        this.gouvernoratP = gouvernoratP;
        this.nbreChambre= nbreChambre;
        this.dateajout=dateajout;
    }

   

    public int getIdP() {
        return idP;
    }

    
    public String getNomP() {
        return nomP;
    }

    public String getGouvernoratP() {
        return gouvernoratP;
    }

    public int getNbreChambre() {
        return nbreChambre;
    }
    

    public String getDateajout() {
        return dateajout;
    }

   

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setGouvernoratP(String gouvernoratP) {
        this.gouvernoratP = gouvernoratP;
    }

    public void setNbreChambre(int nbreChambre) {
        this.nbreChambre = nbreChambre;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    @Override
    public String toString() {
        return "Propriete{" + "idP=" + idP + ", nomP=" + nomP + ", gouvernoratP=" + gouvernoratP + ", nbreChambre=" + nbreChambre + ", dateajout=" + dateajout + '}';
    }

    
    

   

   

   
    
    
    
}
