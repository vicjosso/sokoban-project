package soko.unban;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class BoardBuilderFromFile implements BoardBuilder {
    
    @Override
    public void reader(String name, DataBase db){ //test impossible car message d'erreur d'emplacement fichier, toujours le meme peu importe le chemin écris
        int i = 0;
        String[] map = null;
        try (Scanner scanner = new Scanner(new File("/src/lvl/"+ name +".txt"))) {
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
    
    @Override
    public void writer(DataBase db, String[] map){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Entrez le nom de la futur map :");
        String name = in.nextLine();
        
        db.addMap(name, map);
    }
}
