package inheritance;

class Animal{
    void eat(){
        System.out.println("I am Eating");
    }
}

class Dog extends Animal{
    void type(){
        System.out.println("Non veg and Veg");
    }
}

public class singelLevel {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.type();
    }
}
