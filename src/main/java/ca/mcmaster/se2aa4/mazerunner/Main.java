package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            logger.info("**** Reading the maze from file " + args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            
            
            
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
 



            // prints the maze
            for(int row1 = 0 ; row1 < matrix.length; row1++)
            {
                for(int col = 0; col < matrix[0].length; col++)
                {
                    System.out.print(matrix[row1][col]);
                }
                System.out.println();
            }




        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
