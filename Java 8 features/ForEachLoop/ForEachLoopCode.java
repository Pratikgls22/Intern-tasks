package ForEachLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ForEachLoopCode {
    public static void main(String[] args) {


        // Using ForEach Loop
        List<String> name = new ArrayList<String>(Arrays.asList("java", "python", "react"));
        List<String> match = new ArrayList<>();

        name.forEach(n -> {
            if (n.equals("java")) {
                match.add(n);
            } else {
                match.remove(n);
            }
        });
        System.out.println(match);


        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,9,8));
        List<Integer> match2 = new ArrayList<>();

        list2.forEach(i ->{if (i%2 == 0){
            match2.add(i);
        }
        else {
            match2.remove(i);
        }
        });
        System.out.println(match2);

        list2.forEach(m->{if(Objects.equals(m,5) || (Objects.equals(m,8))){
            match2.add(m);
        }
        else {
            match2.remove(m);
        }
        });
        System.out.println(match2);

    }
}
