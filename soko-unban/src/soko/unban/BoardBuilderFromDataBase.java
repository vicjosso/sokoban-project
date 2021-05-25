package soko.unban;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Victor Josso
 */
public class BoardBuilderFromDataBase {
    
    /**
     * Lecteur de la base de données
     * @param name, nom la map
     * @param db, base de données
     * @return 
     */
    public Board reader(String name, DataBase db){
        ArrayList<String> map = new ArrayList<String>();
        Board board = null;
        
        
        try{
            String sql = "select content from ROWS where map_ID="+ name +";"; //modifier pour faire en sorte que on demande le nom de la map a partir de MAP et non l'ID
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                map.add(result.getString("content"));
            }
            board = writer(db, Arrays.copyOf(map.toArray(),  map.size(), String[].class));
        } catch (SQLException e){
            System.out.println(e);
        }
        
        return board;
    }
    
    /**
     * Créateur du plateau de jeu
     * @param db, base de données
     * @param map, map a importer
     * @return 
     */
    public Board writer(DataBase db, String[] map){
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
