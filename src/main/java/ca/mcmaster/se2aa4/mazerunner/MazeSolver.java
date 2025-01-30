package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.MazeSolver.Directions;

public abstract class MazeSolver 
{
    public enum Directions 
    {
        NORTH, EAST, SOUTH, WEST
    }

    private int[] position;
    private int[] entrance;
    private int[] exit;

    private int vertical_direction;
    private int horizontal_direction;
    
    private Directions direction;
    private boolean holdingRight;
    private boolean emptySpaceForward;
    private boolean atExit;

    private Maze matrix;

    public MazeSolver(Maze maze)
    {
        // holds the maze
        this.matrix = maze;
        
        // sets current position + saves the entrance and exit locations
        this.position = matrix.findEntrance();
        this.entrance = this.position;
        this.exit = matrix.findExit();

        // initializes directional variables
        this.holdingRight = false;
        this.atExit = false;
        this.direction = Directions.EAST;
        this.vertical_direction = 0;
        this.horizontal_direction = 1;
    }

    public void moveForward()
    {
        this.position[0] += vertical_direction;
        this.position[1] += horizontal_direction;
    }

    public void checkRight()
    {
        turnRight();
        this.holdingRight = matrix.wallOnRight(position[0] + vertical_direction, position[1] + horizontal_direction);
        turnLeft();
    }

    public void checkForward()
    {
        this.emptySpaceForward = matrix.wallInFront(position[0] + vertical_direction, position[1] + horizontal_direction);
    }


    public int[] updatedPosition()
    {
        return position;
    }

    public void turnLeft()
    {
        if(direction == Directions.NORTH) // NORTH
        {
            vertical_direction = 0;
            horizontal_direction = -1;
            direction = Directions.WEST;
        }
        else if(direction == Directions.EAST) // EAST
        {
            vertical_direction = -1;
            horizontal_direction = 0;
            direction = Directions.NORTH;   
        }
        else if(direction == Directions.SOUTH) // SOUTH
        {
            vertical_direction = 0;
            horizontal_direction = 1;
            direction = Directions.EAST;
        }
        else // WEST
        {   
            vertical_direction = 1;
            horizontal_direction = 0;
            direction = Directions.SOUTH;
        }
    }

    public void turnRight()
    {
        if(direction == Directions.NORTH) // NORTH
        {
            vertical_direction = 0;
            horizontal_direction = 1;
            direction = Directions.EAST;
        }
        else if(direction == Directions.EAST) // EAST
        {
            vertical_direction = 1;
            horizontal_direction = 0;
            direction = Directions.SOUTH;
        }
        else if(direction == Directions.SOUTH) // SOUTH
        {
            vertical_direction = 0;
            horizontal_direction = -1;
            direction = Directions.WEST;
        }
        else // WEST
        {
            vertical_direction = -1;
            horizontal_direction = 0;
            direction = Directions.NORTH;
        }

    }

    public abstract void solveMaze();
    // overide in class which implements this !

}
