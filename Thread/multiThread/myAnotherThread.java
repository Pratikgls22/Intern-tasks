package multiThread;

public class myAnotherThread implements Runnable {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("values of runnable thread :" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
