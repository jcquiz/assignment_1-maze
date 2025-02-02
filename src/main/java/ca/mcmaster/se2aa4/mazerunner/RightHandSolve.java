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
            
            updateActualMove(false);

            super.checkForward();
            this.forwardEmpty = super.returnEmptySpaceForward();

            super.checkRight();
            this.rightWallHeld = super.returnHoldingRight();
            
            updateActualMove(true);

            if(this.rightWallHeld && this.forwardEmpty)
            {
                super.moveForward();
            }

            else if(this.rightWallHeld && !this.forwardEmpty)
            {
                super.turnLeft();
            }

            else if(!this.rightWallHeld) // if empty right hand side
            {
                super.turnRight();
                super.moveForward();
            }

            position = super.updatedPosition();
            super.checkExitReached(position);
        }while(!super.returnAtExit());
     
        System.out.println(super.returnCanonical());
        System.out.println(super.factorizedOutput());
    }

    public int[] returnFinal()
    {
        return position;
    }
    
}
