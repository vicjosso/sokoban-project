package soko.unban;

/**
 *
 * @author Victor Josso
 */
public class Case {
    
    private final int row, col;
    Content content;
    
    /**
     * Constructeur de la classe Case
     * @param row, ligne de la case
     * @param col, colonne de la case
     */
    public Case(int row, int col){
        this.row = row;
        this.col = col;
        this.content = Content.EMPTY;
    }
    
    /**
     * Initialise un contenu pour une instance de la classe
     * @param content 
     */
    public void setContent(Content content){
        this.content = content;
    }
    
    /**
     * Permet d'obtenir le contenu de la case qui nous interesse 
     * @return le contenu de la case 
     */
    public Content getContent(){
        return this.content;
    }
    
    /**
     * Getteur permetant d'obtenir la ligne
     * @return le nombre de la ligne où se situe la case
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Getteur permettant d'obtenir la colonne
     * @return le nombre de colonne où se situe la case
     */
    public int getCol(){
        return this.col;
    }
}
