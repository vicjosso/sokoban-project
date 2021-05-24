package soko.unban;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Appli {
    
    static Scanner in = new Scanner(System.in);
    
    /**
     * Affiche le menu de jeu et permet de lancer une partie
     */
    static void menu(DataBase db){
        
        boolean loop = true;
        
        while(loop){
            System.out.println("0) Quitter");
            System.out.println("1) Lancer un niveau");
            System.out.println("2) Afficher les règles");
            String commande = in.nextLine().trim();
            switch (commande) {
                case "0":
                    System.out.println("-> Bye.");
                    loop = false;
                    break;
                case "1":
                    db.showNames();
                    Game.level(db);
                    break;
                case "2":
                    Appli.rules();
                case "69":
                    System.out.println("UWU ceci est une fonctionnalité secrète UWU");
                    break;
                default:
                    System.out.println("-> commande inconnue '" + commande + "'");
            }
        }
    }
    
    /**
     * Affiche des règles de jeu
     */
    public static void rules(){
        System.out.println("");
        System.out.println("Les règles du jeu sont les suivantes :");
        System.out.println("    -vous devez vous déplacer à l'aide des touches, U, D, L et R");
        System.out.println("    -vous devez ensuite attendre la case B et la déplacer jusqu'à la case X, ce qui provoquera la victoire");
        System.out.println("");
    }
    
    /**
     * Méthode de gestion de l'interface amdinistrateur
     * @param db base de données utilisé
     */
    public static void admin(DataBase db){
    
        BoardBuilderFromFile builderFile = new BoardBuilderFromFile();
        
        boolean loop = true;
        
        while(loop){
            System.out.println("0 - Quitter");
            System.out.println("1 - Init base de données");
            System.out.println("2 - Montrer base de données");
            System.out.println("3 - Importer une nouvelles MAP");
            System.out.println("4 - Efface une MAP");

            Scanner scanner = new Scanner(System.in);

            switch(scanner.nextLine()){
                case "0":
                    loop = false;
                    break;
                case "1":
                    db.createTable();
                    break;
                case "2":
                    db.show();
                    break;
                case "3":
                    System.out.println("Indiquez le nom du fichier :");
                    /*
                    db.addMap(scanner.nextLine(), new String[]{"########",
                                                                "#......#",
                                                                "#X..B.P#",
                                                                "########"}); //connecter lentrée a la sorti lecture fichier
                    */
                    builderFile.reader(scanner.nextLine(), db); //non fonctionnel
                break;
                case "4":
                    db.deleteMap(); 
                    break;
            }
        }
    }
    
}
