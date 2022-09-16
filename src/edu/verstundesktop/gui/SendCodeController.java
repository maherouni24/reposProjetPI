/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.verstundesktop.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author meher
 */
public class SendCodeController implements Initializable {

    int randomCode;

    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EnvoyerEmail(MouseEvent event) {
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "tsnemailsndr@gmail.com";
            String pass = "vQ#Tgez@=KRFM2E4";
            String to = tfMail.getText();
            String subject = "Reseting Code";
            String message = "Your reset code is" + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls", "true");
            pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "code has been send to the email");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @FXML
    private void VerifierCode(MouseEvent event) {

        if (Integer.valueOf(tfCode.getText()) == randomCode) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetCode.fxml"));
            try {
                Parent root = loader.load();
                ResetCodeController rcc = loader.getController();

                tfMail.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }else{
        JOptionPane.showMessageDialog(null,"verifier votre code");
        }

    }

}
