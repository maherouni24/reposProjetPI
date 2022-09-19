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
public class ProfilPrestataireController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void UpdateProfil(ActionEvent event) {
        Prestataire p = new Prestataire();

        p.setNomPr(tfNom.getText());
        p.setPrenomPr(tfPrenom.getText());
        p.setMailPr(tfMail.getText());

        PrestataireCRUD pc = new PrestataireCRUD();
        if (event.getSource() == btnModifier) {
            pc.modifierPrestataire2(p, p.getNomPr());
            JOptionPane.showMessageDialog(null, "données modifiés");
        }
    }

    @FXML
    private void SendToAccueil(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilPrestataire.fxml"));
        try {
            Parent root = loader.load();
            AccueilPrestataireController apc = loader.getController();
            apc.setTfNom(tfNom.getText());
            apc.setTfPrenom(tfPrenom.getText());
            apc.setTfMail(tfMail.getText());
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

}
