/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import com.mysql.jdbc.integration.c3p0.MysqlConnectionTester;
import com.sun.javafx.tk.Toolkit;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.verstundesktop.entities.Propriete;
import edu.verstundesktop.services.ProprieteCRUD;
import edu.verstundesktop.tools.MyConnection;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Elife-Sil-030
 */
public class FirstProprieteController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfidP;
    @FXML
    private TextField tfnomP;
    @FXML
    private TextField tfgouvernoratP;
  
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;

    @FXML
    private TableView<Propriete> table;
    @FXML
    private TableColumn<Propriete, Integer> TidP;
    @FXML
    private TableColumn<Propriete, String> TnomP;
    @FXML
    private TableColumn<Propriete, String> TgouvernoratP;
    @FXML
    private TableColumn<Propriete, String> Tdate;
    @FXML
    private DatePicker tfdate;
   
    ObservableList<Propriete> myList = FXCollections.observableArrayList();
    int index=-1;
    @FXML
    private TableColumn<Propriete, Integer> TnbreChambre;
    @FXML
    private TextField tfnbreChambre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
afficherPropriete();
    }    

    @FXML
    private void ajouterPropriete(ActionEvent event) {
        int idP=Integer.parseInt(tfidP.getText());
       int nbreChambre=Integer.parseInt(tfnbreChambre.getText());
        String nomP= tfnomP.getText();
        String gouvernoratP= tfgouvernoratP.getText();
      String dateajout=tfdate.getEditor().getText().trim();
        Propriete p=new Propriete (idP,nomP,gouvernoratP,nbreChambre,dateajout);
        ProprieteCRUD pc =new ProprieteCRUD();
         if (event.getSource() == btnAjouter) {

            pc.AjouterPropriete(p); 
            afficherPropriete();
            JOptionPane.showMessageDialog(null, "Propriete ajoutée");
        }
    }

    @FXML
    private void modifierPropriete(ActionEvent event) {
        
        int idP=Integer.parseInt(tfidP.getText());
       int nbreChambre=Integer.parseInt(tfnbreChambre.getText());
        String nomP= tfnomP.getText();
        String gouvernoratP= tfgouvernoratP.getText();
      String dateajout=tfdate.getEditor().getText().trim();
        Propriete p=new Propriete (idP,nomP,gouvernoratP,nbreChambre,dateajout);
        ProprieteCRUD pc =new ProprieteCRUD();
      
        if (event.getSource() == btnModifier) {

            pc.ModifierPropriete(p, p.getIdP());
            afficherPropriete();
            JOptionPane.showMessageDialog(null, "Propriete modifié");
        }
       
         
        
    }

    @FXML
    private void supprimerPropriete(ActionEvent event) {
    
         int idP=Integer.parseInt(tfidP.getText());
         int nbreChambre=Integer.parseInt(tfnbreChambre.getText());
        String nomP= tfnomP.getText();
        String gouvernoratP= tfgouvernoratP.getText();
       String dateajout=tfdate.getEditor().getText().trim();
        
        Propriete p=new Propriete (idP,nomP,gouvernoratP,nbreChambre,dateajout);
        ProprieteCRUD pc =new ProprieteCRUD();
       
         
        ProprieteCRUD gcrud = new ProprieteCRUD();
        if (event.getSource() == btnSupprimer) {

             pc.SupprimerPropriete(p);
            afficherPropriete();
            JOptionPane.showMessageDialog(null, "Propriete supprimé");
        }
    }
     
     

    private void afficherPropriete() {
         ProprieteCRUD pc = new ProprieteCRUD();
        ObservableList<Propriete> myList = (ObservableList<Propriete>) pc.AfficherPropriete();
        
        TidP.setCellValueFactory(new PropertyValueFactory<Propriete, Integer>("idP"));
         TnbreChambre.setCellValueFactory(new PropertyValueFactory<Propriete, Integer>("nbreChambre"));
       TnomP.setCellValueFactory(new PropertyValueFactory<Propriete, String>("nomP"));
      TgouvernoratP.setCellValueFactory(new PropertyValueFactory<Propriete, String>("gouvernoratP"));
     Tdate.setCellValueFactory(new PropertyValueFactory<>("dateajout"));
     
      table.setItems(myList);
      
     table.setRowFactory(tv -> {
            TableRow<Propriete> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 & (!myRow.isEmpty())) {
                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    int idG = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdP()));
                    tfnomP.setText(table.getItems().get(myIndex).getNomP());
                    tfgouvernoratP.setText(table.getItems().get(myIndex).getGouvernoratP());
                    int nbreChambre = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getNbreChambre()));
                    

                }

            });

            return myRow;

        });

}

    @FXML
    private void getSelect(MouseEvent event) {
 index =table.getSelectionModel().getSelectedIndex();
if(index<=-1){ 
       return;  
    }
    
tfidP.setText(TidP.getCellData(index).toString());
tfnbreChambre.setText(TnbreChambre.getCellData(index).toString());
tfnomP.setText(TnomP.getCellData(index).toString());
 tfgouvernoratP.setText(TgouvernoratP.getCellData(index).toString());
//
//tfdate.setValue(Tdate.getCellData(index).toString());
//  


}


  

}
    