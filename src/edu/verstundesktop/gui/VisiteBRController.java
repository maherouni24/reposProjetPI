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
    @FXML
    private Button btnafficherguide;
    public Connection cnx;
    @FXML
    private TextArea tfGuide;
    @FXML
    private TextArea tfGuidePrenom;
    @FXML
    private TextField tfId;

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
    private void AfficherGuide(ActionEvent event) {
        try {
            String req = "select * from guide where idG=5";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {

                VisiteBRController vbrc = new VisiteBRController();
                vbrc.setTfGuide(rs.getString("nomG"));
                vbrc.setTfGuidePrenom(rs.getString("prenomG"));
            } else {
                JOptionPane.showMessageDialog(null, "rien à afficher");
                btnRetour.requestFocus();
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
