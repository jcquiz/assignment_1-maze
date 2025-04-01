package ca.mcmaster.se2aa4.mazerunner;

public class Editor 
{
    private CommandHistory history = new CommandHistory();
    boolean result;

    // path validity command
    public void action(String actionWord, PathValidity valid, String parameter)
    {
        if(actionWord.equalsIgnoreCase("pathValid"))
        {
            PathValidityCommand command = new PathValidityCommand(this, valid, parameter);
            this.executeCommand(command);
            this.result = command.getResult(); // Store the result in the Editor
        }
    }

    public boolean returnBool()
    {
        return result;
    }

    // maze solver
     public void action(String actionWord, MazeSolver ms)
    {
        if(actionWord.equalsIgnoreCase("MazeSolver"))
        {
            this.executeCommand(new MazeSolverCommand(this, ms));
        }
    }


    // execute
    private void executeCommand(Command command)
    {
        if (command.execute()) 
        {
            this.history.push(command);    
        }
    }
}
