package generics;

public interface ArithemeticOperations<T extends Number> {
    Complex<T> add(Complex<? extends Number> c);
    Complex<T> substract(Complex<? extends Number> c);
    Complex<T> multiply(Complex<? extends Number> c);
    Complex<T> divide(Complex<? extends Number> c);
}
