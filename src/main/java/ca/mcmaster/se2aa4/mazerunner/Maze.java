package ca.mcmaster.se2aa4.mazerunner;

public class Maze 
{
    private char mazeGrid[][];
    private int maze_width;
    private boolean atExit;

    public Maze(char[][] maze)
    {
        this.mazeGrid = maze;
        this.atExit = false;
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

        for (int row = 0; row < this.mazeGrid.length; row++) 
        {
            System.out.println("HI");
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
    }

    public boolean mazeSolve()
    {
        int[] entrance = new int[2];
        entrance = findEntrance();

        int[] exit = new int[]{findExit()[0], findExit()[1]};
        System.out.println("position: " + entrance[0] + " " + entrance[1]);

        Moving move = new Moving(entrance, exit);
        printMaze();
        changeMazeGrid(entrance[0], entrance[1], 'X');

        printMaze();
        changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], ' ');
        move.moveForward();
        changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], 'X');
        printMaze();

        changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], ' ');
        move.turnLeft();
        move.moveForward();
        changeMazeGrid(move.updatedPosition()[0], move.updatedPosition()[1], 'X');
        printMaze();

        /*while(!atExit)
        {
            // some algo
        }*/

        return true; // for now will return true if called
    }

}