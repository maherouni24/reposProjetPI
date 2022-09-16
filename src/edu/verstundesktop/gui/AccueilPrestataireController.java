/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.services.PrestataireCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class AccueilPrestataireController implements Initializable {

    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnProprietes;
    @FXML
    private Button btnRapport;
    @FXML
    private Button btnDeconnecter;
    @FXML
    private TextField tfMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public TextField getTfMail() {
        return tfMail;
    }
    public TextField getTfNom() {
        return tfNom;
    }
    public TextField getTfPrenom() {
        return tfPrenom;
    }    
    public void setTfId(String message) {
        this.tfId.setText(message);
    }

    public void setTfNom(String message) {
        this.tfNom.setText(message);
    }

    public void setTfPrenom(String message) {
        this.tfPrenom.setText(message);
    }

    public void setTfMail(String message) {
        this.tfMail.setText(message);
    }

    @FXML
    private void AddRapport(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport.fxml"));
        try {
            Parent root = loader.load();
            RapportController rc = loader.getController();
            rc.setTfMail(tfMail.getText());
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void SendToProprietes(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPropriete.fxml"));
        try {
            Parent root = loader.load();
            FirstProprieteController fpc = loader.getController();
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void SendToLogin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginP.fxml"));
        try {
            Parent root = loader.load();
            LoginPController lc = loader.getController();
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void SendToProfil(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfilPrestataire.fxml"));
        try {
            Parent root = loader.load();
            ProfilPrestataireController ppc = loader.getController();
            ppc.setTfNom(tfNom.getText());
            ppc.setTfPrenom(tfPrenom.getText());
            ppc.setTfMail(tfMail.getText());
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

}
