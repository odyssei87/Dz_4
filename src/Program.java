import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите числитель первой дроби");
        int numinator1=in.nextInt();
        System.out.println("Введите знаминатель первой дроби");
        int denominator1=in.nextInt();
        Fraction fraction1 = new Fraction(numinator1,denominator1);

        System.out.println("Введите числитель второй дроби");
        int numinator2=in.nextInt();
        System.out.println("Введите знаминатель второй дроби");
        int denominator2=in.nextInt();
        Fraction fraction2 = new Fraction(numinator2,denominator2);
        System.out.println("Введите знак операции");
        Fraction rezult = new Fraction();
        String znak = in.next();
        switch (znak){
            case "+" :
                try {
                    rezult = fraction1.sum(fraction1,fraction2);
                    System.out.println(rezult);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Программа завершена");
                }

                break;
            case "-" :
                try {
                    rezult = fraction1.sub(fraction1,fraction2);
                    System.out.println(rezult);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Программа завершена");
                }

                break;
            case "*" :
                try {
                    rezult = fraction1.mult(fraction1,fraction2);
                    System.out.println(rezult);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Программа завершена");
                }

                break;
            case "/" :
                try {
                    rezult = fraction1.div(fraction1,fraction2);
                    System.out.println(rezult);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Программа завершена");
                }

                break;

            default :
                break;
        }



    }


    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction() {

        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator() {

            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }
        public  void setNumerator(int numerator){
            this.numerator=numerator;}
        public  void setDenominator(int denominator){
            this.denominator=denominator;}

        public Fraction sum(Fraction fraction) {
            Fraction result = sum(fraction, this);
            return result;
        }

        public  Fraction sum(Fraction a, Fraction b) {

            int cDenominator = Math.nok(a.denominator, b.denominator);
            int cNumerator =
                    a.numerator * (cDenominator / a.denominator) +
                            b.numerator * (cDenominator / b.denominator);

            Fraction c = new Fraction(cNumerator, cDenominator);
            return c;
        }
        public  Fraction sub(Fraction a, Fraction b) {

            int cDenominator = Math.nok(a.denominator, b.denominator);
            int cNumerator =
                    a.numerator * (cDenominator / a.denominator) -
                            b.numerator * (cDenominator / b.denominator);

            Fraction c = new Fraction(cNumerator, cDenominator);
            return c;
        }

        public  Fraction mult(Fraction a, Fraction b) {
                int cDenominator = a.denominator*b.denominator;
                int cNumerator = a.numerator*b.numerator;
                Fraction c = new Fraction(cNumerator, cDenominator);
                return c;
        }
        public  Fraction div(Fraction a, Fraction b) {


            int cNumerator = a.numerator*b.denominator;
            int cDenominator = a.denominator*b.numerator;
            Fraction c = new Fraction(cNumerator, cDenominator);
            return c;
        }

        public static long gcm(long a, long b) {
            return b == 0 ? a : gcm(b, a % b);
        }

        public static String asFraction(long a, long b) {
            long gcm = gcm(a, b);
            return (a / gcm) + "/" + (b / gcm);
        }

        @Override
        public String toString() {
            return asFraction(numerator,denominator);
        }
    }

    class Math {
        static int nok(int a, int b) {
            return a * b / nod(a, b);
        }

        static int nod(int a, int b) {
            if (b == 0) {
                return a;
            }
            return nod(b, a % b);
        }
    }
}