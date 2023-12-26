package multiThread;

public class syncronization {
    int number = 0;
    public synchronized void setNumber(){
        number++;
    }

    public static void main(String[] args) {
        syncronization syn = new syncronization();
        syn.multiThread();
    }

    public void multiThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    setNumber();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    setNumber();
                }
            }
        });
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(number);
    }

}
