import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ca.mcmaster.se2aa4.mazerunner.Checks;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Movement;

public class Test_Checks 
{
    @Test
    public void testCheckForward()
    {
        char char_maze[][] = 
        {
            {'#', '#', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', '#', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };

        Maze maze = new Maze(char_maze);
        Movement move = new Movement(maze);
        Checks check = new Checks(maze, move);

        check.checkForward();
        boolean result = check.returnEmptySpaceForward();
        assertTrue(result); // checks if the space forward result is true meaning it passes

    }

    @Test
    public void testCheckRight()
    {
        char char_maze[][] = 
        {
            {'#', '#', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', '#', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };

        Maze maze = new Maze(char_maze);
        Movement move = new Movement(maze);
        Checks check = new Checks(maze, move);

        check.checkRight();
        boolean result = check.returnHoldingRight();
        assertTrue(result);
        //the first square to the right of the user should be a wall  meaning we are holding a wall and it should return true.
    }

    @Test
    public void testCheckExitReached()
    {
        char char_maze[][] = 
        {
            {'#', '#', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', ' ', ' ', '#', '#'},
            {'#', '#', '#', '#', '#', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };

        Maze maze = new Maze(char_maze);
        Movement move = new Movement(maze);
        Checks check = new Checks(maze, move);

        check.checkExitReached(move.updatedPosition());
        boolean result = check.returnAtExit();
        assertFalse(result);
       //position should not be at the exit as the player has not moved at all
    }
}
