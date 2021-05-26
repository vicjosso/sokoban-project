package soko.unban;

import java.sql.*;
import java.util.*;

/**
 * Classe qui permet de charger un fichier provenant de la base de données
 * @author Victor Josso
 */
public class BoardBuilderFromDataBase {
    
    /**
     * Lecteur de la base de données
     * @param name, nom la map
     * @param db, base de données
     * @return 
     */
    private String[] reader(String name, DataBase db){
        
        ArrayList<String> map = new ArrayList<String>();
        
        try{
            String sql = "select content from ROWS where map_ID="+ name +";"; 
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                map.add(result.getString("content"));
            }
            if(result.getString("content") != null){return Arrays.copyOf(map.toArray(),  map.size(), String[].class);}
        } catch (SQLException e){
            System.err.println(e);
        }
        
        return new String[] {"erreur"};
    }
    
    /**
     * Créateur du plateau de jeu
     * @param db, la base de données
     * @param name, nom de la map voulu
     * @return le plateau de jeu
     */
    public Board writer(DataBase db, String name){
        
        String[] map = this.reader(name, db);
        Board board = new Board(map.length, map[0].length());
        
        for(int i = 1 ; i < board.getNbRows()+1 ; i++){
            String[] contents = map[i-1].split("|"); 
            for(int j = 1 ; j < contents.length+1; j++){
                switch(contents[j-1]){
                    case "#":
                        board.setCase(i, j, Content.WALL);
                        break;
                    case "P":
                        board.addPlayer(i, j);
                        break;
                    case "B":
                        board.addBox(i, j);
                        break;
                    case "X":
                        board.addTarget(i, j);
                        break;
                    default:
                        board.setCase(i, j, Content.EMPTY);
                        break;
                }
            }
        }
        
        return board;
    }
}
