package soko.unban;

import java.sql.*;

/**
 *
 * @author Victor Josso
 */
public class DataBase {
    
    private static final String FILE_PATH = "Database.sqlite3"; // <- chemin d'accés au fichier .sqlite3
    private static final String URL = "jdbc:sqlite:" + FILE_PATH; 
    
    private final Connection patate; //a changer
    
    public DataBase() throws SQLException{
        chargerPilotes();
        this.patate = DriverManager.getConnection(URL);
    }
    
    private static void chargerPilotes(){
        String sqlite_driver = "org.sqlite.JDBC";
        try{
            Class.forName(sqlite_driver);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            System.exit(1);
        }
        
    }
    
    public Connection getConnection(){
        return this.patate;
    }
    
    public void createTable(){
        try{
            String sql = "create table MAPS (map_ID int not null, name string not null);";
            PreparedStatement stm = patate.prepareStatement(sql);
            stm.executeUpdate();
            
            sql = "create table ROWS (row_ID int not null, map_ID int not null, content string not null);";
            stm = patate.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException e){
            System.err.println(e);
        }
    }
    
    public int getAvailableMap_ID(){
        //TODO Cherche dans ta table un id pas utilisé
        return 404;
    }
    
    public void addMap(String name, String[] rows){
        try{
            String sql = "insert into MAPS (map_ID, name) values (?,?);";
            PreparedStatement statement = patate.prepareStatement(sql);
            statement.setInt(1, 404);
            statement.setString(2, name);
            statement.executeUpdate();
            
            for(int i =0; i<rows.length;i++){
                sql = "insert into ROWS (row_ID, map_ID, content) values (?,?,?);";
                statement = patate.prepareStatement(sql);
                statement.setInt(1, i);
                statement.setInt(2, getAvailableMap_ID());
                statement.setString(3, rows[i]);
                statement.executeUpdate();
            }
        } catch(SQLException e){
            System.out.println("e");
        }
            
    }
    
    public void show(){
        //recup tous les elements de MAPS
        //recup tous les elements de ROWS
        //les affichers
        try{
            String sql = "select * from MAPS;";
            PreparedStatement stm = patate.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                int map_ID =result.getInt("map_ID");
                String name = result.getString("name");
                System.out.println(map_ID + " - " + name);
            }
            
            sql = "select * from ROWS;";
            stm = patate.prepareStatement(sql);
            result = stm.executeQuery();
            while(result.next()){
                int row_ID = result.getInt("row_ID");
                int map_ID = result.getInt("map_ID");
                String content = result.getString("content");
                System.out.println( row_ID + " - " + map_ID + " - " + content );
            }
        } catch (SQLException e){
            System.out.println(e);
        }
          
    }
    
    public void delete(){
        //drop table if exists NOMTABLE
        //supprime l'ensemble de la table, modifie par delete from ... where ....
    }
    
    public void updateQuery(String sql){
        //pour opti les requetes de query
    }
    
}
