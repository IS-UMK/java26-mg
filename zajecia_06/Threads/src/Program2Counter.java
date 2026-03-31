public class Program2Counter {

    public static void main(String[] args) throws InterruptedException
    {
        int n = 10_000_000;

        long start = System.nanoTime();
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Worker(counter, n));
        Thread thread2 = new Thread(new Worker(counter, n));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        long end = System.nanoTime();


        System.out.println("Counter: " + counter.getCount());
        System.out.println("Expected: " + 2 * n);
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");


        start = System.nanoTime();

        SynchronizedCounter counter2 = new SynchronizedCounter();
        thread1 = new Thread(new Worker(counter2, n));
        thread2 = new Thread(new Worker(counter2, n));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        end = System.nanoTime();

        System.out.println("Synchronized Counter: ");
        System.out.println("Counter: " + counter2.getCount());
        System.out.println("Expected: " + 2 * n);
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();

        Counter counter3 = new Counter();
        thread1 = new Thread(new SynchronizedWorker(counter3, n));
        thread2 = new Thread(new SynchronizedWorker(counter3, n));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        end = System.nanoTime();

        System.out.println("Synchronized Worker: ");
        System.out.println("Counter: " + counter3.getCount());
        System.out.println("Expected: " + 2 * n);
        System.out.println("Time: " + (end - start) / 1_000_000 + " ms");

    }
}
