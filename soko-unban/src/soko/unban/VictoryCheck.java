package soko.unban;

/**
 *
 * @author vjosso
 */
public class VictoryCheck {
    
    /**
     * Vérifie si toutes les caisses sont bien sur leurs cibles
     * @param obj, tableau de case des cibles
     * @param board, tableau sur lequel on joue
     * @return vrai si toutes les cibles son recouverte de caisses
     */
    public static boolean check(Case[] obj, Board board){
        
        for (Case o : obj) {
            if (board.getCase(o.getRow(), o.getCol()) == Content.TARGET || board.getCase(o.getRow(), o.getCol()) == Content.PLAYER) {
                return false;
            }
        }
            
        return true;
    } 
}
