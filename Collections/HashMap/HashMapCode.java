package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapCode {
    public static void main(String[] args) {
    // create HashMap
        HashMap<Integer, String> Hm = new HashMap<>();
    // Add keys and values
        Hm.put(1,"dkk");
        Hm.put(2,"wesc");
        Hm.put(3,"ccsd");
        //Hm.put(3,"ccscjsd");
        System.out.println(Hm);

    // Access item
        System.out.println(Hm.get(2));

    // Remove element
        //Hm.remove(1);
        //System.out.println(Hm);

    // HashMAp Size
        System.out.println(Hm.size());

    for(Map.Entry m: Hm.entrySet()){
        System.out.println(m.getKey()+" "+m.getValue()
        );
    }

    // Using Loop
        for(int i : Hm.keySet()){
            System.out.println("Key :"+i+" Value :"+Hm.get(i));
        }
    }
}
