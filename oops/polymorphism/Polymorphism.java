package polymorphism;
import java.util.Scanner;

class Student{
    void show(int i){
        System.out.println("For Roll_no");
    }

    void show(String j){
        System.out.println("for sub");
    }
}
public class Polymorphism extends Student {

    Scanner s = new Scanner(System.in);
    int rollno = s.nextInt();
    String sub = s.next();
    int mar = s.nextInt();
    void Roll_No(){
        System.out.println("Roll_no :"+rollno);
    }
    void Sub(){
        System.out.println("Sub :"+sub);
    }
    void Marks(){
        System.out.println("Marks :"+ mar);

        if (mar>80){
            System.out.println("A");
        } else if (mar>60 && mar<80) {
            System.out.println("B");
        }
        else if(mar>40 && mar<60){
            System.out.println("C");
        }
        else if(mar<40){
            System.out.println("fail");
        }
        else {
            System.out.println("marks invaild");
        }
    }
}

class Student_Info extends Polymorphism{
    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();
        System.out.println("enter rollno");
        p.Roll_No();
        System.out.println("enter sub");
        p.Sub();
        System.out.println("enter marks");
        p.Marks();

    }
}
