package soko.unban;

/**
 *
 * @author vjosso
 */
public class Movements {
    
    /**
     * Vérifie la validité de deplacement du jeu 
     * @param dep, choix de direction de déplacement
     * @param board, plateau de jeu
     * @return true si le placemetnt est valide sinon false
     */
    public boolean movementValidation(char dep, Board board){
        
        switch (dep){
            case 'U':
                break;
            case 'D':
                break;
            case 'L':
                break;
            case 'R':
                break;
            default:
                System.out.println("Commande " + dep + "inconnue");
                return false;
        }
        
        return false;
    }
}
