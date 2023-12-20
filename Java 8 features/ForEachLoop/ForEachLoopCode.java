package ForEachLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachLoopCode {
    public static void main(String[] args) {



        // Using ForEach Loop
        List<String> name = new ArrayList<String>(Arrays.asList("java","python","react"));

        name.forEach(n-> System.out.println(n));
    }
}
