package StaticMethod;

interface Methods{
    default  void dMethod(){
        System.out.println("this method is default");
    }
//    void aMethod(String msg);

    static void sMethod(String msg){
        System.out.println(msg);
    }
}

public class StaticMethodCode implements Methods{

    public void aMethod(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        StaticMethodCode st = new StaticMethodCode();
        st.dMethod();                       // calling default method
        st.aMethod("Hello Softvan");   // calling abstract method
        Methods.sMethod("Hello");      //calling static method
    }
}
