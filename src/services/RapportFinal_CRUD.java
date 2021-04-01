
package services;

import Entite.RapportFinal;
import tools.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
    
/**
 *
 * @author Fayechi
 */
public class RapportFinal_CRUD {
    private Connection cnx;
    private PreparedStatement ste;

    public RapportFinal_CRUD() {
        cnx = myconnection.getInstance().getConnection();
    }
    
    public void ajouterRapportFinal(RapportFinal Rf){
        String req ="INSERT INTO rapport_final  (plagiat) values (?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setString(1 , Rf.getPlagiat());
            ste.executeUpdate();
            System.out.println("Plagiat ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }

    public void ajouterPlagiat(RapportFinal rf2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}