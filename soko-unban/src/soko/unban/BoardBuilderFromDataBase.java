package soko.unban;

import java.sql.*;

/**
 *
 * @author Victor Josso
 */
public class BoardBuilderFromDataBase {
    
    //voir infos dans découpage entrée player
    
    
    public Board reader(String name, DataBase db){
        String[] map = new String[100];
        Board board = null;
        
        int i = 0;
        
        try{
            String sql = "select content from ROWS where map_ID="+ name +";"; //modifier pour faire en sorte que on demande le nom de la map a partir de MAP et non l'ID
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                map[i] = result.getString("content");
                i++;
            }
            board = writer(db, map);
        } catch (SQLException e){
            System.out.println(e);
        }
        
        return board;
    }
    
    
    public Board writer(DataBase db, String[] map){
        Board board = new Board(map[1].length(), map.length);
        
        for(int i = 1 ; i < board.getNbRows() ; i++){
            String[] contents = map[i-1].split("|"); //map est nul a un moment ce qui empeche le split, pb venant sans doute de la requete sql
            for(int j = 1 ; j < contents.length+1; j++){
                switch(contents[j-1]){
                    case "#":
                        board.setCase(i, j, Content.WALL);
                        break;
                    case "P":
                        board.addPlayer(j, j);
                        break;
                    case "B":
                        board.addBox(j, j);
                        break;
                    case "X":
                        board.addTarget(j, j);
                        break;
                    default:
                        board.setCase(j, j, Content.EMPTY);
                        break;
                }
            }
        }
        
        return board;
    }
}
