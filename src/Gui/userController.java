/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import tools.Myconn;
import entities.user;
import entities.Etudiant;
import java.io.IOException;
import javax.mail.Session;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;


/**
 *
 * @author ramzuss
 */
public class userController implements Initializable {

    @FXML
     private Button logout;
   
    @FXML
    public TextField tfuser;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpassword;
    
    @FXML
    private TextField tfconfirmp;
    @FXML
    private TextField tfadress;
       @FXML
    private DatePicker date;

    @FXML
    private TableView<user> tvea;
    @FXML
    private TableColumn<user, String> coluser;
    @FXML
    private TableColumn<user, String> colname;
    @FXML
    private TableColumn<user, String> colemail;
    @FXML
    private TableColumn<user, String> colpassword;
    @FXML
    private TableColumn<user, String> colrole;
    @FXML
    private TableColumn<Etudiant, String> coldate;
    @FXML
    private TableColumn<user, String> coladress;
   @FXML
    private ComboBox cbrole;
    
    
    @FXML
    private Button btnajout;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    
    @FXML
    private AnchorPane gestionea;
    

    
  
    @FXML
    private Button btnaccueil;
    
    
    
   
    
    
    
      
   
    
    
    @FXML
    public void ButtonAction(ActionEvent evn) throws Exception {
       if(evn.getSource() == btnajout)
       {ajout();
            
       }
       else if(evn.getSource() == btnsupprimer)
       {supprimer();}
       else if (evn.getSource() == btnmodifier)
       {     modifier();}
        
          }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> listcmb = FXCollections.observableArrayList("Etudiant","Encadrant Académique ","Encadrant Professionnel","responsable des stages");
         cbrole.setItems(listcmb);
        cbrole.getSelectionModel().select("etudiant");
         showUser();
         
         
    } 

      
   
    public userController() {
        Connection cnx = Myconn.getInstance().getConnection();
    }
    public ObservableList<user> getuserList(){
        ObservableList<user> userList = FXCollections.observableArrayList();
        Connection cnx = Myconn.getInstance().getConnection();
        String req = "select * from user";
        Statement st;
        ResultSet rs;
        
        try{
            st = cnx.createStatement();
            rs = st.executeQuery(req);
            user usr;
            Etudiant etu;
            while(rs.next()){
                usr = new user(rs.getString("user_name"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"),rs.getString("confirm_password"),rs.getString("role"),rs.getString("address")); // depuis bd //
                etu=new Etudiant(rs.getString("debut_stage"));
                userList.add(usr);
                
               
                
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return userList;
        
    }
    
     public void showUser(){
        ObservableList<user> list = getuserList();


        
        
         
coluser.setCellValueFactory(new PropertyValueFactory<user,String>("user_name"));
colname.setCellValueFactory(new PropertyValueFactory<user, String>("full_name"));
        colemail.setCellValueFactory(new PropertyValueFactory<user, String>("email"));
        colpassword.setCellValueFactory(new PropertyValueFactory<user, String>("password"));
        colrole.setCellValueFactory(new PropertyValueFactory<user, String>("role"));
       
        coladress.setCellValueFactory(new PropertyValueFactory<user, String>("adress"));
        
        coldate.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("debut_stage"));

        
         //classe user.java

        tvea.setItems(list);
       

    }
    public String cryptage(String password){
        String crypte="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            crypte=crypte+(char)c;
        }
        return crypte;
    }
     public static String decryptage(String password){
        String aCrypter="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            aCrypter=aCrypter+(char)c;
        }
        return aCrypter;
    }
    
    
      public static void sendMail(String recepient,String passwd) throws Exception {
        System.out.println("Preparing to send email");
        try{
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = recepient;
        //Your gmail password
        String password = passwd;

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);
        

        //Send mail
       Transport.send(message);
        System.out.println("Message sent successfully");
        }catch (MessagingException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

    public static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws SQLException {
      
        Connection cnx = Myconn.getInstance().getConnection();
     PreparedStatement pst = null;
     ResultSet rs = null;
    
        ObservableList<user> userList = FXCollections.observableArrayList();
       
        String req = "select (user_name),(email),(confirm_password) from user where email=?";
        Statement st;
        
       
        try{
            pst = cnx.prepareStatement(req);
            pst.setString(1,myAccountEmail);
            rs = pst.executeQuery();
            user usr;
            while(rs.next()){
                usr = new user(rs.getString("user_name"),rs.getString("email"),rs.getString("confirm_password")); // depuis bd //
                
                usr.setPassword(decryptage(rs.getString("confirm_password")));
                userList.add(usr);
                
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress() );
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("information des comptes");
           
          
ObservableList<String> userL = FXCollections.observableArrayList();             
         
 userList.stream()
.forEach(( user e)->userL.addAll(e.getPassword()));


 

          
            message.setText("Bonjour "+"\n"+userL);
           
          
            
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
    }
    
    
     private void ajout(){
        Connection connection =Myconn.getInstance().getConnection();
        PreparedStatement stm;
        try{
            
            
            String s = cbrole.getSelectionModel().getSelectedItem().toString();
            stm = connection.prepareStatement("insert into user(user_name,full_name,email,password,confirm_password,role,address,debut_stage) values(?,?,?,?,?,?,?,?)");
            
             if  ((!(tfuser.getText().matches("^[a-zA-Z]+$")))||(tfuser.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "verifier le nom de user");
             }
             else if(!(tfname.getText().matches("^[a-zA-Z]+$"))) {

            JOptionPane.showMessageDialog(null, "verifier le nom complet");
             }
              
             else if  (tfpassword.getText().length()<8) {

            JOptionPane.showMessageDialog(null, "verifier le password");
             }
              else if  (!(tfpassword.getText().equalsIgnoreCase(tfconfirmp.getText()))) {

            JOptionPane.showMessageDialog(null, "verifier la confirmation du password");
             }
              else if (!(tfpassword.getText().matches("^[A-Z a-z 0-9]+$")))
              JOptionPane.showMessageDialog(null, "verifier votre adresse");
             else{
            stm.setString(1, tfuser.getText());
            stm.setString(2, tfname.getText());
            stm.setString(3, tfemail.getText());
            stm.setString(4,  cryptage(tfpassword.getText()) );
            stm.setString(5, cryptage(tfconfirmp.getText()));
            stm.setString(6,s);
            stm.setString(7, tfadress.getText());
            String da=date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            stm.setString(8,da);
int i = stm.executeUpdate();
            System.out.println(i);
            sendMail(tfemail.getText(),tfpassword.getText());
            Notifications ntf=Notifications.create().title("succes").text("mail envoyé avec succes")
    .hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_LEFT);
   //.graphic(new ImageView(tick))
    //ntf.darkStyle();
    ntf.show();
             }

            
            

        }catch (Exception e){
            e.printStackTrace();
        }
        showUser();
       
    }
        
        void select(ActionEvent event) {
String s = cbrole.getSelectionModel().getSelectedItem().toString();
       
    } 
        
      private void supprimer() {
        Connection connection = Myconn.getInstance().getConnection();
        PreparedStatement stmt;

       try {
           stmt=connection.prepareStatement("delete from user where user_name=?");
           stmt.setString(1,(tfuser.getText()));

           int i=stmt.executeUpdate();
           
       }catch (Exception e){
           e.printStackTrace();
       }
       showUser();
    }
        
        
        private void modifier() {
        Connection connection = Myconn.getInstance().getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("UPDATE user SET full_name=?, email=?,  role=?, address=?,debut_stage=? WHERE user_name=?");
            
            stmt.setString(6, (tfuser.getText()));
            
              
           
            stmt.setString(1, tfname.getText());
            stmt.setString(2, tfemail.getText());
           
            stmt.setString(3,cbrole.getSelectionModel().getSelectedItem().toString());
            stmt.setString(4, tfadress.getText());
            
            String da=date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            stmt.setString(5,da);
            


              int i = stmt.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
        showUser();
    }

   
    @FXML
    public void Action(MouseEvent event) {
    user u=tvea.getSelectionModel().getSelectedItem();
    tfuser.setText(""+u.getUser_name());
    tfname.setText(""+u.getFull_name());
    tfemail.setText(""+u.getEmail());
   
   cbrole.getSelectionModel().select(""+u.getRole());
   
   
    
    tfadress.setText(""+u.getAdress());
    //date.se;
    
   
    }
    
    @FXML
    public void logout() throws IOException{
    
     logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    PreparedStatement pst = null;
     ResultSet rs = null;
    @FXML
     public void Accueil () throws Exception{  
          
    Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where id_user = ?  ";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1,LoginController.logged+"");
           
            
          
           
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
               
            String role =rs.getString(7);
                if(role.equals("responsable des stages"))
                {     
                    System.out.println("hahaha");
             String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("accueilResponsable.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        AccueilResponsableController acc=loader.getController();
        acc.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

               
            }  
                 if(role.equals("Etudiant"))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Accueil_etudiant.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Accueil_etudiantController acc=loader.getController();
        acc.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
            if(role.equals("Encadrant Académique "))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Accueil_encadrant.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Accueil_encadrantController aea=loader.getController();
        aea.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
                 
            } 
          
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }
    

   
       
}
    

