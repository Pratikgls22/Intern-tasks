package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListCode {
    public static void main(String[] args) {
//  Create a list
        ArrayList<String> list = new ArrayList<>();
        list.add("Ravi");
        list.add("Japan");
        list.add("jgkjnas");

// Create a list without using add method
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("wiiwjsi","qqgjq","wwwck"));

    // merge two list
        list2.addAll(list);
        System.out.println(list2);

        System.out.println(list.hashCode());

    // get first element from list
        System.out.println(list.get(1));

    // set a new element to new element
        list2.set(2,"asuhq");
        System.out.println(list2);

    // for checking two list are same or not
        System.out.println(list.equals(list2));



    // for looping a list
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
