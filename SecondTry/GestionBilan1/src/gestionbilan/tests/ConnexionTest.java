package gestionbilan.tests;

import gestionbilan.entities.DebutStage;
import gestionbilan.services.DebutStageCRUD;
import gestionbilan.tools.MyConnection;
import java.sql.SQLException;

/**
 *
 * @author Fayechi
 */
public class ConnexionTest {

    public static void main(String[] args) throws SQLException {
        MyConnection mc= MyConnection.getInstance();
        DebutStageCRUD deb = new DebutStageCRUD();
        DebutStage b2 = new DebutStage(1, "motivation", "situation", "problematique", "apprentissages", "deadline", "talents", "Ex1", "Equipe", "Ex2", "Autonomie", "Ex3", "Resistance", "Ex4", "Organisation", "Ex5", "Initiative", "Ex6", "Qualite", "Ex7", "Contact", "Moyen");
        deb.remplirBilan((DebutStage)b2);
    }
    
}
