package ca.mcmaster.se2aa4.mazerunner;

public abstract class Command 
{
    public Editor editor;

     Command(Editor editor)
     {
        this.editor = editor;
     } 

    public abstract boolean execute();
   
}
