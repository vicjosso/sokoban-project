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
    public static void level(){
        
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
            String move = in.next();
            String[] moves = move.split("|");
            
            for(int i = 0; i< moves.length; i++){
                if(movements.movementValidation(moves[i], board)){
                    board = movements.movePlayer(moves[i], board);
                }
            }
            
            win = VictoryCheck.check(board);
            
            board.displayBoard();
        }
        System.out.println("Félicitations! Vous avez gagné!");
        
    }
    
    
}
