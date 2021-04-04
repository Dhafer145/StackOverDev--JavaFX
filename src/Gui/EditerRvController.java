/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import tools.Myconn;
import entities.rendez_vous;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.rvCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dhiabenmabrouk
 */
public class EditerRvController implements Initializable {
    @FXML
    private TextField modifierLieu;
    @FXML
    private TextField modifierRaison;
    @FXML
    private DatePicker modifierDate;
    @FXML
    private Button validerMod;
    @FXML
    private Button annulerMod;
    int idrv;
    rendez_vous rv;
    private final Connection cnx;
    private PreparedStatement ste;
    public EditerRvController() {
        Myconn bd=Myconn.getInstance();
        cnx=bd.getConnection();
           }

    /**
     * Initializes the controller class.
     */
    ObservableList<rendez_vous> ListRV=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

                 }
    public void inflateUI(rendez_vous rv) {
         idrv=rv.getId_rv();
        modifierLieu.setText(rv.getLieu());
//        //profField.setText(m.getNomProf());
        modifierRaison.setText(rv.getRaison());
        modifierDate.setValue(LocalDate.parse(rv.getDate()));
        
//        //moduleField.setText(m.getNomModule());
    
        
    }

    @FXML
    private void ValiderMod(ActionEvent event) {
       try{
        String x = modifierDate.getValue().toString();
        rendez_vous rv = new rendez_vous();
        rv.setId_rv(idrv);
        rv.setDate(x);
        rv.setLieu(modifierLieu.getText());
        rv.setRaison(modifierRaison.getText());
      
        rvCRUD crd = new rvCRUD();
           System.out.println("idrv"+rv.getId_rv());
        crd.EditerRv(rv);
        }
        catch(RuntimeException ex)
        {
            
        }
           String title = "succes ";
        String message = "Rendez_vous modifié avec succes";
       Stage stage = (Stage) annulerMod.getScene().getWindow();
        stage.close();
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
    }

    @FXML
    private void AnnulerMod(MouseEvent event) {
        Stage stage = (Stage) annulerMod.getScene().getWindow();
        stage.close(); 
    }
}
