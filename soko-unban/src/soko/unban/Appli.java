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
    static void menu(){
        
        boolean loop = true;
        
        while(loop){
            System.out.println("0) Quitter");
            System.out.println("1) Lancer le premier niveau");
            System.out.println("2) Lancer le deuxième niveau");
            System.out.println("3) Lancer le troisième niveau");
            System.out.println("4) Afficher les règles");
            String commande = in.nextLine().trim();
            switch (commande) {
                case "0":
                    System.out.println("-> Bye.");
                    loop = false;
                    break;
                case "1":
                    System.out.println("Lancement du premier niveau");
                    Game.levelOne();
                    break;
                case "2":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    break;
                case "3":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    break;
                case "4":
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
    
        boolean loop = true;
        
        while(loop){
            System.out.println("0 - Quitter");
            System.out.println("1 - Init base de données");
            System.out.println("2 - Montrer base de données");
            System.out.println("3 - Créer une nouvelles MAP");
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
                    System.out.println("Indiquez le nom de la futur map :");
                    db.addMap(scanner.nextLine(), new String[]{"########",
                                                                "#......#",
                                                                "#X..B.P#",
                                                                "########"}); //connecter lentrée a la sorti lecture fichier
                    break;
                case "4":
                    db.deleteMap(); 
                    break;
            }
        }
    }
    
}
