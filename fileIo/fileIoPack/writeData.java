package fileIoPack;

import java.io.FileWriter;
import java.io.IOException;

public class writeData {
    public static void main(String[] args) throws IOException {

        FileWriter MyWriter = new FileWriter("C:/Users/pratik panchal/learning/Intern-tasks/fileIo/SecondFile.txt");
        MyWriter.write("Hello Everyone !!");
        MyWriter.close();
        System.out.println("Successfully written");
    }
}
