/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class DetailsGuideVisiteController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfTele;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    public void setTfNom(String message) {
        this.tfNom.setText(message);
    }
    public void setTfPrenom(String message) {
        this.tfPrenom.setText(message);
    }
    public void setTfTele(String message) {
        this.tfTele.setText(message);
    }
    public void setTfMail(String message) {
        this.tfMail.setText(message);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendToVisitBR(ActionEvent event) {
    }
    
}
