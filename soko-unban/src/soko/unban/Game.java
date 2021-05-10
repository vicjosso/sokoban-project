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
        
        Board board = new Board(20, 20);
        Case start = new Case(2, 5);
        
        board.drawVerticalWall(start, 10);
        board.drawHorizontalWall(start, 4);
        board.addPlayer(15, 15);
        board.addBox(9, 9);
        board.addTarget(3, 3);
        
        //souci de déplacement, bordure haute et droite plus ecrasage mur
        while(!win){
            board.displayBoard();
            System.out.println("Veuillez annoncez votre déplacement :");
            String move = in.nextLine().trim();
            
            if(movements.movementValidation(move, board)){
                board = movements.movePlayer(move, board);
            } 
        }
        System.out.println("Félicitations! Vous avez gagné!");
        
    }
    
    
}
