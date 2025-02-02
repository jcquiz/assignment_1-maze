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

    public boolean emptyInFront(int row, int col)
    {
        if (mazeGrid[row][col] == ' ') return true;
        else return false;
    }

    // redundant (visual for user !)
    public void changeMazeGrid(int[] array, char character)
    {
        if(character == 'X')
        this.mazeGrid[array[0]][array[1]] = 'X';
        else // replace X with empty space
        this.mazeGrid[array[0]][array[1]] = ' ';
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

        for (int row = 0; row < this.mazeGrid[0].length; row++) 
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
            if(row1 != mazeGrid.length-1)System.out.println();
        }
    }

}