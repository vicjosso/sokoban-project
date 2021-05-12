package soko.unban;

import java.util.Scanner;

/**
 *
 * @author Victor Josso
 */
public class Game {
    
    static Scanner in = new Scanner(System.in);

        
    /**
     * Premier niveau du jeu soko-unban
     */
    public static void levelOne(){
        
        Movements movements = new Movements();
        
        boolean win = false;
        
        //initialisation board
        Board board = new Board(20, 20);
        Case start = new Case(2, 5);
        
        board.drawVerticalWall(start, 10);
        board.drawHorizontalWall(start, 4);
        board.addPlayer(15, 15);
        board.addBox(9, 9);
        board.addTarget(3, 3); //ajouter la target à une liste dés la création de la cible
       //
       
       //mise en place de la vérification de victoire
        int n = 0;
        
        Case[] obj = new Case[10];
        
        for(int i = 1; i <= board.getNbRows(); i++){
            for(int j = 1; j <= board.getNbCols(); j++){
                if(board.getCase(i, j) == Content.TARGET){ obj[n] = new Case(i, j); n++;} //aucune incrémentation de la case dans le tableau
            }
        }
        
        //test
        obj[0] = new Case(3, 3);
        
        //souci ecrasage mur
        while(!win){
            board.displayBoard();
            System.out.println("Veuillez annoncez votre déplacement :");
            String move = in.nextLine().trim();
            
            if(movements.movementValidation(move, board)){
                board = movements.movePlayer(move, board);
            } 
            
            //crash lorsque la caisse arrive sur la cible
            win = VictoryCheck.check(obj, board);
        }
        System.out.println("Félicitations! Vous avez gagné!");
        
    }
    
    
}
