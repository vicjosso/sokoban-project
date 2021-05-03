package soko.unban;

/**
 *
 * @author Victor Josso
 */
public class Board {
    
    final private int rowNb;
    final private int colNb;
    
    private Case[][] board;
    
    /**
     * Constructeur de la classe Board
     * @param row, nombre totale de ligne
     * @param col, nombre totale de colonne
     */
    public Board(int row, int col){
        this.rowNb = row;
        this.colNb = col;
        this.board = new Case[rowNb][colNb];
        
        for(int i = 0 ; i < this.rowNb ; i++){
            for(int j = 0 ; j < this.colNb ; j++){
                this.board[i][j] = new Case(i, j);
            }
        }
    }
    
    /**
     * Retourne le nombre de la ligne
     * @return le nombre de ligne du tableau
     */
    public int getNbRows(){
        return this.rowNb;
    }
    
    /**
     * Retourne le nombre de la colonne
     * @return le nombre de colonne du tableau
     */
    public int getNbCols(){
        return this.colNb;
    }
     
    /**
     * Retourne la case en fonction de sa ligne et sa colonne
     * @param row, ligne de la case
     * @param col, colonne de la case
     * @return la case demander
     */
    public Content getCase(int row, int col){
        return this.board[row-1][col-1].getContent();
    }
            
    /**
     * Initialise la couleur d'une case
     * @param row, ligne de la case
     * @param col, colonne de la case
     * @param content, couleur voulu
     */
    public void setCase(int row, int col, Content content){ 
        this.board[row-1][col-1].setContent(content);
    }
    
    /**
     * Permet d'afficher le plateau de jeu
     */
    public void displayBoard(){
        
    }
}
