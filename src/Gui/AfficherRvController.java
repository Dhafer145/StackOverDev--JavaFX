/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import javafx.fxml.FXMLLoader;
import entities.rendez_vous;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.rvCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dhiabenmabrouk
 */
public class AfficherRvController implements Initializable {

    @FXML
    private Text afficher;
    @FXML
    private TableView<rendez_vous> tablerv;
    @FXML
    private TableColumn<rendez_vous , Integer> login;
     @FXML
    private TableColumn<rendez_vous , Integer> id;
    @FXML
    private TableColumn<rendez_vous, String> lieu;
    @FXML
    private TableColumn<rendez_vous, String> date;
    @FXML
    private TableColumn<rendez_vous, String> raison;
    @FXML
    private Button AjouterBtn;
    @FXML
    private TextField RechercherUser;
    
    Stage stage;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<rendez_vous> listrdv =  FXCollections.observableArrayList();
    rvCRUD RV = new rvCRUD();
    rendez_vous rdv = new rendez_vous();
    public List<rendez_vous> rendez_vous;

    
    @Override
    public void initialize(URL url, ResourceBundle rb){

        
        try {
            
            //listrdv = FXCollections.observableArrayList();
            listrdv = RV.readAllS();
        id.setCellValueFactory(new PropertyValueFactory<>("id_rv"));    
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        raison.setCellValueFactory(new PropertyValueFactory<>("raison"));
            
        tablerv.getItems().setAll(listrdv);
//           
    }   catch (SQLException ex) { 
            Logger.getLogger(AfficherRvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
     @FXML
    private void AddRdv(ActionEvent event) throws IOException, SQLException {
          Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("AjouterRv.fxml"));
            Stage stage = new Stage();
            stage.setTitle("ajout du rendez_vous");
            stage.setScene(new Scene(root));
            stage.show();
            loadData();
            stage.setOnHiding((e) -> {
                
                    
                try {
                    handleRefresh(new ActionEvent());
                    loadData();
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherRvController.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                    
            });
                    
            
            // Hide this current window (if this is what you want)
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    private void loadData() throws SQLException {
        listrdv.clear();
         try {
            
            //listrdv = FXCollections.observableArrayList();
            listrdv = RV.readAllS();
        id.setCellValueFactory(new PropertyValueFactory<>("id_rv"));    
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        raison.setCellValueFactory(new PropertyValueFactory<>("raison"));
            
        tablerv.getItems().setAll(listrdv);
//           
    }   catch (SQLException ex) { 
            Logger.getLogger(AfficherRvController.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
     }
    private void handleRefresh(ActionEvent event) throws SQLException {
        loadData();
        
    }
    @FXML
    private void UpdateRdv(ActionEvent event) throws IOException {
        rendez_vous selectedForEdit = tablerv.getSelectionModel().getSelectedItem();
        
       
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("EditerRv.fxml"));
            Parent parent = loader.load();

            EditerRvController controller = (EditerRvController) loader.getController();
            controller.inflateUI(selectedForEdit);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Editer matiere");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnHiding((e) -> {
                try {
                    handleRefresh(new ActionEvent());
                    loadData();
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger("gg").log(Level.SEVERE, null, ex);
                }
            });
            
            // Hide this current window (if this is what you want)
           // ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    //////
    @FXML
    private void SupprimerRdv(ActionEvent event) throws IOException, SQLException {
        rendez_vous selectedForDelete = tablerv.getSelectionModel().getSelectedItem();
        rvCRUD crd = new rvCRUD();
        crd.SupprimerRv(selectedForDelete.getId_rv());
       loadData();
                    handleRefresh(new ActionEvent());
                    loadData();
    
          String title = "succes ";
        String message = "Rendez_vous supprimé avec succes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
    }
    @FXML
    private void RechercherUsReleased(KeyEvent event) {
        try {
            rendez_vous = new rvCRUD().search(RechercherUser.getText());
            loadData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
      
        
}
