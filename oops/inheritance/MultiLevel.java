package inheritance;


class First {
    void m1(){
        System.out.println("method m1");
    }
}

class Second extends First{
    void m2(){
        System.out.println("method m2");
    }
}

class Third extends Second{
    void m3(){
        System.out.println("method m3");
    }
}
public class MultiLevel {
    public static void main(String[] args) {
        Third c = new Third();  c.m1();  c.m2();  c.m3();
        Second b = new Second();  b.m1();  b.m2();
        First a = new First();  a.m1();
    }
}
