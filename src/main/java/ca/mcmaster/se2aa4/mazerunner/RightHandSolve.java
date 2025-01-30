package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolve extends MazeSolver 
{
    private int[] position = super.updatedPosition();
    private boolean forwardEmpty;
    private boolean rightWallHeld;

    public RightHandSolve(Maze maze) 
    {
       super(maze);
    }

    @Override
    public void solveMaze() 
    {
        do
        {
            // checks to see if were holding the right hand wall and if there is a wall in front of us
            super.checkForward();
            super.checkRight();
            this.rightWallHeld = super.returnHoldingRight();
            this.forwardEmpty = super.returnEmptySpaceForward();

            if(this.rightWallHeld && this.forwardEmpty)
            {
                super.moveForward();
            }

            else if(this.rightWallHeld && !this.forwardEmpty)
            {
                super.turnLeft();
            }

            else // if empty right hand side and forward empty
            {
                super.turnRight();
                super.moveForward();
            }

            position = super.updatedPosition();
            super.checkExitReached(position);
        }while(!super.returnAtExit());
     
        System.out.println("position is " + this.position[0] + " and " + this.position[1]);
    }
    
}
