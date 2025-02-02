package ca.mcmaster.se2aa4.mazerunner;

//import ca.mcmaster.se2aa4.mazerunner.MazeSolver.Directions;

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

    private StringBuffer s = new StringBuffer();
    private StringBuffer f = new StringBuffer();
    private boolean actualMove;

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
        this.actualMove = false;
    }

    public void updateActualMove(boolean value)
    {
        actualMove = value;
    }

    public void checkRight()
    {
        turnRight();
        this.holdingRight = matrix.wallOnRight(position[0] + vertical_direction, position[1] + horizontal_direction);
        turnLeft();
    }

    public void checkForward()
    {
        this.emptySpaceForward = matrix.emptyInFront(position[0] + vertical_direction, position[1] + horizontal_direction);
    }

    public void checkExitReached(int[] position)
    {
        if (position[0] == exit[0] && position[1] == exit[1]) atExit = true;
    }

    public boolean returnAtExit()
    {
        return this.atExit;   
    }

    public boolean returnHoldingRight()
    {
        return this.holdingRight;
    }

    public boolean returnEmptySpaceForward()
    {
        return this.emptySpaceForward;
    }

    public int[] updatedPosition()
    {
        return new int[] {position[0], position[1]};
    }

    public void moveForward()
    {
        this.position[0] += vertical_direction;
        this.position[1] += horizontal_direction;
        if(this.actualMove) s.append("F");
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
        if(this.actualMove) s.append("L");
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
        if(this.actualMove) s.append("R");

    }

    public String returnCanonical()
    {
        String canonical = s.toString();
        return canonical;
    }

    public String factorizedOutput()
    {
        String canonical = returnCanonical();
        int count = 0;
        char current_char = 'z';

        for(int i=0; i < canonical.length(); i++)
        {
            if (i == 0) 
            {
                current_char = canonical.charAt(i);
                count++;
            }
            else
            {
                if(canonical.charAt(i) == current_char)
                {
                    count++;
                }
                else // not same char
                {
                    f.append(String.valueOf(count) + current_char + " ");
                    current_char = canonical.charAt(i);
                    count = 1;
                }
            }
        }
        f.append(String.valueOf(count) + current_char + " ");
        
        return f.toString();
    }

    public abstract void solveMaze();
    // overide in class which implements this !

}
