/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.services;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.entities.SiteArcheologique;
import edu.verstundesktop.gui.EnregistrementPrestataireController;
import edu.verstundesktop.gui.EnregistrementSiteArceologiqueController;
import edu.verstundesktop.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class SiteArcheologiqueCRUD {

    public Connection cnx;

    public SiteArcheologiqueCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterSiteArcheologique() {

        try {
            String requete = "INSERT INTO sitearcheologique(nomS,gouvernoratS) VALUES('zama','siliana')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Site Archeologique ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterSiteArcheologique2(SiteArcheologique s) {
        try {
            String requete2 = "INSERT INTO sitearcheologique(nomS,gouvernoratS) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setString(1, s.getNomS());
            pst.setString(2, s.getGouvernoratS());
            pst.executeUpdate();
            System.out.println("Site Archeologique ajoutée avec succé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierSiteArcehologique(SiteArcheologique s, int idS) {
        String requete4 = "UPDATE sitearcheologique SET nomS=?,gouvernoratS=? WHERE idS=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete4);
            pst.setString(1, s.getNomS());
            pst.setString(2, s.getGouvernoratS());
            pst.setInt(3, idS);
            pst.executeUpdate();
            System.out.println("Site Archeologique modifié");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerSiteArcheologique(SiteArcheologique s) {
        String requete = "DELETE FROM sitearcheologique WHERE idS=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, s.getIdS());
            pst.executeUpdate();
            System.out.println("Site Archeologique supprimé");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList<SiteArcheologique> afficherSiteArcheologique() {
        ObservableList<SiteArcheologique> SiteArcheologiqueList = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT *FROM sitearcheologique";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                SiteArcheologique s = new SiteArcheologique();
                s.setIdS(rs.getInt(1));
                s.setNomS(rs.getString("nomS"));
                s.setGouvernoratS(rs.getString("GouvernoratS"));
                SiteArcheologiqueList.add(s);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return SiteArcheologiqueList;
    }

}
