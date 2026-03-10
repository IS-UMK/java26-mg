package complex;

public class Complex {

    private double real;
    private double imag;

    public Complex(double real,double imag){
        this.real=real;
        this.imag=imag;
    }
    public Complex(Complex c){
        this(c.real,c.imag);
    }

    public Complex() {
        this(0,0);
    }
    public Complex(double real) {
        this(real,0);
    }

    public String toString(){
        return real + " + " + imag + "i";
    }

    public double getReal() {
        return real;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public double getImag() {
        return imag;
    }
    public void setImag(double imag) {
        this.imag = imag;
    }

    public Complex add(Complex c){
        this.real+=c.getReal();
        this.imag+=c.getImag();
        return this;
    }

    static public final Complex I =  new Complex(0, 1);
    static public final Complex ONE =  new Complex(1, 0);
    static public final Complex ZERO =  new Complex(0, 0);

    static public Complex valueOf(double real,double imag){
        return new Complex(real,imag);
    }
}
