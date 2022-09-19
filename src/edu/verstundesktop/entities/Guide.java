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
public class Guide {
private int idG;
private String nomG;
private String prenomG;
private int telG;
private String mailG;

    public Guide() {
    }

    public Guide(int idG, String nomG, String prenomG, int telG, String mailG) {
        this.idG = idG;
        this.nomG = nomG;
        this.prenomG = prenomG;
        this.telG = telG;
        this.mailG = mailG;
    }

    public int getIdG() {
        return idG;
    }

    public String getNomG() {
        return nomG;
    }

    public String getPrenomG() {
        return prenomG;
    }

    public int getTelG() {
        return telG;
    }

    public String getMailG() {
        return mailG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public void setNomG(String nomG) {
        this.nomG = nomG;
    }

    public void setPrenomG(String prenomG) {
        this.prenomG = prenomG;
    }

    public void setTelG(int telG) {
        this.telG = telG;
    }

    public void setMailG(String mailG) {
        this.mailG = mailG;
    }

    @Override
    public String toString() {
        return "Guide{" + "idG=" + idG + ", nomG=" + nomG + ", prenomG=" + prenomG + ", telG=" + telG + ", mailG=" + mailG + '}';
    }


    
}
