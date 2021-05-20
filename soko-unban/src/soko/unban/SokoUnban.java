package soko.unban;

import java.sql.*;
/**
 *
 * @author Victor Josso
 */
public class SokoUnban {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Appli.menu();
    }
    
    
    /* //code a mettre dans admin et vérifier
    
    public static void main(String[] args){
        
        try {
            DataBase db = new DataBase();
    
            admin(db);
            }
    
        }catch(SQLException e){
            System.err.println(e);
        }
    
    }
    
    private static void admin(DataBase db){
    
        System.out.println("1 - Init base de données");
        System.out.println("2 - Montrer base de données");
        System.out.println("3 - Créer une nouvelles MAPS");
    
        Scanner scanner = new Scanner(System.in);
    
        switch(scanner.nextLine()){
            case "1":
                db.createTable();
                break;
            case "2":
                db.show();
                break;
            case "3":
                db.addMap....
            case "4":
                db.deleteMap(); 
                break;
        }
    }
    
    */
}
