package multiThread;

public class threadOperation {
    public static void main(String[] args) {
        System.out.println("Program started");
        int sum = 54+36;
        System.out.println("Total is :"+sum);

        //For knowing Thread name
        Thread t = Thread.currentThread();
        String tname = t.getName();
        System.out.println("Thread Name :"+tname);

        //For set Thread name
        t.setName("myMain");
        System.out.println("New Thread Name :"+t.getName());

        //For Thread Id
        System.out.println("Thread Id :"+t.getId());
        System.out.println("Program ended");
    }
}
