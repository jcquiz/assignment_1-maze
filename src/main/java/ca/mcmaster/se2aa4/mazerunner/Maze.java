package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze 
{
    private static final Logger logger = LogManager.getLogger();
    private char mazeGrid[][];

    public Maze(char[][] maze)
    {
        this.mazeGrid = maze;
    }

    public boolean wallOnRight(int row, int col)
    {
        if (mazeGrid[row][col] == '#') return true;
        else return false;
    }

    public boolean wallInFront(int row, int col)
    {
        if (mazeGrid[row][col] == ' ') return true;
        else return false;
    }

    // redundant (visual for user !)
    public void changeMazeGrid(int row, int width, char character)
    {
        if(character == 'X')
        this.mazeGrid[row][width] = 'X';
        else // replace X with empty space
        this.mazeGrid[row][width] = ' ';
    }

    public int[] findEntrance()
    {
        int[] coordinate = new int[2];
        coordinate[1] = 0;

        for (int row = 0; row < this.mazeGrid.length; row++) 
        {
            if(this.mazeGrid[row][0] == ' ')
            {
                coordinate[0] = row;
                return coordinate;
            }
        }
        return coordinate;
    }

    public int[] findExit()
    {
        int[] coordinate = new int[2];
        coordinate[1] = this.mazeGrid.length-1;

        for (int row = 0; row < this.mazeGrid.length; row++) 
        {
            if(this.mazeGrid[row][this.mazeGrid.length-1] == ' ')
            {    
                coordinate[0] = row;
                return coordinate;
            }
        }

        return coordinate;
    }

    public void printMaze()
    {
        for(int row1 = 0 ; row1 < mazeGrid.length; row1++)
        {
            for(int col = 0; col < mazeGrid[0].length; col++)
            {
                System.out.print(mazeGrid[row1][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

   /* public boolean mazeSolve()
    {
        int[] entrance = new int[2];
        entrance = findEntrance();

        int[] exit = new int[2];
        exit = findExit();

        //MazeSolver move = new MazeSolver(entrance, exit);
        changeMazeGrid(entrance[0], entrance[1], 'X');

        logger.info("** Start of Maze");

        printMaze();

        // hard coding movements for mvp such that it solves tiny.maz.txt

        // 3F
        for(int i = 0; i < 3; i++)
        {
            changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], ' ');
            move.moveForward();
            changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], 'X');
        }

        // 1 L
        move.turnLeft();

        // 4 F
        for(int i = 0; i < 4; i++)
        {
            changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], ' ');
            move.moveForward();
            changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], 'X');
        }

        // 1 R
        move.turnRight();
        
         // 3F
         for(int i = 0; i < 3; i++)
         {
             changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], ' ');
             move.moveForward();
             changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], 'X');
         }
    
        printMaze();
        logger.info("** End of Maze");

        System.out.println("FFF L FFFF R FFF");

        return true; // for now will return true if called
    }
    */
}