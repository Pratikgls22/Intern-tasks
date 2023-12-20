package LambdaExpression;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Sayable{
    public String Say();

}
interface Addable{
    int add(int a, int b);
}
public class LambdaExpressionCode {
    public static void main(String[] args) {

        // using lambda for zero parameter
        Sayable s = () ->{
          return "I have nothing to say";
        };
        System.out.println(s.Say());

        //without return keyword
        Addable ad = (a,b)->(a+b);
        System.out.println("your sum is : " +ad.add(10,20));

        //with return keyword
        Addable ad1 = (int a, int b)->{
            return (a+b);
        };
        System.out.println(ad1.add(10,20));

    }
}


