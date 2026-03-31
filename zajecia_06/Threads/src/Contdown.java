public class Contdown extends Thread {
    private final int count;

    public Contdown(int count)
    {

        this.count = count;
    }

    public void run()
    {
        System.out.println("Wątęk startuje: " + getName());
        for (int i = count; i >= 0; i--) {

            System.out.println("Wątęk: " + getName() + " licznik=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Wątęk kończy dziaanie: " + getName());
    }


}
