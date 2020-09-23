package test;

import java.util.concurrent.Semaphore;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore c0 = new Semaphore(1);
        Semaphore c1 = new Semaphore(1);
        Semaphore c2 = new Semaphore(1);
        Thread t1 = new Thread(new Work(c0, c1));
        Thread t2 = new Thread(new Work(c1, c2));
        Thread t3 = new Thread(new Work(c2, c0));
        c1.acquire();
        c2.acquire();
        t1.start();
        t2.start();
        t3.start();

    }

}

class Work implements Runnable {
    Semaphore c1;
    Semaphore c2;

    Work(Semaphore c1, Semaphore c2) {
        super();
        this.c1 = c1;
        this.c2 = c2;
    }

    public void run() {
        try {
            while (true) {
                c1.acquire();
                System.out.println("thread start:" + Thread.currentThread().getName());
                Thread.sleep(1000);
                c2.release();
            }
        } catch (InterruptedException  e) {
        }

    }
}

