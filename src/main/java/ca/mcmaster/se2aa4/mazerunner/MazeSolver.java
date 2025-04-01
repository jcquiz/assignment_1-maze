package ca.mcmaster.se2aa4.mazerunner;

// generic MazeSolver, which has the abstract to solve a maze
// algorithms implemented within solveMaze()

public abstract class MazeSolver 
{
    private Maze matrix;
    protected Movement moves;
    protected Checks check;
    protected StringOutput str = new StringOutput();
    Factory newFactory = new Factory();

    public MazeSolver(Maze maze)
    {
        // holds the maze
        this.matrix = maze;
        this.moves = newFactory.getMovement("Movement", matrix);
        this.check = newFactory.getChecks("Checks", matrix, moves);
    }

    public abstract void solveMaze();
    // overide in class which implements this !

}
