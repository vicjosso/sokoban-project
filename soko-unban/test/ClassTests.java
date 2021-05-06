import org.junit.Test;
import soko.unban.Board;
import soko.unban.Case;

/**
 *
 * @author Victor Josso
 */
public class ClassTests {
    
    @Test
    public void testBoard(){
        //board
        Board board = new Board(9, 9);
        Case start = new Case(2, 5);
        
        board.drawVerticalWall(start, 10);
        board.drawHorizontalWall(start, 4);
        board.addPlayer(1, 1);
        board.addBox(10, 9);
        board.addTarget(3, 3);
        
        board.displayBoard();
    }
}
