import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*save the data as a line of text into a String array so that it looks like this
 String[] highscores = {
            "qwer 60",
            "wert 40",
            "yuio 20"
        };
    then append a data into the String, then sort the data by the number decending 
    however this could work?
     then save it into the file 
     DO NOT BE OGRANICZONY BY THE 5 LINES SAVE THE WHOLE DATA!!!!!!!!
*/
//startLines iterates from 0 
public class FileHandler{
    public void readFile(String fileName, int linesCount, int startLine)
    {
        try {
            File readFile = new File(fileName);
            if(!readFile.exists()) 
            {
                System.out.println("file: "+fileName +  "doesn't exist");
                return;
            }
            FileInputStream readFileInputStream = new FileInputStream(readFile);
            Scanner readScanner = new Scanner(readFileInputStream);

            for(int i=startLine; i<linesCount;i++)
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

    public void saveFile(String fileName, int highscore, String userName)
    {
        int highcoreArr[] = new int[5];
        try {
            File saveFile = new File(fileName);
            if(!saveFile.exists())
            {
                System.out.println("file: "+fileName +  "doesn't exist");
                return;
            }
            FileInputStream saveFileInputStream = new FileInputStream(saveFile);
            Scanner saveScanner = new Scanner(saveFileInputStream);

            for(int i=0;i<5;i++)
            {   
                saveScanner.next();
                try {
                    System.out.println(saveScanner.nextInt());      
                } catch (Exception e) {
                    System.out.println("can't resolve variable");
                }
            }
            int indexToAppend=-1;
            for(int i=0;i<5;i++)
            {
                if (highcoreArr[i]<highscore) {
                    
                }
            }
            

        } catch(Exception e) {
            e.printStackTrace();
        }
            
    }
}