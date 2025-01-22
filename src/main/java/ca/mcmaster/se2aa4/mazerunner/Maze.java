package ca.mcmaster.se2aa4.mazerunner;

public class Maze 
{
    private char mazeGrid[][];
    private int maze_width;

    public void getMazeWidth(int width)
    {
        this.maze_width = width;
    }

    public void makeMaze(int maze_width)
    {
        this.mazeGrid[][] = new char[this.maze_width][this.maze_width];
    }
}