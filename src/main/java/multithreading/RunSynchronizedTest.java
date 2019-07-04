package multithreading;

public class RunSynchronizedTest implements Runnable {

    private int i;
    public static void main(String[] args) {
        RunSynchronizedTest test = new RunSynchronizedTest();
        for (int i = 100; i > 0; i--) {
            new Thread(test).start();
        }
    }

    @Override
    public synchronized void run() {

        if(i%5!=0)
        {
            i++;
        }
        for(int x=0;x<5;x++,i++)
        {
            if(x>1)
            {
                Thread.yield();
                System.out.println(i+" ");
            }
        }
    }
}
