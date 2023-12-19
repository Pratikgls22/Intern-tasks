package LinkedHashSet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetCode {
    public static void main(String[] args) {
        LinkedHashSet<String> Lhs = new LinkedHashSet<>();
        Lhs.add("Java");
        Lhs.add("python");
        Lhs.add("react");
        Lhs.add("Js");

        LinkedHashSet<String> Lhsi = new LinkedHashSet<String>(Arrays.asList("one","two","three","four"));
        Lhsi.addAll(Lhs);

        System.out.println(Lhsi);

        Iterator itr = Lhsi.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println(Lhsi.remove("one"));
        System.out.println(Lhsi);

    }
}
