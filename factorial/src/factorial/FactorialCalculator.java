package factorial;

import java.io.*;
import java.math.BigInteger;

public class FactorialCalculator {

    public static void main(String[] args) {

        int n = 0;
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter a number: ");
            String linie = reader.readLine();
            n = Integer.parseInt(linie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // int fact = 1;
        BigInteger fact =  new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial of " + n + " is " + fact);
    }

}
