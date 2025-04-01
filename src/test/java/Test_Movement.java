import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Movement;

public class Test_Movement 
{
    @Test
    public void testMoveForward()
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

        int expected[] = {1,1};

        move.moveForward();
        int result[] = move.updatedPosition();

        boolean resultBool = Arrays.equals(expected,result);
        assertTrue(resultBool);
        //"moves forward, the expected result is it moves to [1,1]");
    }
    
    @Test
    public void testTurnLeft()
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

        int expected[] = {-1,0};

        move.turnLeft();
        int result[] = move.updateDirec();

        boolean resultBool = Arrays.equals(expected,result);
        assertTrue(resultBool);
        //turns left, north is the expected result which is [-1,0]
    }

    @Test
    public void testTurnRight()
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

        int expected[] = {1,0};

        move.turnRight();
        int result[] = move.updateDirec();

        boolean resultBool = Arrays.equals(expected,result);
        assertTrue(resultBool);
        //turn right from east is south, expected is [1,0]
    }
}
