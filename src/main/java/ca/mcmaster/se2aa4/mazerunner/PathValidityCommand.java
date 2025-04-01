package ca.mcmaster.se2aa4.mazerunner;

public class PathValidityCommand extends Command
{
    PathValidity v;
    String str;
    boolean result = false;

    public PathValidityCommand(Editor editor, PathValidity validP, String s)
    {
        super(editor);
        this.v = validP;
        this.str = s;
    }

    public boolean getResult()
    {
        return this.result;
    }

    @Override
    public boolean execute()
    {
        this.result = this.v.pathValid(str);
        return true;
    }
    
}
