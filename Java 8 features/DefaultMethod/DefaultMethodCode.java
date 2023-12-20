package DefaultMethod;

interface Methods{
   default void dMethod(){
       System.out.println("This method is default");
   }
   void aMethod(String msg);
}
public class DefaultMethodCode implements Methods {


    public void aMethod(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) {
        DefaultMethodCode dm = new DefaultMethodCode();
        dm.aMethod("hello");
        dm.dMethod();
    }
}
