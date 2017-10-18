/**
 * Created by sierra on 10/18/17.
 */
public class FractionCalculator {
    public static void main(String[] args){
        Fraction first = new Fraction(50, 100);
        Fraction second = new Fraction(1, 2);
        System.out.println(first.add(second));
        System.out.println(first.subtract(second));
        System.out.println(first.multiply(second));
        System.out.println(first.divide(second));
        System.out.println(first.equals(second));

    }
}
