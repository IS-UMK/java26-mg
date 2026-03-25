import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MonteCarlo {

    public static void main(String[] args) {

        // estymacja liczby pi
        int n = 1_000_000;

        var rand = new Random();

        long startTime = System.nanoTime();

        // sekwencyjnie bez zrumieni
        startTime = System.nanoTime();

        int k=0;
        for (int i = 0; i < n; i++) {

            boolean hit = Math.pow(ThreadLocalRandom.current().nextDouble(), 2)
                    +  Math.pow(ThreadLocalRandom.current().nextDouble(), 2)   < 1.0;
            if (hit) k++;
        }

        double pi = 4.0 * k / n;

        long durationNanos = System.nanoTime() - startTime;
        double durationMillis = durationNanos / 1_000_000; // zamiana na milisekundy
        System.out.println("Iteracja pętla for:");
        System.out.printf("pi=%.10f\n" ,pi );
        System.out.println("Czas: " + durationMillis + " ms.");

        startTime = System.nanoTime();

        pi = DoubleStream.generate(() -> { return
                Math.pow(rand.nextDouble(), 2)
                        +  Math.pow(rand.nextDouble(), 2)   < 1.0 ? 1.0 : 0.0 ;}).limit(n).average().orElse(0)*4.0;

        durationNanos = System.nanoTime() - startTime;
        durationMillis = durationNanos / 1_000_000;
        System.out.println("Strumień sekwencyjny:");
        System.out.printf("pi=%.10f\n" ,pi );
        System.out.println("Czas: " + durationMillis + " ms.");

        startTime = System.nanoTime();

        pi = DoubleStream.generate(() -> { return
                        Math.pow(rand.nextDouble(), 2)
                                +  Math.pow(rand.nextDouble(), 2)   < 1.0 ? 1.0 : 0.0 ;}).parallel().limit(n)
                .average().orElse(0)*4.0;

        durationNanos = System.nanoTime() - startTime;
        durationMillis = durationNanos / 1_000_000; // zamiana na milisekundy
        System.out.println("Strumień równoległy:");
        System.out.printf("pi=%.10f\n" ,pi );
        System.out.println("Czas: " + durationMillis + " ms.");

        // uzycie generatora nie blokujacego w wątkach
        startTime = System.nanoTime();
        pi = DoubleStream.generate(() -> { return
                        Math.pow(ThreadLocalRandom.current().nextDouble(), 2)
                                +  Math.pow(ThreadLocalRandom.current().nextDouble(), 2)   < 1.0 ? 1.0 : 0.0 ;}).limit(n)
                .parallel().average().orElse(0)*4.0;

        durationNanos = System.nanoTime() - startTime;
        durationMillis = durationNanos / 1_000_000; // zamiana na milisekundy
        System.out.println("Strumień równoległy z lokalnym generatorem:");
        System.out.printf("pi=%.10f\n" ,pi );
        System.out.println("Czas: " + durationMillis + " ms.");

        // zoptymalizowanie sekwencji obliczen
        startTime = System.nanoTime();
        pi = IntStream.range(0, n).parallel().map(i ->
                Math.pow(ThreadLocalRandom.current().nextDouble(), 2)
                        +  Math.pow(ThreadLocalRandom.current().nextDouble(), 2)   < 1.0 ? 1 : 0 ).average().orElse(0)*4.0;

        durationNanos = System.nanoTime() - startTime;
        durationMillis = durationNanos / 1_000_000; // zamiana na milisekundy
        System.out.println("Strumień równoległy z lokalnym generatorem:");
        System.out.printf("pi=%.10f\n" ,pi );
        System.out.println("Czas: " + durationMillis + " ms.");
    }
}
