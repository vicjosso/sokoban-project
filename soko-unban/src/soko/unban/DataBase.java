package soko.unban;

import java.sql.*;
import java.util.Scanner;

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
    public void createTable(){
        updateQuery("create table MAPS (map_ID int not null, name string not null);");
        updateQuery("create table ROWS (row_ID int not null, map_ID int not null, content string not null);");
    }
    
    /**
     * Renvoie un ID disponible pour la map
     * @return un ID disponible
     */
    public int getAvailableMap_ID(){ //fonctionnel tant que la map avec l'ID 1 n'est pas effacé
        int n = 1;
        try{
            String sql = "select map_ID from MAPS order by map_ID asc;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                int map_ID = result.getInt("map_ID");
                if(n != map_ID) {return n;}
                n++;
            }
            return n;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 101; //en case d'erreur
    }
    
    /**
     * Permet de rajouter un nouveau plateau de jeu
     * @param name, nom du plateau
     * @param rows, ensemble des lignes du plateau
     */
    public void addMap(String name, String[] rows){
        try{
            int n = getAvailableMap_ID();
            
            String sql = "insert into MAPS (map_ID, name) values (?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, n);
            statement.setString(2, name);
            statement.executeUpdate();
            
            for(int i =0; i<rows.length;i++){
                sql = "insert into ROWS (row_ID, map_ID, content) values (?,?,?);";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, i);
                statement.setInt(2, n);
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
            System.out.println("");
        } catch (SQLException e){
            System.out.println(e);
        }
          
    }
    
    /**
     * Permet d'effacer un plateau de jeu spécifique en fonction de son ID
     */
    public void deleteMap(){
        System.out.println("Indiquez l'ID de la map à effacer :");
        Scanner scanner = new Scanner(System.in);
        String ID = scanner.nextLine();
        updateQuery("delete from MAPS where map_ID = "+ ID +";");
        updateQuery("delete from ROWS where map_ID = "+ ID +";");
        System.out.println("");
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
