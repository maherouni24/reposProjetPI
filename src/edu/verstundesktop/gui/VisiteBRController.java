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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VisiteBRController implements Initializable {

    @FXML
    private TextArea tfVisite;
    @FXML
    private Button btnRetour;
    public Connection cnx;
    private TextArea tfGuide;
    private TextArea tfGuidePrenom;
    @FXML
    private TextField tfId;
    private TextField tfNomGuide;
    @FXML
    private Button btnAfficherGuide;

    /**
     * Initializes the controller class.
     */
    public VisiteBRController() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setTfId(String message) {
        this.tfId.setText(message);
    }

    public void setTfVisite(String message) {
        this.tfVisite.setText(message);
    }

    public void setTfGuide(String message) {
        this.tfGuide.setText(message);
    }

    public void setTfGuidePrenom(String message) {
        this.tfGuidePrenom.setText(message);
    }

    @FXML
    private void SendToSiteArch(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SaBullaRegia.fxml"));
        try {
            Parent root = loader.load();
            SaBullaRegiaController sbrc = loader.getController();

            btnRetour.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void AfficherDetailsGuide(ActionEvent event) {

        try {
            String req = "select * from guide where idG=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, Integer.parseInt(tfId.getText()));
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsGuideVisite.fxml"));
                try {
                    Parent root = loader.load();
                    DetailsGuideVisiteController dgvc = loader.getController();
                    dgvc.setTfNom(rs.getString("nomG"));
                    dgvc.setTfPrenom(rs.getString("prenomG"));
                    dgvc.setTfMail(rs.getString("mailG"));
                    dgvc.setTfTele(rs.getString("telG"));

                    tfId.getScene().setRoot(root);
                    System.out.println("hi");
                } catch (IOException ex) {
                    System.out.println("Error:" + ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Details vides");

                //tfGuide.requestFocus();
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
