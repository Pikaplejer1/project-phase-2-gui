import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is responsible for working with the files, so that the highscore can be saved into the file and it can be read from the file.
 * @author Marcel Pendyk
 * @version 1.0 
 */
public class FileHandler {
    private String namesArr[] = new String[1000];
    private int scoresArr[] = new int[1000];
    /**
     * A function that reads the lines of a file and prints it out in *String* *int* manner
     * @param fileName name (or path) of the file that is to be read
     */
    public void readFile(String fileName)
    {
        try {
            File readFile = new File(fileName);
            //check if the file exists. If not print an error and return 
            if(!readFile.exists()) 
            {
                System.out.println("file: "+fileName +  " doesn't exist");
                return;
            }
            FileInputStream readFileInputStream = new FileInputStream(readFile);
            Scanner readScanner = new Scanner(readFileInputStream);
            //while scanner has something to scan for print out the values
            //TODO change it to save to arrays and use getters to access the data
             while(readScanner.hasNext())
            {   
                System.out.print(readScanner.next() + " ");
                try {
                    System.out.println(readScanner.nextInt());    
                } catch (Exception e) {
                    System.out.println("can't resolve variable");
                }
            }
        } catch (IOException e) {
            System.out.println("chuj");
            e.printStackTrace();
        }
        
    }

    /**
     * A function that allows to save the highscore of the user to the file.
     * @param fileName name (or path) of the file that is to be read
     * @param highscore value of the score that user got
     * @param userName name that user chose for the name that he wanted to save
     */
    public void saveFile(String fileName, int highscore, String userName)
    {
        int entriesNum=0;
        try {
            File saveFile = new File(fileName);
            //check if the file exists. If not print an error and return 
            if(!saveFile.exists())
            {
                System.out.println("can't find a file called: " + fileName);
                return;
            }
            //create input stream to read from file and create scanner to read from the input stream
            FileInputStream saveFileInputStream = new FileInputStream(saveFile);
            Scanner saveScanner = new Scanner(saveFileInputStream);
            //read the data and save it to arrays 
            while(saveScanner.hasNext())
            {   
                //read name
                namesArr[entriesNum] = saveScanner.next();
                try {
                    //read score
                    scoresArr[entriesNum] = saveScanner.nextInt();
                } catch (Exception e) {
                    System.out.println("can't resolve to a int variable at index: " + entriesNum);
                }
                entriesNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int newIndex=0;
        //find the index where the data should be inserted
        while(newIndex<entriesNum && scoresArr[newIndex]<=highscore)
        {
                newIndex++;
        }
        //shift the data to make space for new highscore
        for(int i=entriesNum-1; i>= newIndex;i--)
        {
            namesArr[i+1] = namesArr[i];
            scoresArr[i+1] = scoresArr[i];
        }
        //insert the new data to appropriate index
        namesArr[newIndex] = userName;
        scoresArr[newIndex] = highscore;  

        //TODO fix this code; insted of saving it deletes the whole file 
        try {
            //create printWriter instance with filewriter to write to the same file
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for(int i=0; i<entriesNum+1;i++)
            {
                writer.write(namesArr[i] + " "+ scoresArr[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}