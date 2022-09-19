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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class SaBullaRegiaController implements Initializable {

    @FXML
    private Button btnSuivant;
    @FXML
    private Button btnRetour;
    @FXML
    private ImageView premImage;
    @FXML
    private Button btn1;
    @FXML
    private ImageView secondImage;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private ImageView thirdImage;
    @FXML
    private Button btnVisite;
    public Connection cnx;

    /**
     * Initializes the controller class.
     */
    public SaBullaRegiaController() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        premImage.setVisible(true);
        secondImage.setVisible(false);
        thirdImage.setVisible(false);
    }

    @FXML
    private void SendToNext(ActionEvent event) {
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
    private void SendToAccueil(ActionEvent event) {

    }

    @FXML
    private void FirstImage(ActionEvent event) {
        if (event.getSource() == btn1) {
            thirdImage.setVisible(false);
            premImage.setVisible(true);
            secondImage.setVisible(false);
            return;
        }
    }

    @FXML
    private void SecondImage(ActionEvent event) {
        if (event.getSource() == btn2) {
            thirdImage.setVisible(false);
            secondImage.setVisible(true);
            premImage.setVisible(false);
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

    @FXML
    private void SendToVisite(ActionEvent event) {

        try {
            String req = "select * from visite where idS=18";

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            if (rs.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VisiteBR.fxml"));
                try {
                    Parent root = loader.load();
                    VisiteBRController vbrc = loader.getController();
                    vbrc.setTfVisite(rs.getString("dateV"));
                    vbrc.setTfId(rs.getString("idG"));
                    btnRetour.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println("Error:" + ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "rien à afficher");
                btnRetour.requestFocus();
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
