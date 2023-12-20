package MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Sayable{
    void Say();
}

public class MethodReferenceCode {

    public static void saySomthing(){
        System.out.println("Hello, this is Static method");
    }

    public static void main(String[] args) {
        Sayable sayable = MethodReferenceCode::saySomthing;
        sayable.Say();

        List<Integer> list = new ArrayList<>(Arrays.asList(12,15,18,16));
        list.forEach(System.out::println);
    }
}
