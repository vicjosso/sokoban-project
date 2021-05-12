package soko.unban;

/**
 *
 * @author vjosso
 */
public class Movements {
    
    /**
     * Vérifie la validité de deplacement du jeu 
     * @param dir, choix de direction de déplacement
     * @param board, plateau de jeu
     * @return true si le placemetnt est valide sinon false
     */
    public boolean movementValidation(String dir, Board board){
        
        boolean playerFound = false;
        Case player = new Case(0,0);
        
        for(int i = 1; i <= board.getNbRows(); i++){
            for(int j = 1; j <= board.getNbCols(); j++){
                if(board.getCase(i, j) == Content.PLAYER){ player = new Case(i, j); playerFound = true;}
            }
        }
        
        if(!playerFound){System.out.println("Aucun joueur sur le plateau"); return false;}
        
        switch (dir){
            case "U":
                if(player.getRow()-1 > 0){
                    if(board.getCase(player.getRow()-1, player.getCol()) == Content.EMPTY) { return true; }
                    else if(player.getRow()-2 >= 0 && board.getCase(player.getRow()-1, player.getCol()) == Content.BOX){
                        if(board.getCase(player.getRow()-2, player.getCol()) == Content.EMPTY){ return true;}
                    } else {return false;}
                }
                else {return false;}
            case "D":
                if(player.getRow()+1 <= board.getNbRows()){
                    if(board.getCase(player.getRow()+1, player.getCol()) == Content.EMPTY) { return true; }
                    else if(player.getRow()+2 <= board.getNbRows() && board.getCase(player.getRow()+1, player.getCol()) == Content.BOX){
                        if(board.getCase(player.getRow()+2, player.getCol()) == Content.EMPTY){ return true;}
                    } else {return false;}
                }
                else {return false;}
            case "L": //passage a travers le mur
                if(player.getCol()-1 > 0){
                    if(board.getCase(player.getRow(), player.getCol()-1) == Content.EMPTY) { return true; }
                    else if(player.getCol()-2 >= 0 && board.getCase(player.getRow(), player.getCol()-1) == Content.BOX){
                        if(board.getCase(player.getRow(), player.getCol()-2) == Content.EMPTY){ return true;}
                    }
                } else {return false;}
            case "R": //commance inconnue lors de la collision avec un mur
                if(player.getCol()+1 <= board.getNbCols()){
                    if(board.getCase(player.getRow(),player.getCol()+1) == Content.EMPTY) { return true; }
                    else if(player.getCol()+2 <= board.getNbCols() && board.getCase(player.getRow(), player.getCol()+1) == Content.BOX){
                        if(board.getCase(player.getRow(), player.getCol()+2) == Content.EMPTY){ return true;}
                    }
                } else {return false;}
            default:
                System.out.println("Commande " + dir + " inconnue");
                return false;
        }
    }
    
    /**
     * Déplace le joueur en fonction d'une direction donnée
     * @param dir, direction du déplacement
     * @param board, plateau sur lequel on joue
     * @return le nouveau board 
     */
    public Board movePlayer(String dir, Board board){
        
        Case player = new Case(0,0);
        
        for(int i = 1; i <= board.getNbRows(); i++){
            for(int j = 1; j <= board.getNbCols(); j++){
                if(board.getCase(i, j) == Content.PLAYER){ player = new Case(i, j);}
            }
        }
        
        switch (dir){
            case "U":
                if(board.getCase(player.getRow()-1, player.getCol()) == Content.BOX){ 
                    board.setCase(player.getRow()-2, player.getCol(), Content.BOX);
                    board.setCase(player.getRow()-1, player.getCol(), Content.EMPTY);
                }
                board.setCase(player.getRow()-1, player.getCol(), Content.PLAYER);
                    board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "D":
                if(board.getCase(player.getRow()+1, player.getCol()) == Content.BOX){ 
                    board.setCase(player.getRow()+2, player.getCol(), Content.BOX);
                    board.setCase(player.getRow()+1, player.getCol(), Content.EMPTY);
                }
                board.setCase(player.getRow()+1, player.getCol(), Content.PLAYER);
                    board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "L":
                if(board.getCase(player.getRow(), player.getCol()-1) == Content.BOX){ 
                    board.setCase(player.getRow(), player.getCol()-2, Content.BOX);
                    board.setCase(player.getRow(), player.getCol()-1, Content.EMPTY);
                }
                board.setCase(player.getRow(), player.getCol()-1, Content.PLAYER);
                    board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "R":
                if(board.getCase(player.getRow(), player.getCol()+1) == Content.BOX){ 
                    board.setCase(player.getRow(), player.getCol()+2, Content.BOX);
                    board.setCase(player.getRow(), player.getCol()+1, Content.EMPTY);
                }
                board.setCase(player.getRow(), player.getCol()+1, Content.PLAYER);
                    board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
        }
        
        return board;
    }
    
}
