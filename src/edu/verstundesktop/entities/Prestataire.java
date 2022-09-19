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
public class Prestataire {
   private int idPr;
    private String nomPr;
    private String prenomPr;
    private String mailPr;
    private String psw;
    private String rappot;

    public Prestataire() {
    }

    public Prestataire(String nomPr, String prenomPr) {
        this.nomPr = nomPr;
        this.prenomPr = prenomPr;
    }

    public Prestataire(String nomPr, String prenomPr, String mailPr) {
        this.nomPr = nomPr;
        this.prenomPr = prenomPr;
        this.mailPr = mailPr;
    }

    public Prestataire(int idPr, String nomPr, String prenomPr, String mailPr) {
        this.idPr = idPr;
        this.nomPr = nomPr;
        this.prenomPr = prenomPr;
        this.mailPr = mailPr;
    }

    public Prestataire(int idPr, String nomPr, String prenomPr, String mailPr, String psw) {
        this.idPr = idPr;
        this.nomPr = nomPr;
        this.prenomPr = prenomPr;
        this.mailPr = mailPr;
        this.psw = psw;
    }

    public Prestataire(int idPr, String nomPr, String prenomPr, String mailPr, String psw, String rappot) {
        this.idPr = idPr;
        this.nomPr = nomPr;
        this.prenomPr = prenomPr;
        this.mailPr = mailPr;
        this.psw = psw;
        this.rappot = rappot;
    }
    
    public int getIdPr() {
        return idPr;
    }

    public String getNomPr() {
        return nomPr;
    }

    public String getPrenomPr() {
        return prenomPr;
    }

    public String getMailPr() {
        return mailPr;
    }

    public void setIdPr(int idPr) {
        this.idPr = idPr;
    }

    public void setNomPr(String nomPr) {
        this.nomPr = nomPr;
    }

    public void setPrenomPr(String prenomPr) {
        this.prenomPr = prenomPr;
    }

    public void setMailPr(String mailPr) {
        this.mailPr = mailPr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getRappot() {
        return rappot;
    }

    public void setRappot(String rappot) {
        this.rappot = rappot;
    }
    
    @Override
    public String toString() {
        return "Prestataire{" + "idPr=" + idPr + ", nomPr=" + nomPr + ", prenomPr=" + prenomPr + ", mailPr=" + mailPr + '}';
    } 
    
}
