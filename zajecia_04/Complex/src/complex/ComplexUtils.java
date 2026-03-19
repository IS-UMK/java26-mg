package complex;

public class ComplexUtils {

    static public Complex add(Complex c1, Complex c2){
        return new Complex(c1).add(c2);
    }
    static public Complex sub(Complex c1, Complex c2){
        return new Complex(c1).sub(c2);
    }
    static public Complex mul(Complex c1, Complex c2){
        return new Complex(c1).mul(c2);
    }
    static public Complex div(Complex c1, Complex c2){
        return new Complex(c1).div(c2);
    }
    static public Complex pow(Complex c1, int n){
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        Complex result = new Complex(c1);
        for (int i = 1; i <= n; i++){
            result = result.mul(result);
        }
        return result;
    }
}
