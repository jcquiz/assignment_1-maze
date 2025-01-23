package ca.mcmaster.se2aa4.mazerunner;

public class Moving 
{
    private int[] position;
    private int[] entrance;
    private int[] exit;
    private int vertical_direction;
    private int horizontal_direction;
    private boolean holdingRight;

    public Moving(int[] entrance, int exit[])
    {
        this.entrance = entrance;
        this.exit = entrance;
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
        if(vertical_direction == -1 && horizontal_direction == 0) // NORTH
        {
            vertical_direction = 0;
            horizontal_direction = -1;
        }
        else if(vertical_direction == 0 && horizontal_direction == 1) // EAST
        {
            vertical_direction = -1;
            horizontal_direction = 0;   
        }
        else if(vertical_direction == 1 && horizontal_direction == 0) // SOUTH
        {
            vertical_direction = 0;
            horizontal_direction = 1;
        }
        else // WEST
        {   
            vertical_direction = 1;
            horizontal_direction = 0;
        }
    }

    public void turnRight()
    {
        if(vertical_direction == -1 && horizontal_direction == 0) // NORTH
        {
            vertical_direction = 0;
            horizontal_direction = 1;
        }
        else if(vertical_direction == 0 && horizontal_direction == 1) // EAST
        {
            vertical_direction = 1;
            horizontal_direction = 0;
        }
        else if(vertical_direction == 1 && horizontal_direction == 0) // SOUTH
        {
            vertical_direction = 0;
            horizontal_direction = -1;
        }
        else // WEST
        {
            vertical_direction = -1;
            horizontal_direction = 0;
        }

    }

}
