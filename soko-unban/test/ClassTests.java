import static org.junit.Assert.assertEquals;
import org.junit.Test;
import soko.unban.Board;
import soko.unban.Case;
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
    public void testVictoryCheck(){
        //board
        Board board = new Board(5, 5);
        board.addTarget(1, 1);
        
        Case[] target = new Case[1];
        target[0] = new Case(1, 1);
        
        assertEquals(false, VictoryCheck.check(target, board));
        
        board.addBox(1, 1);
        
        assertEquals(true, VictoryCheck.check(target, board));
        
    }
}
