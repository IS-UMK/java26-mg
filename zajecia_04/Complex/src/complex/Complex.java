package complex;

public class Complex {

    private double real;
    private double imag;

    public Complex() {
        this(0,0);
    }

    public Complex(double real,double imag){
        this.real=real;
        this.imag=imag;
    }
    public Complex(Complex c){
        this(c.real,c.imag);
    }

    public Complex(double real) {
        this(real,0);
    }

    public String toString(){
        return real + " + " + imag + " i";
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
        this.real += c.getReal();
        this.imag += c.getImag();
        return this;
    }

    public Complex sub(Complex c){
        this.real -= c.getReal();
        this.imag -= c.getImag();
        return this;
    }

    public Complex mul(Complex c){
        double real = this.real * c.real - this.imag * c.imag;
        double imag = this.real * c.imag + this.imag * c.real;
        this.real = real;
        this.imag = imag;
        return this;
    }

    public Complex div(Complex c){
        double n = c.real * c.real + c.imag * c.imag;
        Complex result = new Complex(c).conjugate();
        result = result.mul(this);
        this.real = result.real / n;
        this.imag = result.imag / n;
        return this;
    }

    public double module(){
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument(){
        if ( real > 0)
            return Math.atan(imag / real);
        else if (real < 0) {
            return Math.atan(imag / real) + Math.PI;
        }
        if (imag > 0)
            return Math.PI / 2.0;
        else if (imag < 0)
            return -Math.PI / 2.0;

        // real == 0 && imag == 0
        throw new ArithmeticException("Operation undefined for real == 0 && imag == 0");
    }

    public Complex conjugate(){
        this.imag*=-1;
        return this;
    }

    static public Complex valueOf(double real, double imag){
        return new Complex(real, imag);
    }
    static public Complex valueOf(double real){
        return new Complex(real, 0.0);
    }

    static public final Complex I =  new Complex(0, 1);
    static public final Complex ONE =  new Complex(1, 0);
    static public final Complex ZERO =  new Complex(0, 0);
}
