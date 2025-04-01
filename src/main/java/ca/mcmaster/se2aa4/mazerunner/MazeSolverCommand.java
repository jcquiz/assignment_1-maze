package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolverCommand extends Command
{
    MazeSolver mazeSolveInstance;
    
    public MazeSolverCommand(Editor editor, MazeSolver ms)
    {
        super(editor);
        mazeSolveInstance = ms;
    }

    @Override
    public boolean execute()
    {
        mazeSolveInstance.solveMaze();
        return true;
    }
}
