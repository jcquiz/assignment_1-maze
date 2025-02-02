package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolve extends MazeSolver 
{
    private int[] position = moves.updatedPosition();
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

            check.checkForward();
            this.forwardEmpty = check.returnEmptySpaceForward();

            check.checkRight();
            this.rightWallHeld = check.returnHoldingRight();
        

            if(this.rightWallHeld && this.forwardEmpty)
            {
                moves.moveForward();
                str.appendString('F');
            }

            else if(this.rightWallHeld && !this.forwardEmpty)
            {
                moves.turnLeft();
                str.appendString('L');
            }

            else if(!this.rightWallHeld) // if empty right hand side
            {
                moves.turnRight();
                str.appendString('R');
                moves.moveForward();
                str.appendString('F');
            }

            position = moves.updatedPosition();
            check.checkExitReached(position);
        }while(!check.returnAtExit());
     
        System.out.println(str.factorizedOutput());
    }

    public int[] returnFinal()
    {
        return position;
    }
    
}
