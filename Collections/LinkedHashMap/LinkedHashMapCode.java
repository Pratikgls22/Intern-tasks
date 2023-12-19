package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedHashMapCode {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> Lhm = new LinkedHashMap<>();
        Lhm.put(100,"amit");
        Lhm.put(101,"akik");
        Lhm.put(102,"asas");

        for(Map.Entry m : Lhm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    // for replace the element
        Lhm.replace(101,"paka");
        System.out.println(Lhm);

        Lhm.clone();
        System.out.println(Lhm);
    }
}

