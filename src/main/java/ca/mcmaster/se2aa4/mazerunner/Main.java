/* Title: Assignment 1 - Maze Solver (MVP)
 * Name:JC Quizon
 * Date: 1/24/2025
 * Description: The current program demonstrates the minimimal viable product of the maze solving
 * program. It currently only demonstrates the maze creation but also the navigation functionality
 * of being able to navigate through the "tiny.maz.txt" maze showing its proper turning and moving of the maze.
 * 
 * Note: Use "java -jar target/mazerunner.jar -i ./examples/tiny.maz.txt" to run the mvp !
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
        logger.info("** Starting Maze Runner");
        try {
            // -i flag
            Options options = new Options();
            options.addOption("i", "input", true, "maze file");
            
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String mazeFile;

            if(cmd.hasOption("i")) {
                mazeFile = cmd.getOptionValue("i");
            }
            else
            {
                throw new Exception("error");
            }

            logger.info("**** Reading the maze from file " + mazeFile);
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
                        else if (line.charAt(idx) == ' ') 
                        {
                            matrix[row][idx] = ' ';
                        }  
                }
                row++;
            }while ((line = reader.readLine()) != null);

            
            Maze maze = new Maze(matrix);

            boolean hi;
            logger.info("**** Computing path");
            hi = maze.mazeSolve();

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.info("** End of MazeRunner");
    }
}
