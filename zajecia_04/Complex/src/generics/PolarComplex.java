package generics;

public class PolarComplex<T extends Number> extends Complex<T> {

    // private T radius;
    // private T angle;

    public PolarComplex(T radius, T angle) {
        super((T)(Number)(radius.doubleValue() * Math.cos(angle.doubleValue())),
            (T)(Number)(radius.doubleValue() * Math.sin(angle.doubleValue())));
    }

    public T getRadius() {
        return (T)(Number)super.module();
    }
    public void setRadius(T radius) {
        T angle = this.getAngle();
        super.setReal((T)(Number)(radius.doubleValue() * Math.cos(angle.doubleValue())));
        super.setImag((T)(Number)(radius.doubleValue() * Math.sin(angle.doubleValue())));
    }
    public T getAngle() {

        return (T)(Number)super.argument();
    }
    public void setAngle(T angle) {
        T radius = this.getRadius();
        super.setReal((T)(Number)(radius.doubleValue() * Math.cos(angle.doubleValue())));
        super.setImag((T)(Number)(radius.doubleValue() * Math.sin(angle.doubleValue())));
    }

    @Override
    public String toString() {
        return "r=" + this.getRadius() + " phi=" + this.getAngle();
    }
}
