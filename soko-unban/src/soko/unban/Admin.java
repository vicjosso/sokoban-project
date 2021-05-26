package soko.unban;
import soko.unban.Appli; //rajouter package

import java.sql.*;

/**
 * Classe de lancement du programme en mode admin
 * @author Victor Josso
 */
public class Admin {
    
    public static void main(String[] args){
        
        try {
            DataBase db = new DataBase();
    
            Appli.admin(db);
            
        }catch(SQLException e){
            System.err.println(e);
        }
    
    }
}
