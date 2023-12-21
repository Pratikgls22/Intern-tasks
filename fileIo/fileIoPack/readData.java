package fileIoPack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readData {
    public static void main(String[] args) throws IOException {
        File myObj = new File("C:/Users/pratik panchal/learning/Intern-tasks/fileIo/SecondFile.txt");
        Scanner myReader = new Scanner(myObj);
        while(myReader.hasNext()){
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }
}
