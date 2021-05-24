package soko.unban;

import java.sql.SQLException;

/**
 *
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
