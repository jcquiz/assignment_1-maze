import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;

public class Test_Maze 
{

    @Test
    public void testFindEntrance()
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

        int expected[] = {1,0};
        int result[] = maze.findEntrance();
        boolean resultBool = Arrays.equals(expected,result);
        assertTrue(resultBool);
        // if true, means the expected array equals the result array
    }

    @Test
    public void testFindExit()
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

        int expected[] = {5,7};
        int result[] = maze.findExit();
        System.out.println(result[1]);

        boolean resultBool = Arrays.equals(expected,result);
        assertTrue(resultBool);
        // if true, entrance located at [5,7]
    }

}
