package Constructor;



class Person{

    private int age;

    //    Non argument Constructor
    Person(){
        System.out.println("Calling from non parameter");
    }
//    parameter constructor
//    Display method
    public Person(int i){
        this.age = i;
        System.out.println("person age : "+i);
    }
}


public class Cons {
    public static void main(String[] args) {
        //creating defulting constructor
        Person p = new Person();
        //Creating parameteries constructor
        Person p1 = new Person(54458);
    }
}
