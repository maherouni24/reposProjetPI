/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.tests;



import edu.verstundesktop.entities.Client;
import edu.verstundesktop.entities.Login;
import edu.verstundesktop.entities.Propriete;
import edu.verstundesktop.services.ProprieteCRUD;
import edu.verstundesktop.tools.MyConnection;
import java.sql.Date;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.services.PrestataireCRUD;
import edu.verstundesktop.tools.MyConnection;


/**
 *
 * @author user
 */
public class MainClass {

    
    
  public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        //PrestataireCRUD pcd = new PrestataireCRUD();
        //Prestataire p2 = new Prestataire("ouni","aladin","ouni.aladin@esprit.tn");
        //pcd.ajouterPrestataire2(p2);
        
        //Prestataire p3=new Prestataire(3, "zribi", "cyrine"," jjjjjjjjjjj");
        //Prestataire p4=new Prestataire(4, "zribi", "lotfi"," jjjj@jjj");
        //pcd.ajouterPrestataire2(p4);
        //pcd.modifierPrestataire(p2, 3);
        //pcd.supprimerPrestataire(p4);
        //System.out.println(pcd.afficherPrestataires());

    }  

}
