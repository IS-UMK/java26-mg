public class SynchronizedCounter extends Counter{


    private int count;

    public SynchronizedCounter() {
        this.count = 0;
    }

    synchronized public void increment() {
        this.count++;
    }
    synchronized public int getCount() {
        return count;
    }
}
