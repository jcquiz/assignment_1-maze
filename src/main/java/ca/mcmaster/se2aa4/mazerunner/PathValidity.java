package ca.mcmaster.se2aa4.mazerunner;

// path validity class checks if the path given solves the maze

public class PathValidity
{
    protected Movement moves;
    protected Checks check;
	Factory factory = new Factory();

    public PathValidity(Maze maze)
    {
		moves = factory.getMovement("Movement", maze);
		check = factory.getChecks("Checks", maze, moves);
    }

// loops through a string, running through the maze with the inputs given untill it reaches the exit
// returning true or returning false when a illegal path is given or it doesnt end at the exit.

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
        check.checkExitReached(moves.updatedPosition()); // sends the current position to check if exit is reached
		if(check.returnAtExit()) return true;
	}
	return false;
}

}