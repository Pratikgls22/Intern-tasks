package HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

// A HashSet is a collection of items where every item is unique
public class HashSetCode {
    public static void main(String[] args) {

        HashSet<String> Cars = new HashSet<>();
    // Add Element
        Cars.add("BMW");
        Cars.add("Porsche");
        Cars.add("Jaguar");
        Cars.add("Lamborghini");
        Cars.add("BMW");   // Here BMW second time added but in list we get only one time

    // using Iterator for looping
        Iterator itr = Cars.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    // Remove Element
        Cars.remove("Jaguar");
        System.out.println(Cars);

     // new Set
     HashSet<Integer> Number = new HashSet<>(Arrays.asList(4,9,2));

    // Using for loop and contain method
    for(int i=1; i<=10; i++){
        if(Number.contains(i)){
            System.out.println(i+" We Found in Set");
        }
        else{
            System.out.println(i+" We not Found in Set");
        }
    }

    }
}
