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
public class GuidePersonnalise extends Guide {
    private int idGP;
    private int tarif;
    private String modePaiement;


    public GuidePersonnalise() {
    }

    public GuidePersonnalise(int idG,String nomG,String prenomG,int telG,String mailG,int idGP, int tarif, String modePaiement) {
       super(idG,nomG,prenomG,telG,mailG);
        this.idGP = idGP;
        this.tarif = tarif;
        this.modePaiement = modePaiement;
    }

    public int getIdGP() {
        return idGP;
    }

    public int getTarif() {
        return tarif;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setIdGP(int idGP) {
        this.idGP = idGP;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    @Override
    public String toString() {
        return super.toString()+"GuidePersonnalise{" + "idGP=" + idGP+ ", tarif=" + tarif + ", modePaiement=" + modePaiement + '}';
    }
    
    
    
}
