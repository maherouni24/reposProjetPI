/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.services;

import edu.verstundesktop.entities.Guide;
import edu.verstundesktop.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class GuideCRUD {
    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getCnx();
     public void ajouterGuide(Guide g) {

        String requete = "INSERT INTO guide (nomG, prenomG, telG, mailG)  VALUES (?,?,?,?)"  ;
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, g.getNomG()); // 1: index du parametre: point d interrogation numero 1
            pst.setString(2, g.getPrenomG());
            pst.setInt(3, g.getTelG());
            pst.setString(4, g.getMailG());
            pst.executeUpdate();
            System.out.println("Guide ajouté avec succée!");
         
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
