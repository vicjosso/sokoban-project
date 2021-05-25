package soko.unban;

/**
 * Classe permettant de gérer les déplacements du joueur et des caisse sur le plateau
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
                    switch(board.getCase(player.getRow()-1, player.getCol())){
                        case EMPTY:
                        case TARGET:
                            return true;
                        case BOX:
                            return boxValidation(board, player, dir, 1);
                        default:
                            return false;
                    }
                } else {return false;}
            case "D":
                if(player.getRow()+1 <= board.getNbRows()){
                    switch(board.getCase(player.getRow()+1, player.getCol())){
                        case EMPTY:
                        case TARGET:
                            return true;
                        case BOX:
                            return boxValidation(board, player, dir, 1);
                        default:
                            return false;
                    }
                } else {return false;}
            case "L": 
                if(player.getCol()-1 > 0){
                    switch(board.getCase(player.getRow(), player.getCol()-1)){
                        case EMPTY:
                        case TARGET:
                            return true;
                        case BOX:
                            return boxValidation(board, player, dir, 1);
                        default:
                            return false;
                    } 
                } else {return false;}
            case "R": 
                if(player.getCol()+1 <= board.getNbCols()){
                    switch(board.getCase(player.getRow(), player.getCol()+1)){
                        case EMPTY:
                        case TARGET:
                            return true;
                        case BOX:
                            return boxValidation(board, player, dir, 1);
                        default:
                            return false;
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
        
        int n = 1;
        
        Case player = new Case(0,0);
        
        for(int i = 1; i <= board.getNbRows(); i++){
            for(int j = 1; j <= board.getNbCols(); j++){
                if(board.getCase(i, j) == Content.PLAYER){ player = new Case(i, j);}
            }
        }
        
        switch (dir){
            case "U":
                while(board.getCase(player.getRow()-n, player.getCol()) == Content.BOX){n++;}
                for(int j = 2; j<=n;j++){board.setCase(player.getRow()-j, player.getCol(), Content.BOX);}
                
                board.setCase(player.getRow()-1, player.getCol(), Content.PLAYER);
                board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "D":
                while(board.getCase(player.getRow()+n, player.getCol()) == Content.BOX){n++;}
                for(int j = 2; j<=n;j++){board.setCase(player.getRow()+j, player.getCol(), Content.BOX);}
                
                board.setCase(player.getRow()+1, player.getCol(), Content.PLAYER);
                board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "L":
                while(board.getCase(player.getRow(), player.getCol()-n) == Content.BOX){n++;}
                for(int j = 2; j<=n;j++){board.setCase(player.getRow(), player.getCol()-j, Content.BOX);}
                
                board.setCase(player.getRow(), player.getCol()-1, Content.PLAYER);
                board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
            case "R":
                while(board.getCase(player.getRow(), player.getCol()+n) == Content.BOX){n++;}
                for(int j = 2; j<=n;j++){board.setCase(player.getRow(), player.getCol()+j, Content.BOX);}
                
                board.setCase(player.getRow(), player.getCol()+1, Content.PLAYER);
                board.setCase(player.getRow(), player.getCol(), Content.EMPTY);
                break;
        }
        
        return board; 
    }
    
    /**
     * Vérifie si le mouvement d'une série de boîte est possible
     * @param board, plateau de jeu
     * @param player, placement du joueur
     * @param dir, direction voulu
     * @param offset, nombre de boîte par rapport au joueur
     * @return true si le déplacement est possible sinon false
     */
    public boolean boxValidation(Board board, Case player, String dir, int offset){
        
        switch (dir){
            case "U":
                if(player.getRow()-offset > 0){
                    switch (board.getCase(player.getRow()-offset, player.getCol())){
                        case BOX:
                            return boxValidation(board, player, dir, offset+1);
                        case EMPTY:
                        case TARGET:
                            return true;
                        default:
                            return false;
                    }
                } else { return false; }
            case "D":
                if(player.getRow()+offset <= board.getNbRows()){
                    switch (board.getCase(player.getRow()+offset, player.getCol())){
                        case BOX:
                            return boxValidation(board, player, dir, offset+1);
                        case EMPTY:
                        case TARGET:
                            return true;
                        default:
                            return false;
                    }
                } else { return false; }
            case "L":
                if(player.getCol()-offset > 0){
                    switch (board.getCase(player.getRow(), player.getCol()-offset)){
                        case BOX:
                            return boxValidation(board, player, dir, offset+1);
                        case EMPTY:
                        case TARGET:
                            return true;
                        default:
                            return false;
                    }
                } else { return false; }
            case "R":
                if(player.getCol()+offset <= board.getNbCols()){
                    switch (board.getCase(player.getRow(), player.getCol()+offset)){
                        case BOX:
                            return boxValidation(board, player, dir, offset+1);
                        case EMPTY:
                        case TARGET:
                            return true;
                        default:
                            return false;
                    }
                } else { return false; }
        }
        return false;
    }
    
}
