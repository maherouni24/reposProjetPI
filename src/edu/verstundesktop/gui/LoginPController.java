/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import edu.verstundesktop.tools.MyConnection;
import java.io.IOException;
import java.awt.GridLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class LoginPController implements Initializable {

    @FXML
    private TextField tfMail;
    @FXML
    private PasswordField tfPsw;
    @FXML
    private Button tfConnexion;

    /**
     * Initializes the controller class.
     */
    public Connection cnx;
    @FXML
    private CheckBox tfAfficher;
    @FXML
    private TextField tfPass;

    public LoginPController() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfPsw.setVisible(true);
        tfPass.setVisible(false);
    }

    @FXML
    private void SendToAccueil(ActionEvent event) {

        String prmail = tfMail.getText();
        String pswPr = tfPsw.getText();

        if (prmail.equals("") && pswPr.equals("")) {
            JOptionPane.showMessageDialog(null, "mail et mot de passe vide");
        } else if (prmail.equals("")) {
            JOptionPane.showMessageDialog(null, "mail vide");
        } else if (pswPr.equals("")) {
            JOptionPane.showMessageDialog(null, "mot de passe vide");
        } else {
            try {
                String req = "select * from prestataire where mailPr=? and psw=?";
                PreparedStatement pst = cnx.prepareStatement(req);
                pst.setString(1, prmail);
                pst.setString(2, pswPr);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilPrestataire.fxml"));
                    try {
                        Parent root = loader.load();
                        AccueilPrestataireController apc = loader.getController();
                        apc.setTfNom(rs.getString("nomPr"));
                        apc.setTfPrenom(rs.getString("prenomPr"));
                        apc.setTfMail(rs.getString("mailPr"));
                        tfMail.getScene().setRoot(root);
                    } catch (IOException ex) {
                        System.out.println("Error:" + ex.getMessage());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "données non valides");
                    tfMail.setText("");
                    tfPsw.setText("");
                    tfMail.requestFocus();
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void AfficherPwd(MouseEvent event) {

        if (tfAfficher.isSelected()) {
            tfPass.setText(tfPsw.getText());
            tfPass.setVisible(true);
            tfPsw.setVisible(false);
            return;
        }
        tfPsw.setText(tfPass.getText());
        tfPsw.setVisible(true);
        tfPass.setVisible(false);
    }

    @FXML
    private void SendToSendCode(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SendCode.fxml"));
        try {
            Parent root = loader.load();
            SendCodeController scc = loader.getController();

            tfMail.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    @FXML
    private void SendToSite(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SaBullaRegia.fxml"));
        try {
            Parent root = loader.load();
            SaBullaRegiaController src = loader.getController();

            tfAfficher.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

}
