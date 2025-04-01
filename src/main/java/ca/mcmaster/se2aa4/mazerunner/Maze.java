package ca.mcmaster.se2aa4.mazerunner;

// class regarding maze matrix data

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

    // looks for the western entrance (only empty space in the first column)
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

    // looks for eastern exit (only empty space in the last column)
    public int[] findExit()
    {
        int[] coordinate = new int[2];
        coordinate[1] = this.mazeGrid[0].length-1;

        for (int row = 0; row < this.mazeGrid.length; row++) 
        {
            if(this.mazeGrid[row][this.mazeGrid[0].length-1] == ' ')
            {    
                coordinate[0] = row;
                return coordinate;
            }
        }
        return coordinate;
    }

}