package ca.mcmaster.se2aa4.mazerunner;

public class PathValidity
{

    protected Movement moves;
    protected Checks check;

    public PathValidity(Maze maze)
    {
        moves = new Movement(maze);
        check = new Checks(maze, moves);
    }
    
public Boolean pathValid(String s)
{
	for(char character : s.toCharArray())
	{
		if(character == 'F')
		{
			check.checkForward();
				if(check.returnEmptySpaceForward()) moves.moveForward();
				else return false;
		}

		else if(character == 'L')
		{
			moves.turnLeft();
		}
		
		else if(character == 'R')
		{
			moves.turnRight();
		}
	
		else // invalid path
		{
			return false;
		}
        check.checkExitReached(moves.updatedPosition());
		if(check.returnAtExit()) return true;
	}
	return false;
}

}