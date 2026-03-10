package generics;

public class Complex<T> {

    private T real ;
    private T imag;

    public Complex(T real, T imag) {
        this.real = real;
        this.imag = imag;
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

    public Complex<T> add(Complex<T> c){
        real = (T)(Number)(((Number)this.getReal()).doubleValue()
                + ((Number)c.getReal()).doubleValue());
        imag =  (T)(Number)(((Number)this.getImag()).doubleValue());
        return this;
    }
r}
