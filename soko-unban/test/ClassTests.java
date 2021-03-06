import static org.junit.Assert.assertEquals;
import org.junit.Test;
import soko.unban.Board;
import soko.unban.Case;
import soko.unban.Content;
import soko.unban.Movements;
import soko.unban.VictoryCheck;

/**
 *
 * @author Victor Josso
 */
public class ClassTests {
    
    @Test
    public void testBoard(){
        //board
        Board board = new Board(20, 20);
        Case start = new Case(2, 5);
        
        board.drawVerticalWall(start, 10);
        board.drawHorizontalWall(start, 4);
        board.addPlayer(1, 1);
        board.addBox(9, 9);
        board.addTarget(3, 3);
        
        board.displayBoard();
    }
    
    @Test
    public void testCase(){
        Case c = new Case(3, 1);
        c.setContent(Content.WALL);
        
        assertEquals(c.getContent(), Content.WALL);
        assertEquals(c.getRow(), 3);
        assertEquals(c.getCol(), 1);
    }
    
    @Test
    public void testVictoryCheck(){
        //board
        Board board = new Board(5, 5);
        board.addTarget(1, 1);
        
        assertEquals(false, VictoryCheck.check(board));
        
        board.addBox(1, 1);
        
        assertEquals(true, VictoryCheck.check(board));
        
    }
    
    @Test
    public void testMovements(){
        //test boxValidation
        Board board = new Board (5, 5);
        board.addBox(2, 1);
        board.addBox(3, 1);
        board.addBox(4, 1);
        board.addBox(2, 2);
        board.addPlayer(5, 5);
        
        board.displayBoard();
        
        Movements move = new Movements();
        assertEquals(true, move.movementValidation("U", board));
        
        board.setCase(5, 5, Content.EMPTY);
        board.addPlayer(1, 1);
        assertEquals(false, move.movementValidation("U", board));
    } 
    
}
