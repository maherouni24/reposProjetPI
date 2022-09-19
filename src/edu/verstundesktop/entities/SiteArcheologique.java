/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.entities;

/**
 *
 * @author user
 */
public class SiteArcheologique {

    private int idS;
    private String nomS;
    private String gouvernoratS;

    public SiteArcheologique() {
    }

    public SiteArcheologique(String nomS, String gouvernoratS) {
        this.nomS = nomS;
        this.gouvernoratS = gouvernoratS;
    }

    public SiteArcheologique(int idS, String nomS, String gouvernoratS) {
        this.idS = idS;
        this.nomS = nomS;
        this.gouvernoratS = gouvernoratS;
    }

    public int getIdS() {
        return idS;
    }

    public String getNomS() {
        return nomS;
    }

    public String getGouvernoratS() {
        return gouvernoratS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public void setGouvernoratS(String gouvernoratS) {
        this.gouvernoratS = gouvernoratS;
    }

    @Override
    public String toString() {
        return "SiteArcheologique{" + "idS=" + idS + ", nomS=" + nomS + ", gouvernoratS=" + gouvernoratS + '}';
    }

    
    
    
}
