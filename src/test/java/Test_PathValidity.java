import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.PathValidity;

public class Test_PathValidity
{
    @Test
    public void testValidityCorrect()
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
        PathValidity valid_test = new PathValidity(maze);


        String path = "FRFFLFFFFRFFLFF";
        boolean result = valid_test.pathValid(path);
        assertTrue(result);
        //checks the string to see if it can validly pass the maze, should return true
    }

    @Test
    public void testValidityIncorrect()
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
        PathValidity valid_test = new PathValidity(maze);

        String path = "FRFRFFF";
        boolean result = valid_test.pathValid(path);
        assertFalse(result);
        //checks the string to see if it can fail the maze, should return false
    }
}