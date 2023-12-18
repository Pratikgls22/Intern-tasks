package inheritance;

class A {
    void m1(){
        System.out.println("Class A");
    }
}

class B extends A{
    void m2(){
        System.out.println("Class B");
    }
}

class C extends A{
    void m2(){
        System.out.println("Class C");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        B b = new B();   b.m2();  b.m1();
        C c = new C();   c.m2();  c.m1();
    }
}
