/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import edu.verstundesktop.entities.Prestataire;
import edu.verstundesktop.entities.SiteArcheologique;
import edu.verstundesktop.services.PrestataireCRUD;
import edu.verstundesktop.services.SiteArcheologiqueCRUD;
import edu.verstundesktop.tools.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class EnregistrementSiteArceologiqueController implements Initializable {

    //PreparedStatement st = null;
    //ResultSet rs = null;
    private Label label;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfGouvernorat;
    @FXML
    private TableView<SiteArcheologique> table;
    @FXML
    private TableColumn<SiteArcheologique, Integer> IdColumn;
    @FXML
    private TableColumn<SiteArcheologique, String> NomColumn;
    @FXML
    private TableColumn<SiteArcheologique, String> GouvColumn;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnModifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showSiteArceologique();
    }

    @FXML
    private void save(ActionEvent event) {
        SiteArcheologique s = new SiteArcheologique();
        s.setIdS(Integer.parseInt(tfId.getText()));
        s.setNomS(tfNom.getText());
        s.setGouvernoratS(tfGouvernorat.getText());

        SiteArcheologiqueCRUD scd = new SiteArcheologiqueCRUD();
        if (event.getSource() == btnAjouter) {
            scd.ajouterSiteArcheologique2(s);
            showSiteArceologique();
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        SiteArcheologique s = new SiteArcheologique();
        s.setIdS(Integer.parseInt(tfId.getText()));
        s.setNomS(tfNom.getText());
        s.setGouvernoratS(tfGouvernorat.getText());

        SiteArcheologiqueCRUD scd = new SiteArcheologiqueCRUD();
        if (event.getSource() == btnsupprimer) {
            scd.supprimerSiteArcheologique(s);
            showSiteArceologique();
        }

    }

    @FXML
    private void update(ActionEvent event) {
        SiteArcheologique s = new SiteArcheologique();
        s.setIdS(Integer.parseInt(tfId.getText()));
        s.setNomS(tfNom.getText());
        s.setGouvernoratS(tfGouvernorat.getText());

        SiteArcheologiqueCRUD scd = new SiteArcheologiqueCRUD();
        if (event.getSource() == btnModifier) {
            scd.modifierSiteArcehologique(s, s.getIdS());
            showSiteArceologique();
        }

    }

    @FXML
    private void tablehandleButtonAction(MouseEvent event) {
        SiteArcheologique s = table.getSelectionModel().getSelectedItem();
        tfId.setText("" + s.getIdS());
        tfNom.setText(s.getNomS());
        tfGouvernorat.setText(s.getGouvernoratS());
    }

    public void showSiteArceologique() {
        SiteArcheologiqueCRUD scd = new SiteArcheologiqueCRUD();
        ObservableList<SiteArcheologique> List = scd.afficherSiteArcheologique();

        IdColumn.setCellValueFactory(new PropertyValueFactory<SiteArcheologique, Integer>("idS"));
        NomColumn.setCellValueFactory(new PropertyValueFactory<SiteArcheologique, String>("nomS"));
        GouvColumn.setCellValueFactory(new PropertyValueFactory<SiteArcheologique, String>("gouvernoratS"));

        table.setItems(List);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        SiteArcheologique s = table.getSelectionModel().getSelectedItem();
        tfId.setText("" + s.getIdS());
        tfNom.setText(s.getNomS());
        tfGouvernorat.setText(s.getGouvernoratS());

    }

}
