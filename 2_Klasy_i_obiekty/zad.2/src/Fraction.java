public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            System.out.println("Mianownik nie może być 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString(){
        return numerator + "/" +denominator;
    }
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    public void reduce(){
        int NWD=NWD(numerator,denominator);
        numerator /= NWD;
        denominator /= NWD;
    }
    public  int NWD(int a, int b){
        while (b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
}
