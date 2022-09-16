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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class LoginGPController implements Initializable {

    @FXML
    private Button b1;
    @FXML
    private TextField tfuser;
    @FXML
    private PasswordField tfpasse;
    @FXML
    private CheckBox check;
 Stage dialogStage = new Stage();
    Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      
    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getCnx();

    @FXML
    private void LoginAction(ActionEvent event)  {
        
         String username =tfuser.getText();
        String password=tfpasse.getText();
       // String sql = "SELECT * FROM Propriete WHERE id = ? and passwordG = ?";
        
        if(username.equals("")&& password.equals("")){
            JOptionPane.showMessageDialog(null, "Please entrer username ande passeword");
        }
        else if(!(username.equals(""))&& password.equals("")){
            JOptionPane.showMessageDialog(null, "Please entrer passeword");
        }
         else if(username.equals("")&&!(password.equals(""))){
            JOptionPane.showMessageDialog(null, "Please entrer username");
        }
        else if(username.equals("guidepersonnalise") && password.equals("pass123"))
        {
      try {
//     
//       PreparedStatement pst = cnx.prepareStatement(sql);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if(!rs.next()){
//                
//            }else{
                 JOptionPane.showMessageDialog(null,"Login Successfull" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("AccueilGP.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
//            }
     
     } catch (Exception ex) {
            System.out.println(ex.getMessage());
     }
        }
        
        // if the username or password are incorrect
        else
        {
           JOptionPane.showMessageDialog(null,"Incorrect Username or Password");  
        }
        
    }
 
}
