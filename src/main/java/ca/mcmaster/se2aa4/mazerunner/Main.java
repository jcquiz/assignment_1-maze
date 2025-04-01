/* Title: Assignment 1 - Maze Solver
 * Name:JC Quizon
 * Date: 2/3/2025
 * Description: The program below demonstrates a maze runner that either solves the maze outputting a path that solves the
 * maze or checking the validity of a string by running the route given by the user to see if its possible.
 * 
 * The "-i" flag reads in the maze input and is required for the program to run
 * The "-p" flag after the -i flag is optional for checking path validity
 * 
 * Example: Use "java -jar target/mazerunner.jar -i ./examples/tiny.maz.txt" to run the program for some tiny maze
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {

            // adds -i and -p flag
            Options options = new Options();
            options.addOption("i", "input", true, "maze file");
            options.addOption("p", true, "path validity");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String mazeFile;

            if(cmd.hasOption("i")) {
                mazeFile = cmd.getOptionValue("i");
            }
            else
            {
                throw new Exception("error no -i flag found, please try again");
            }

            BufferedReader reader = new BufferedReader(new FileReader(mazeFile));

            

            // puts the maze into a 2d array of characters
            char matrix[][];
            String line = reader.readLine();
            matrix = new char[line.length()][line.length()];
            int row = 0;

            do 
            {
                for (int idx = 0; idx < line.length(); idx++) 
                {
                        if (line.charAt(idx) == '#') 
                        {
                            matrix[row][idx] = '#';
                        } 
                        else
                        {
                            matrix[row][idx] = ' ';
                        }  
                }
                row++;
            }while ((line = reader.readLine()) != null);

            Factory factory = new Factory();
            Maze maze = factory.getMaze("Maze", matrix);
            Editor editor = factory.getEditor("Editor");

            //path validity
            if(cmd.hasOption("p") && args.length == 4) 
            {
                PathValidity valid = factory.getPathValidity("pathValidity", maze);
                String path;
                if(args[2].equalsIgnoreCase("-p")) path = args[3];
                else path = args[1];

                editor.action("pathValid", valid, path);
                boolean validity = editor.returnBool();

                if (validity) System.out.println("Path solves the maze.");
                else System.out.println("The path given does not solve the maze.");
            }
            // finds maze solution
            else if(args.length == 2)
            {
            MazeSolver solve = factory.getMazeSolver("RightHandSolve", maze);
            editor.action("MazeSolver", solve);
            }
            else
            {
                throw new Exception("incorrect input, use -i some_maze.txt to find the path of a maze\nand -i some_maze.txt -p FFFF to find the path validity given some path FFFF");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

