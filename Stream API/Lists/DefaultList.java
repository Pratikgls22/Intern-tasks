package Lists;

import java.util.Arrays;
import java.util.List;

public class DefaultList {

    public static List<String> name(){
        List<String> name = Arrays.asList("java", "python", "dotnet");
        return name;
    }
    public static List<Integer> number(){
        List<Integer> list2 = Arrays.asList(2, 5, 9, 7, 3);
        return list2;
    }

    public static String[] names(){
        String[] arr = {"one", "two", "three"};
        return arr;
    }
}
