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
            String commande = in.nextLine().trim();
            switch (commande) {
                case "0":
                    System.out.println("-> Bye.");
                    loop = false;
                    break;
                case "1":
                    System.out.println("Lancement du premier niveau");
                    levelOne();
                    break;
                case "2":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    break;
                case "3":
                    System.out.println("-> Fonctionnalité non-implémanté");
                    
                    break;
                case "69":
                    System.out.println("UWU ceci est une fonctionnalité secrète UWU");
                    break;
                default:
                    System.out.println("-> commande inconnue '" + commande + "'");
            }
        }
    }
    
    /**
     * Premier niveau du jeu soko-unban
     */
    static public void levelOne(){
        
    }
    
}
