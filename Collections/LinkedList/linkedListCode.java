package LinkedList;

import java.util.*;

public class linkedListCode {
    public static void main(String[] args) {
        //Create a list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(56);
        list.add(89);
        list.add(29);
        list.add(56);


// Creating Direct list without using add method
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(56,89,35,53));




// for looping a list
        Iterator<Integer> lik = list.iterator();
        while(lik.hasNext()){
            System.out.println(lik.next());
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

// for removing element in the list
        list.remove(2);
        System.out.println(list);

// for get last element form list
        list.getLast();
        System.out.println(list);

// for merge to list
        list.addAll(list2);

        list.equals(list2);

        System.out.println(list);

        list2.removeIf(n->n.equals(56));
        System.out.println(list2);
    }
}
