package ca.mcmaster.se2aa4.mazerunner;

public class Factory
{
    // MazeSolver Factory
    public MazeSolver getMazeSolver(String mazeSolverType, Maze maze)
    {
        if(mazeSolverType == null) return null;

        if(mazeSolverType.equalsIgnoreCase("RightHandSolve"))
        {
            return new RightHandSolve(maze);
        }
        return null;
    }



    //Maze Factory
    public Maze getMaze(String mazeType, char maze[][])
    {
        if(mazeType == null) return null;

        if(mazeType.equalsIgnoreCase("Maze"))
        {
            return new Maze(maze);
        }
        return null;
    }



    // StringOutput Factory
    public StringOutput getStringOutput(String typeStringOutput)
    {
        if(typeStringOutput == null) return null;

        if(typeStringOutput.equalsIgnoreCase("StringOutput"))
        {
            return new StringOutput();
        }
        return null;
    }



    // Movement Factory
    public Movement getMovement(String movementType, Maze maze)
    {
        if(movementType == null) return null;

        if(movementType.equalsIgnoreCase("Movement"))
        {
            return new Movement(maze);
        }
        return null;
    }

    // PathValidity Factory
    public PathValidity getPathValidity(String pathValidityType, Maze maze)
    {
        if(pathValidityType == null) return null;

        if (pathValidityType.equalsIgnoreCase("PathValidity")) 
        {
            return new PathValidity(maze);    
        }

        return null;
    }


    // Checks Factory
    public Checks getChecks(String checkType, Maze maze, Movement moves)
    {
        if(checkType == null) return null;

        if (checkType.equalsIgnoreCase("Checks")) 
        {
            return new Checks(maze, moves);    
        }

        return null;
    }



    // Editor Factory
    public Editor getEditor(String editorType)
    {
        if(editorType == null) return null;

        if(editorType.equalsIgnoreCase("Editor"))
        {
            return new Editor();
        }
        return null;
    }


}