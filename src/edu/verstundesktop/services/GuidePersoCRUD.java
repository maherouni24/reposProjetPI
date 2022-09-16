/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.services;

import edu.verstundesktop.entities.Guide;
import edu.verstundesktop.entities.GuidePersonnalise;
import edu.verstundesktop.tools.MyConnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class GuidePersoCRUD extends Guide{
    
 public void AjouterGuidePers(GuidePersonnalise gp) {
      String requete="INSERT INTO GuidePersonnalise(idGP,tarifGP,modepaiement)"+"VALUES('"+gp.getIdGP()+"','"+gp.getMailG()+"','"+gp.getModePaiement()+"'+super.ajouterGuide())";
        try{
        
    	Statement st=MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("guidepersonnalise ajoutée avec succés");
    }
    catch(SQLException ex) {
          System.out.println(ex.getMessage());
      }   
    }	  
  
}
