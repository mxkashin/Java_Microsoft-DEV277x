/**
 * Created by sierra on 10/18/17.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("denominator cannot be 0");
        }
        if(denominator < 0){
            this.numerator = numerator * (-1);
            this.denominator = denominator * (-1);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator){
        this(numerator, 1);
    }

    public Fraction(){
        this(0, 1);
    }

    public Fraction add(Fraction other){
        int newNumerator = this.numerator * other.denominator +
                other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction subtract(Fraction other){
        int newNumerator = this.numerator * other.denominator -
                other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction multiply(Fraction other){
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            throw new IllegalArgumentException("you cannot divide by 0");
        } else {
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            Fraction result = new Fraction(newNumerator, newDenominator);
            result.toLowestTerms();
            return result;
        }
    }

    public boolean equals(Object other){
        if (other instanceof Fraction){
            ((Fraction) other).toLowestTerms();
            this.toLowestTerms();
            if (((Fraction) other).numerator == this.numerator &&
                    ((Fraction) other).denominator == this.denominator){
                return true;
            }
        }
        return false;
    }

    public void toLowestTerms(){
        int factor = gcd(numerator, denominator);
        this.numerator = numerator / factor;
        this.denominator = denominator / factor;
    }

    public static int gcd(int numerator, int denominator){
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        while (b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;

    }

    public String toString() {
        if (denominator == 1){
            return String.format("%d", numerator);
        } else {
            return String.format("%d/%d", numerator, denominator);
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}

