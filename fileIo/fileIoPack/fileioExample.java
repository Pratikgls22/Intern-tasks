package fileIoPack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileioExample {
    public static void main(String[] args) throws IOException {
        File myObj = new File("C:/Users/pratik panchal/learning/Intern-tasks/fileIo/SecondFile.txt");
        if (myObj.createNewFile()) {
            System.out.println("File Created : "+ myObj.getName());
        }
        else{
            System.out.println("file alredy exists");
        }
        System.out.println(myObj.length());


    }
}
