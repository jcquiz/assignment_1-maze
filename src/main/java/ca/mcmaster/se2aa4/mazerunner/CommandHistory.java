package ca.mcmaster.se2aa4.mazerunner;
import java.util.Stack;

public class CommandHistory 
{
    private Stack<Command> history = new Stack<>();
    
    public void push(Command c)
    {
        this.history.push(c);
    }

    public Command pop()
    {
        if(!isEmpty()) return this.history.pop();
        else return null;
    }

    public boolean isEmpty()
    {
        return this.history.isEmpty();
    }

}
