package soko.unban;

import java.io.*;
import java.util.*;

/**
 * Classe permettant d'importer un nouvelle map dans la base de données à partir d'un fichier
 * @author Victor Josso
 */
public class BoardBuilderFromFile {
    
    final String FILE_PATH = "src\\lvl\\";
    
    /**
     * Lecteur du fichier que l'on souhaite importer
     * @param fileName, du ficier
     * @param db, la base donnée
     */
    public void reader(String fileName, DataBase db){ 
        
        ArrayList<String> map = new ArrayList<String>();
        
        try (Scanner scanner = new Scanner(new File(FILE_PATH + fileName +".txt"))) {
            while (scanner.hasNextLine()) {
                map.add(scanner.nextLine());
            }
            writer(db, Arrays.copyOf(map.toArray(),  map.size(), String[].class));
        } catch (FileNotFoundException e) {
            System.err.println("Fichier non trouvé : " + e);
        } 
    }
    
    /**
     * Editeur de la base de donnée permettant dde rajouter la map importer
     * @param db, la base de donnée
     * @param map, map à importer
     */
    private void writer(DataBase db, String[] map){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entrez le nom de la futur map :");
        String name = in.nextLine();
        
        db.addMap(name, map);
    }
}
