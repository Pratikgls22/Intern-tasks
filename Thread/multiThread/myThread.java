package multiThread;

//create a class implements runnable interface
public class myThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread value :" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) {
        myThread mt = new myThread();
        mt.start();

        myAnotherThread mat = new myAnotherThread();
        Thread t = new Thread(mat);
        t.start();
        // using run method we call many time run same thread
        t.run();
        Thread t2 = new Thread("My Thread");
        t2.start();

         //For getting the thread name
        String str = t2.getName();
        System.out.println(str);
    }
}
