package soko.unban;

/**
 *
 * @author vjosso
 */
public class VictoryCheck {
    
    /**
     * Vérifie si toutes les caisses sont bien sur leurs cibles
     * @param board, tableau sur lequel on joue
     * @return vrai si toutes les cibles son recouverte de caisses
     */
    public static boolean check(Board board){
        
        for (Case o : board.targets) {
            if (board.getCase(o.getRow(), o.getCol()) == Content.TARGET 
                    || board.getCase(o.getRow(), o.getCol()) == Content.PLAYER 
                    || board.getCase(o.getRow(), o.getCol()) == Content.EMPTY) {
                if(board.getCase(o.getRow(), o.getCol()) == Content.EMPTY){ board.setCase(o.getRow(), o.getCol(), Content.TARGET);}
                return false;
            }
        }
            
        return true;
    } 
}
