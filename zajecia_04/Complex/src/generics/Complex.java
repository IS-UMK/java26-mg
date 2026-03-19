package generics;

import java.util.Objects;

public class Complex<T extends Number> implements ArithemeticOperations<T> {

    private T real ;
    private T imag;

    public Complex() {
        this((T)Double.valueOf(0), (T)Double.valueOf(0));
    }

    public Complex(T real, T imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(Complex<T> c){
        this(c.real,c.imag);
    }
    public T getReal() {
        return real;
    }
    public void setReal(T real) {
        this.real = real;
    }
    public T getImag() {
        return imag;
    }
    public void setImag(T imag) {
        this.imag = imag;
    }


    public String toString(){
        return real + " + " + imag + " i";
    }

    @Override
    public Complex<T> add(Complex<? extends Number> c){
        real = (T)(Number)(this.getReal().doubleValue()  + c.getReal().doubleValue());
        imag =  (T)(Number)(this.getImag().doubleValue() + c.getImag().doubleValue());
        return this;
    }

    @Override
    public Complex<T> substract(Complex<? extends Number> c){
        real = (T)(Number)(this.getReal().doubleValue()  - c.getReal().doubleValue());
        imag =  (T)(Number)(this.getImag().doubleValue() - c.getImag().doubleValue());
        return this;
    }


    @Override
    public Complex<T> multiply(Complex<? extends Number> c) {
        return null; // TODO
    }

    @Override
    public Complex<T> divide(Complex<? extends Number> c) {
        return null; // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Complex<?> complex)) return false;
        return Objects.equals(real, complex.real) &&
                Objects.equals(imag, complex.imag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    public T module() {
        return (T)(Number)Math.sqrt(real.doubleValue() * real.doubleValue() + imag.doubleValue() * imag.doubleValue());
    }

    public double argument() {
        if (real.doubleValue() > 0)
            return Math.atan(imag.doubleValue() / real.doubleValue());
        else if (real.doubleValue() < 0) {
            return Math.atan(imag.doubleValue() / real.doubleValue()) + Math.PI;
        }
        if (imag.doubleValue() > 0)
            return Math.PI / 2.0;
        else if (imag.doubleValue() < 0)
            return -Math.PI / 2.0;

        // real == 0 && imag == 0
        throw new ArithmeticException("Operation undefined for real == 0 && imag == 0");
    }
}
