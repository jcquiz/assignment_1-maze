package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Moving.Directions;

public class Moving 
{
    public enum Directions 
    {
        NORTH, EAST, SOUTH, WEST
    }

    private int[] position;
    private int[] entrance;
    private int[] exit;
    private int vertical_direction = 0;
    private int horizontal_direction = 1;
    private Directions direction = Directions.EAST;
    private boolean holdingRight;

    public Moving(int[] entrance, int exit[])
    {
        this.position = entrance;
        this.entrance = entrance;
        this.exit = exit;
    }

    public void moveForward()
    {
        this.position[0] += vertical_direction;
        this.position[1] += horizontal_direction;
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

}
