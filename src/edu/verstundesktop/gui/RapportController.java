/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import edu.verstundesktop.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class RapportController implements Initializable {

    public Connection cnx;

    @FXML
    private TextArea tfRapport;
    @FXML
    private Button tfEnvoyer;
    @FXML
    private TextField tfMail;
    private TextField tfNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public RapportController() {
        cnx = MyConnection.getInstance().getCnx();
    }
    public void setTfMail(String message) {
        this.tfMail.setText(message);
    }
    public void setTfNom(String message) {
        this.tfNom.setText(message);
    }
    @FXML
    private void SendRapport(ActionEvent event) {
        AccueilPrestataireController apc =new AccueilPrestataireController();
        String rappotPr = tfRapport.getText();
        String mailPr = tfMail.getText();
        if (rappotPr.equals("")) {
            JOptionPane.showMessageDialog(null, "Rapport vide");
        } else {
            try {
                String requete = "UPDATE prestataire SET rapport=? WHERE mailPr=?";
                PreparedStatement pst = cnx.prepareStatement(requete);
                pst.setString(1, rappotPr);
                pst.setString(2, mailPr);
                pst.executeUpdate();
                System.out.println("Rapport ajoutée avec succé");
                JOptionPane.showMessageDialog(null, "Rapport envoyé");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            
        }

    }

    @FXML
    private void SendToAccueil(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilPrestataire.fxml"));
        try {
            Parent root = loader.load();
            AccueilPrestataireController apc = loader.getController();
            
//            apc.setTfNom(apc.getTfNom().getText());
//            apc.setTfPrenom(apc.getTfPrenom().getText()); 
            
            apc.setTfMail(tfMail.getText());
            tfRapport.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

}
