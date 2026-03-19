import complex.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Complex c1 = new Complex(2,3);
        System.out.println("c1 = " + c1.toString());

        Complex c2 = new Complex(4,1);
        System.out.println("c2 = " + c2.toString());

        System.out.println("c1 + c2 = " + ComplexUtils.add(c1, c2));
        System.out.println("c1 - c2 = " + ComplexUtils.sub(c1, c2));
        System.out.println("c1 * c2 = " + ComplexUtils.mul(c1, c2));
        System.out.println("c1 / c2 = " + ComplexUtils.div(c1, c2));

        Complex c3 = new Complex(1,1);
        Complex c4 = new Complex(1,-1);

        System.out.println(c3 + " + " + c4 + " = " + ComplexUtils.add(c3, c4));
        System.out.println(c3 + " - " + c4 + " = " + ComplexUtils.sub(c3, c4));
        System.out.println(c3 + " * " + c4 + " = " + ComplexUtils.mul(c3, c4));
        System.out.println(c3 + " / " + c4 + " = " + ComplexUtils.div(c3, c4));
        System.out.println("modele(c3) = " + c3.module());
        System.out.println("argument(c3) = " + c3.argument());
        System.out.println("modele(c4) = " + c4.module());
        System.out.println("argument(c4) = " + c4.argument());

        System.out.println("\nTo samo ale z użyciem generyków");
        generics.Complex c5 = new generics.Complex(2.0,new BigDecimal(3));
        System.out.println("c5 = " + c5);

        generics.Complex c6 = new generics.Complex(Byte.valueOf((byte)4),1);
        System.out.println("c6 = " + c6);

        generics.Complex c5copy = new generics.Complex(c5);
        System.out.println("c5 + c6 = " + c5copy.add(c6));
        c5copy = new generics.Complex(c5);
        System.out.println("c5 - c6 = " + c5copy.substract(c6));
        c5copy = new generics.Complex(c5);
        System.out.println("c5 * c6 = " + c5copy.multiply(c6));
        c5copy = new generics.Complex(c5);
        System.out.println("c5 / c6 = " + c5copy.divide(c6));

        generics.Complex c7 = new generics.Complex(1,1);
        generics.Complex c8 = new generics.Complex(1,-1);
        generics.Complex c7copy = new generics.Complex(c7);

        System.out.println(c7copy + " - " + c8 + " = " + c7copy.substract(c8));
        c7copy = new generics.Complex(c7);
        System.out.println(c7copy + " + " + c8 + " = " + c7copy.add(c8));
        c7copy = new generics.Complex(c7);
        System.out.println(c7copy + " * " + c8 + " = " + c7copy.multiply(c8));
        c7copy = new generics.Complex(c7);
        System.out.println(c7copy + " / " + c8 + " = " + c7copy.divide(c8));

        System.out.println("modele(c7) = " + c7.module());
        System.out.println("argument(c7) = " + c7.argument());
        System.out.println("modele(c8) = " + c7.module());
        System.out.println("argument(c8) = " + c8.argument());

        System.out.println("Test PolarComplex<T>");
        generics.PolarComplex c9 = new generics.PolarComplex(1,1);
        System.out.println("c9  " + c9);
        System.out.println("c9 type = " + c9.getClass().getName());
        for (double x=0; x <= 2* Math.PI; x+=Math.PI/6) {
            c9.setAngle(x);
            System.out.println("c9 (angle=" + x * 180/Math.PI + ")  " + c9 + " (re=" + c9.getReal()+ " im=" + c9.getImag() +")");
        }

        System.out.println("c9 + c5 = " + c9.add(c5));




    }
}
