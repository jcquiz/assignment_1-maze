package ca.mcmaster.se2aa4.mazerunner;

// deals with tracking direction faced as well as movement through the matrix

public class Movement 
{
    public enum Directions 
    {
        NORTH, EAST, SOUTH, WEST
    }

    private int[] position;
    private int[] entrance;
    private int[] exit;

    private int vertical_direction; // -1 implies north, +1 implies south
    private int horizontal_direction; // -1 implies west, +1 implies east
    
    private Directions direction;
    private Maze matrix;

    public Movement(Maze maze)
    {
              // sets current position + saves the entrance and exit locations
              matrix = maze;
              this.position = matrix.findEntrance();
              this.entrance = this.position;
              this.exit = matrix.findExit();
              this.vertical_direction = 0;
              this.horizontal_direction = 1;
              this.direction = Directions.EAST;
    }

    /*
     * move forward will move forward in either the vertical or horizontal direction
     * dependent on which way the token is facing stored by this.direction
     * 
     * it will turn left from north by making horizontal_direction = -1 such that when move forward is
     * called, it moves west across the matrix
     */

    public void moveForward()
    {
        this.position[0] += vertical_direction;
        this.position[1] += horizontal_direction;
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

    public int[] updatedPosition()
    {
        return new int[] {position[0], position[1]};
    }

    public int[] updateDirec()
    {
        return new int[] {vertical_direction, horizontal_direction};
    }


}
