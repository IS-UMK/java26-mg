import complex.*;

public class Main {

    public static void main(String[] args) {

        Complex c1 =new Complex(1,2);

        System.out.println(c1.toString());

        c1.setImag(3);
        System.out.println(c1.toString());

        var c2 = new Complex();
        System.out.println(c2.toString());

        c1.add(c1);
        System.out.println("suma:" + c1.toString());

        Complex c3 = Complex.I;
        System.out.println(c3.toString());

        Complex c4 = ComplexUtils.add(c1,c3);
        System.out.println(c4.toString());

        generics.Complex<Double> c5 = new generics.Complex<Double>(3.0,4.0);
        c5 = c5.add(c5);

    }
}
