/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.services;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.gui.EnregistrementPrestataireController;
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
public class PrestataireCRUD {

    public Connection cnx;

    public PrestataireCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPrestataire() {

        try {
            String requete = "INSERT INTO Prestataire(nomPr,prenomPr,mailPr,psw) VALUES('Ouni','Maher','maher.ouni@esprit.tn','bonjour')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Prestataire ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterPrestataire2(Prestataire P) {
        try {
            String requete2 = "INSERT INTO Prestataire(nomPr,prenomPr,mailPr,psw) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setString(1, P.getNomPr());
            pst.setString(2, P.getPrenomPr());
            pst.setString(3, P.getMailPr());
            pst.setString(4, P.getPsw());
            pst.executeUpdate();
            System.out.println("Prestataire ajoutée avec succé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierPrestataire(Prestataire p, int idPr) {
        String requete4 = "UPDATE prestataire SET nomPr=?,prenomPr=?,mailPr=?,psw=? WHERE idPr=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete4);
            pst.setString(1, p.getNomPr());
            pst.setString(2, p.getPrenomPr());
            pst.setString(3, p.getMailPr());
            pst.setString(4, p.getPsw());
            pst.setInt(5, idPr);
            pst.executeUpdate();
            System.out.println("Prestataire modifié");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerPrestataire(Prestataire p) {
        String requete = "DELETE FROM prestataire WHERE idPr=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getIdPr());
            pst.executeUpdate();
            System.out.println("Prestataire supprimé");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ObservableList<Prestataire> afficherPrestataires() {
        ObservableList<Prestataire> PrestataireList = FXCollections.observableArrayList();
        try {
            String requete3 = "SELECT *FROM prestataire"; 
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Prestataire p = new Prestataire();
                p.setIdPr(rs.getInt(1));
                p.setNomPr(rs.getString("nomPr"));
                p.setPrenomPr(rs.getString("prenomPr"));
                p.setMailPr(rs.getString("mailPr"));
                p.setPsw(rs.getString("psw"));
                PrestataireList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return PrestataireList;
    }
    
    public void modifierPrestataire2(Prestataire p, String nomPr) {
        String requete4 = "UPDATE prestataire SET nomPr=?,prenomPr=?,mailPr=? WHERE nomPr=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete4);
            pst.setString(1, p.getNomPr());
            pst.setString(2, p.getPrenomPr());
            pst.setString(3, p.getMailPr());
            pst.setString(4, p.getNomPr());
            pst.executeUpdate();
            System.out.println("Prestataire modifié");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
