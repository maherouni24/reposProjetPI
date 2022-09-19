/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.services;

import edu.verstundesktop.entities.Propriete;
import edu.verstundesktop.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class ProprieteCRUD {

  
  

    public void AjouterPropriete(Propriete p) {
        
    		
           String requete="INSERT INTO propriete(idP,nomP,gouvernoratP,nbreChambre,dateajout)"+"VALUES('"+p.getIdP()+"','"+p.getNomP()+"','"+p.getGouvernoratP()+"','"+p.getNbreChambre()+"','"+p.getDateajout()+"')";
        try{
          Statement st=MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("propriete ajoutée avec succés");
    }
    catch(SQLException ex) {
          System.out.println(ex.getMessage());
      }   
    }

    public void ModifierPropriete(Propriete p,int idP) {
        String requete="UPDATE propriete SET nomP=?,gouvernoratP=?,nbreChambre=?,dateajout=? WHERE idP=?";
        try{
             PreparedStatement pst =  MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,p.getNomP());
            pst.setString(2, p.getGouvernoratP());
            pst.setInt(3, p.getNbreChambre());
            pst.setString(4,p.getDateajout());
             pst.setInt(5, p.getIdP());
          pst.executeUpdate(); 
              System.out.println("propriete modifiée avec succés");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        } 
        }

    public void SupprimerPropriete(Propriete p) {
       try{
           String requete="DELETE FROM propriete WHERE idP=?";
            PreparedStatement pst =  MyConnection.getInstance().getCnx().prepareStatement(requete);
           pst.setInt(1, p.getIdP());
            pst.executeUpdate(); 
              System.out.println("propriete supprimée avec succés");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        } 
       }

    public ObservableList<Propriete> AfficherPropriete() {
        ObservableList<Propriete> myList = FXCollections.observableArrayList();
        try {
           
            String requete="SELECT*FROM propriete ";
        
            Statement st= MyConnection.getInstance().getCnx().createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
            Propriete p=new Propriete();
            p.setIdP(rs.getInt(1));
            p.setNbreChambre(rs.getInt("nbreChambre"));
            p.setNomP(rs.getString("nomP"));
            p.setGouvernoratP(rs.getString("gouvernoratP"));
           p.setDateajout(rs.getString("dateajout"));
           myList.add(p);
           }
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        return myList;
  }
    

}
