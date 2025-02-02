package ca.mcmaster.se2aa4.mazerunner;

public class Checks
{
    private boolean holdingRight;
    private boolean emptySpaceForward;
    private boolean atExit;
    private Movement move;
    private Maze matrix;

    int[] entrance, exit, pos, direc = new int[2];

    public Checks(Maze maze, Movement moves)
    {
         // initializes directional variables
         this.holdingRight = false;
         this.atExit = false;
         move = moves;
         matrix = maze;
         entrance = maze.findEntrance();
         exit = maze.findExit();
         pos = move.updatedPosition();
         direc = move.updateDirec();
    }

    public void checkRight()
    {
        move.turnRight();
        pos = move.updatedPosition();
        direc = move.updateDirec();
        this.holdingRight = matrix.wallOnRight(pos[0] + direc[0], pos[1] + direc[1]);
        move.turnLeft();
    }

    public void checkForward()
    {
        pos = move.updatedPosition();
        direc = move.updateDirec();
        this.emptySpaceForward = matrix.emptyInFront(pos[0] + direc[0], pos[1] + direc[1]);
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

    
}
