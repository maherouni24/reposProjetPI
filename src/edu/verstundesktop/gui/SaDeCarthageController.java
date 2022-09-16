/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class SaDeCarthageController implements Initializable {

    @FXML
    private Button btnPrecedent;
    @FXML
    private Button btnSuivant;
    @FXML
    private ImageView premImage;
    @FXML
    private ImageView secondImage;
    @FXML
    private ImageView thirdImage;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        premImage.setVisible(true);
        secondImage.setVisible(false);
        thirdImage.setVisible(false);
    }    

    @FXML
    private void SendToPrevious(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SaDeDougga.fxml"));
        try {
            Parent root = loader.load();
            SaDeDouggaController sdc = loader.getController();

            btnSuivant.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void SendToNext(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SaElJem.fxml"));
        try {
            Parent root = loader.load();
            SaElJemController sjc = loader.getController();

            btnSuivant.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void FirstImage(ActionEvent event) {
        if (event.getSource() == btn1) {
            premImage.setVisible(true);
            secondImage.setVisible(false);
            thirdImage.setVisible(false);
            return;
        }
    }

    @FXML
    private void SecondImage(ActionEvent event) {
        if (event.getSource() == btn2) {

            premImage.setVisible(false);
            secondImage.setVisible(true);
            thirdImage.setVisible(false);
            return;
        }
    }

    @FXML
    private void ThirdImage(ActionEvent event) {
        if (event.getSource() == btn3) {
            thirdImage.setVisible(true);
            secondImage.setVisible(false);
            premImage.setVisible(false);
            return;
        }
    }
    
}
