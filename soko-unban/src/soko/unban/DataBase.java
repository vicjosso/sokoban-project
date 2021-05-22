package soko.unban;

import java.sql.*;

/**
 *
 * @author Victor Josso
 */
public class DataBase {
    
    private static final String FILE_PATH = "Database.sqlite3"; // <- chemin d'accés au fichier .sqlite3
    private static final String URL = "jdbc:sqlite:" + FILE_PATH; 
    
    private final Connection connection;
    
    /**
     * Constructeur de la classe DataBase
     * @throws SQLException 
     */
    public DataBase() throws SQLException{
        chargerPilotes();
        this.connection = DriverManager.getConnection(URL);
    }
    
    /**
     * Charge le pilote sqlite
     */
    private static void chargerPilotes(){
        String sqlite_driver = "org.sqlite.JDBC";
        try{
            Class.forName(sqlite_driver);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
            System.exit(1);
        }
        
    }
    
    /**
     * Getteur de la connexion
     * @return la connexion actuelle
     */
    public Connection getConnection(){
        return this.connection;
    }
    
    /**
     * Initialise les deux tables sql nécessaire
     */
    public void createTable(){ // si bug, remettre try catch en place
        //String sql = "create table MAPS (map_ID int not null, name string not null);";
        //PreparedStatement stm = connection.prepareStatement(sql);
        //stm.executeUpdate();
        updateQuery("create table MAPS (map_ID int not null, name string not null);");
            
        //sql = "create table ROWS (row_ID int not null, map_ID int not null, content string not null);";
        //stm = connection.prepareStatement(sql);
        //stm.executeUpdate();
        updateQuery("create table ROWS (row_ID int not null, map_ID int not null, content string not null);");
    }
    
    /**
     * Renvoie un ID disponible pour la map
     * @return une ID disponible
     */
    public int getAvailableMap_ID(){
        //TODO Cherche dans ta table un id pas utilisé
        return 404;
    }
    
    /**
     * Permet de rajouter un nouveau plateau de jeu
     * @param name, nom du plateau
     * @param rows, ensemble des lignes du plateau
     */
    public void addMap(String name, String[] rows){
        try{
            String sql = "insert into MAPS (map_ID, name) values (?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 404);
            statement.setString(2, name);
            statement.executeUpdate();
            
            for(int i =0; i<rows.length;i++){
                sql = "insert into ROWS (row_ID, map_ID, content) values (?,?,?);";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, i);
                statement.setInt(2, getAvailableMap_ID());
                statement.setString(3, rows[i]);
                statement.executeUpdate();
            }
        } catch(SQLException e){
            System.out.println("e");
        }
            
    }
    
    /**
     * Affiche le contenu des deux tables MAPS et ROWS
     */
    public void show(){
        try{
            String sql = "select * from MAPS;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                int map_ID = result.getInt("map_ID");
                String name = result.getString("name");
                System.out.println(map_ID + " - " + name);
            }
            
            sql = "select * from ROWS;";
            stm = connection.prepareStatement(sql);
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
    
    /**
     * Permet d'effacer un plateau de jeu spécifique en fonction de son ID
     */
    public void delete(){
        //drop table if exists NOMTABLE
        //supprime l'ensemble de la table, modifie par delete from ... where ....
    }
    
    /**
     * Exécute l'update query
     * @param sql, trame sql voulu
     */
    public void updateQuery(String sql){
        try{
            PreparedStatement stm = this.connection.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
