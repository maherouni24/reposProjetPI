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
public class Visite {

    private int idV;
    private String dateV;
    private int idS;
    private int idG;

    public Visite() {
    }

    public Visite(int idV, String dateV) {
        this.idV = idV;
        this.dateV = dateV;
    }

    public Visite(int idV, String dateV, int idS, int idG) {
        this.idV = idV;
        this.dateV = dateV;
        this.idS = idS;
        this.idG = idG;
    }

    public int getIdV() {
        return idV;
    }

    public String getDateV() {
        return dateV;
    }

    public int getIdS() {
        return idS;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public void setDateV(String dateV) {
        this.dateV = dateV;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    @Override
    public String toString() {
        return "Visite{" + "idV=" + idV + ", dateV=" + dateV + ", idS=" + idS + ", idG=" + idG + '}';
    }
  
}
