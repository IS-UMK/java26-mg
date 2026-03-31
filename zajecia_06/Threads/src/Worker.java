public class Worker implements Runnable {
    private final Counter counter;
    private final int count;

    public Worker(Counter counter, int count)
    {
        this.counter = counter;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            counter.increment();
        }
    }
}
