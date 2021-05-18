package soko.unban;

import java.util.ArrayList;

/**
 *
 * @author Victor Josso
 */
public class Board {
    
    final private int rowNb;
    final private int colNb;
    
    private Case[][] board;
    
    public ArrayList<Case> targets = new ArrayList<Case>();
    
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
        
        //affichag de toutes les cases
        System.out.println("");
        for(int i = 1 ; i < this.rowNb + 1 ; i++) //à modifier
        {          
            for(int j = 1 ; j < this.colNb + 1 ; j++)
            {
                System.out.print(displayCase(i-1, j-1)+" ");
            }
            System.out.println("");
        }
        
    }
    
    /**
     * Affiche une case
     * @param row, la ligne
     * @param col, la colonne
     * @return, ce qui doit être affiché
     */
    private char displayCase(int row, int col){
        
        switch(this.getCase(row+1, col+1)){
            case WALL :
                return '#';
            case PLAYER :
                return 'P';
            case BOX :
                return 'C';
            case TARGET :
                return 'X';
            default :
                return '.';
        }  
    }
    
    /**
     * Dessine une ligne verticale d'une certaine longueur
     * @param start, le point de départ
     * @param length, la longueur de la ligne
     */
    public void drawVerticalWall(Case start, int length){
        
        for(int i = start.getRow(); i < start.getRow()+length; i++){
            if(i<=this.getNbRows()){this.setCase(i, start.getCol(), Content.WALL);}
            else{break;}
        }
    }
    
    /**
     * Dessine une ligne horizontale d'une certaine longueur
     * @param start, le point de départ
     * @param length, la longueur de la ligne
     */
    public void drawHorizontalWall(Case start, int length){
        
        for(int i = start.getCol(); i < start.getCol()+length; i++){
            if(i<=this.getNbCols()){this.setCase(start.getRow(), i, Content.WALL);}
            else{break;}
        }
    }
    
    /**
     * Rajoute une boîte
     * @param row, la ligne
     * @param col, la oclonne
     */
    public void addBox(int row, int col){
        if(row<this.rowNb+1 || col<this.colNb+1){this.setCase(row, col, Content.BOX);} else {/*rajouter exception*/}
    } 
    
    /**
     * Rajoute une cible
     * @param row, la ligne
     * @param col, la colonne
     */
    public void addTarget(int row, int col){
        if(row<this.rowNb+1 || col<this.colNb+1){this.setCase(row, col, Content.TARGET); this.targets.add(new Case(row, col));} else {/*rajouter exception*/}
    }
    
    /**
     * Rajoute un joueur
     * @param row, la ligne
     * @param col, la colonne 
     */
    public void addPlayer(int row, int col){
        if(row<this.rowNb+1 || col<this.colNb+1){this.setCase(row, col,  Content.PLAYER);} else {/*rajouter exception*/}
    }
}
