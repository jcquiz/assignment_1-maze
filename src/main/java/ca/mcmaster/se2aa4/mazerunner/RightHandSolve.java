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
            this.forwardEmpty = super.returnEmptySpaceForward();

            super.checkRight();
            this.rightWallHeld = super.returnHoldingRight();
            

            if(this.rightWallHeld && this.forwardEmpty)
            {
                super.moveForward();
                System.out.print("F");
            }

            else if(this.rightWallHeld && !this.forwardEmpty)
            {
                super.turnLeft();
                System.out.print("L");
            }

            else if(!this.rightWallHeld) // if empty right hand side
            {
                super.turnRight();
                System.out.print("R");
                super.moveForward();
                System.out.print("F");
            }

            position = super.updatedPosition();
            super.checkExitReached(position);
        }while(!super.returnAtExit());
     
        //System.out.println("position is " + this.position[0] + " and " + this.position[1]);
    }

    public int[] returnFinal()
    {
        return position;
    }
    
}
