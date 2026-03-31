public class SynchronizedWorker implements Runnable {
    private final Counter counter;
    private final int count;

    public SynchronizedWorker(Counter counter, int count)
    {
        this.counter = counter;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (counter) {
                counter.increment();
            }
        }
    }


}
