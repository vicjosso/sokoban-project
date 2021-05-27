package soko.unban;

import Checks.VictoryCheck;
import Checks.Movements;
import BoardClasses.Board;
import DataBaseRelated.BoardBuilderFromDataBase;
import DataBaseRelated.DataBase;
import java.util.Scanner;

/**
 * Classe gérant le lancement du jeu
 * @author Victor Josso
 */
public class Game {
    
    static Scanner in = new Scanner(System.in);
    static BoardBuilderFromDataBase builder = new BoardBuilderFromDataBase();   
    
    /**
     * Lanceur de partie du jeu soko-unban
     */
    public static void level(DataBase db){
        
        Movements movements = new Movements();
        
        boolean win = false;
        
        System.out.println("Indiquez l'ID du niveau :");
        
        Board board = null;
        board = builder.writer(db, in.next());

        board.displayBoard();
        while(!win){
            
            System.out.println("Veuillez annoncez votre déplacement :");
            String move = in.next();
            
            if(move.equals("/quit")){ break;}
            
            String[] moves = move.split("|");
            
            for(int i = 0; i< moves.length; i++){
                if(movements.movementValidation(moves[i], board)){
                    board = movements.movePlayer(moves[i], board);
                }
            }
            
            win = VictoryCheck.check(board);
            
            board.displayBoard();
        }
        if(win){System.out.println("Félicitations! Vous avez gagné!");}
        System.out.println("");
        
    }
    
    
}
