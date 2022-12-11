import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        int numLines = 0;
        int numWords = 0;
        int numChars = 0;

        Scanner myFile = null;
        try{
            Scanner file = new Scanner(new File("src/test"));
            myFile = file;
        }catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
        while(myFile.hasNextLine()){
            String curLine = myFile.nextLine();
            int size = curLine.length();
            boolean foundDiv = true;
            boolean foundChar = false;
            for(int i = 0; i < size; i++){
                if(curLine.charAt(i)==' '){
                    foundDiv = true;
                    foundChar = false;
                }else{
                    foundChar = true;
                    numChars++;
                }
                if(foundChar && foundDiv){
                    numWords++;
                    foundDiv = false;
                }
            }
            numLines++;
        }
        myFile.close();
        System.out.println("Number of words is: " + numWords);
        System.out.println("Number of lines is: " + numLines);
        System.out.println("Number of characters is: " + numChars);
    }

}