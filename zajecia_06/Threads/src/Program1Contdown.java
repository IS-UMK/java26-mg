import java.util.concurrent.locks.Condition;

public class Program1Contdown {

    public static void main(String[] args) throws InterruptedException
    {

        System.out.println("Wątek gówny: " + Thread.currentThread().getName());

        Contdown contdown = new Contdown(10);
        contdown.start();

        Contdown contdown2 = new Contdown(10);
        contdown2.start();


        System.out.println("Stan wątku 1 " + contdown.getState());
        System.out.println("Priorytet wątku 1 " + contdown.getPriority());
        System.out.println("Stos wątku 1 " + contdown.getStackTrace()[0]);

        System.out.println("Stan wątku 1 " + contdown.getState());

        contdown.join();
        contdown2.join();
        System.out.println("Stan wątku 1 " + contdown.getState());

        System.out.println("Wątek gówny się kończy: " + Thread.currentThread().getName());
    }
}
