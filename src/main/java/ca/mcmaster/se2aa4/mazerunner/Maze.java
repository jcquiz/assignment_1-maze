package ca.mcmaster.se2aa4.mazerunner;

public class Maze 
{
    private char mazeGrid[][];
    private int maze_width;

    public void getMazeWidth(int width)
    {
        this.maze_width = width;
    }

    public void getMaze(char[][] maze)
    {
        this.mazeGrid = maze;
    }

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

        for (int row = 0; row < this.maze_width; row++) 
        {
            if(this.mazeGrid[row][0] == ' ')
            coordinate[0] = row;
            return coordinate;
        }

        return coordinate;
    }

    public int[] findExit()
    {
        int[] coordinate = new int[2];
        coordinate[1] = this.maze_width-1;

        for (int row = 0; row < this.maze_width; row++) 
        {
            if(this.mazeGrid[row][this.maze_width-1] == ' ')
            coordinate[0] = row;
            return coordinate;
        }

        return coordinate;
    }

}