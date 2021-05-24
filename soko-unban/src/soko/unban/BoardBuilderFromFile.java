package soko.unban;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class BoardBuilderFromFile {
    
    final String FILE_PATH = "/src/lvl/";
    
    /**
     * Lecteur du fichier que l'on souhaite importer
     * @param fileName, du ficier
     * @param db, la base donnée
     */
    public void reader(String fileName, DataBase db){ //test impossible car message d'erreur d'emplacement fichier, toujours le meme peu importe le chemin écris
        int i = 0;
        String[] map = new String[100]; 
        try (Scanner scanner = new Scanner(new File(FILE_PATH + fileName +".txt"))) {
        //try (Scanner scanner = new Scanner(new File("/"+ name +".txt"))) {
            while (scanner.hasNextLine()) {
                map[i] = scanner.nextLine();
                i++;
            }
            writer(db, map);
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé : " + e);
        }
    }
    
    /**
     * Editeur de la base de donnée permettant dde rajouter la map importer
     * @param db, la base de donnée
     * @param map, map à importer
     */
    public void writer(DataBase db, String[] map){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entrez le nom de la futur map :");
        String name = in.nextLine();
        
        db.addMap(name, map);
    }
}
