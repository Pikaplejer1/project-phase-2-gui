import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gui myGui = new gui();
        FileHandler myFile = new FileHandler();
        myFile.readFile("text.txt");
        myFile.saveFile("text.txt", 2, "name2");
    }
}
