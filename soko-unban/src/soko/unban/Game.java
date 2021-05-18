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
        Board board = new Board(10, 10);
        Case start = new Case(2, 5);
        
        board.drawVerticalWall(start, 10);
        board.drawHorizontalWall(start, 4);
        board.addPlayer(10, 10);
        board.addBox(9, 9);
        board.addTarget(8, 8);
        //
        
        board.displayBoard();
        while(!win){
            
            System.out.println("Veuillez annoncez votre déplacement :");
            String move = in.nextLine().trim();
            
            if(movements.movementValidation(move, board)){
                board = movements.movePlayer(move, board);
            }
            
            //crash lorsque la caisse arrive sur la cible
            win = VictoryCheck.check(board);
            
            board.displayBoard();
        }
        System.out.println("Félicitations! Vous avez gagné!");
        
    }
    
    
}
