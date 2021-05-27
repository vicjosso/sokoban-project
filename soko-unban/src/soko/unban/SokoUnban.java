package soko.unban;

import DataBaseRelated.DataBase;
import java.sql.SQLException;

/**
 * Classe de lancement en mode joueur
 * @author Victor Josso
 */
public class SokoUnban {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DataBase db = new DataBase();
            Appli.menu(db);
        } catch (SQLException e){
            System.err.println(e);
        }
        
    }
    
}
