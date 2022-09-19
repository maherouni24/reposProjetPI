/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.services.PrestataireCRUD;
import edu.verstundesktop.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class EnregistrementPrestataireController implements Initializable {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;
    @FXML
    private TableView<Prestataire> prestataireTable;
    @FXML
    private TableColumn<Prestataire, Integer> idColumn;
    @FXML
    private TableColumn<Prestataire, String> nomColumn;
    @FXML
    private TableColumn<Prestataire, String> prenomColumn;
    @FXML
    private TableColumn<Prestataire, String> mailColumn;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField tfPsw;
    @FXML
    private TableColumn<Prestataire, String> pswColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showPrestataire();
        tfId.setText("1"); 
    }

    @FXML
    private void AddPrestataire(ActionEvent event) {
        Prestataire p = new Prestataire();
        p.setIdPr(Integer.parseInt(tfId.getText()));
        p.setNomPr(tfNom.getText());
        p.setPrenomPr(tfPrenom.getText());
        p.setMailPr(tfMail.getText());
        p.setPsw(tfPsw.getText()); 

        PrestataireCRUD pc = new PrestataireCRUD();
        if(tfNom.getText().length()==0 &&tfMail.getText().length()==0&&tfPsw.getText().length()==0){
        JOptionPane.showMessageDialog(null, "données vides");
        }
        else if (tfPsw.getText().length()>=8) {
            pc.ajouterPrestataire2(p);
            showPrestataire();
            JOptionPane.showMessageDialog(null, "prestataire bien ajouté ");
        }else{JOptionPane.showMessageDialog(null, "mot de passe doit étre supérieur ou égale à 8");}

    }
    
    @FXML
    private void UpdatePrestataire(ActionEvent event) {
        Prestataire p = new Prestataire();
        p.setIdPr(Integer.parseInt(tfId.getText()));
        p.setNomPr(tfNom.getText());
        p.setPrenomPr(tfPrenom.getText());
        p.setMailPr(tfMail.getText());
        p.setPsw(tfPsw.getText()); 

        PrestataireCRUD pc = new PrestataireCRUD();
        if (event.getSource() == btnModifier) {
            pc.modifierPrestataire(p, p.getIdPr());
            showPrestataire();
        }
    }

    @FXML
    private void DeletePrestataire(ActionEvent event) {
        Prestataire p = new Prestataire();
        p.setIdPr(Integer.parseInt(tfId.getText()));
        p.setNomPr(tfNom.getText());
        p.setPrenomPr(tfPrenom.getText());
        p.setMailPr(tfMail.getText());
        p.setPsw(tfPsw.getText()); 
        
        PrestataireCRUD pc = new PrestataireCRUD();
        if (event.getSource() == btnSupprimer) {
            pc.supprimerPrestataire(p);
            showPrestataire();
        }
    }

    public void showPrestataire() {
        PrestataireCRUD pcd = new PrestataireCRUD();
        ObservableList<Prestataire> List = pcd.afficherPrestataires();

        idColumn.setCellValueFactory(new PropertyValueFactory<Prestataire, Integer>("idPr"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<Prestataire, String>("nomPr"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<Prestataire, String>("prenomPr"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<Prestataire, String>("mailPr"));
        pswColumn.setCellValueFactory(new PropertyValueFactory<Prestataire, String>("psw"));

        prestataireTable.setItems(List);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Prestataire p = prestataireTable.getSelectionModel().getSelectedItem();
        tfId.setText(""+p.getIdPr());
        tfNom.setText(p.getNomPr());
        tfPrenom.setText(p.getPrenomPr());
        tfMail.setText(p.getMailPr());
        tfPsw.setText(p.getPsw()); 
    }

}
