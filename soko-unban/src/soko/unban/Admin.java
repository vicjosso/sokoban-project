package soko.unban;

import java.sql.*;

/**
 *
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
