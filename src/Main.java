import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    tabliczka();
    kolumny(6);
    }

    public static void kolumny(double x) {
        System.out.printf("%10s|%10s|%10s|%10s|%10s", "x", "x^2", "x^3", "e^x", "ln(x)");
        System.out.println();
        for (double i = 1; i <= x; i+=1) {
            System.out.printf("%10.3f|%10.4f|%10.4f|%10.4f|%10.4f", i, Math.pow(i, 2), Math.pow(i, 3), Math.pow(Math.E, i), Math.log(i));
            System.out.println();
        }

    }

    public static void tabliczka() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++ ) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
    public static double nwdAleOdejmowaniem(double a, double b) {
        while (a!=b) {
            if (a > b) {
                a = a -b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    public static double nwd(double a, double b) {
        double reszta = -1;

        while (reszta != 0) {
            reszta = a % b;
            a = b;
            b = reszta;
        }

        return a;
    }

    public static double silniaAleWzorem(double number) {
        return Math.pow((number/Math.E), number) * Math.sqrt(2 * Math.PI * number);
    }
    public static double silnia(double number) {
        double obliczonaSilnia = 1;
        for (int i = 1; i <= number; i+=1) {
            obliczonaSilnia *= i;
        }
        return obliczonaSilnia;
    }

    public static int sumaCyfr(int n) {
        int w = 0;
        while (n != 0) {
            w += n % 10;
            n /= 10;
        }
        return w;
          }

    public static boolean czyToTrojkat(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return c < a + b && b < a + c && a < c + b;
    }

    public static void poleIObwod(double a, double b, double c) {
        if (!czyToTrojkat(a, b, c)) {
            System.out.println("To nie jest trójkąt");
            return;
        }

        double perimeter = a + b + c;
        double p = perimeter/2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Obwód wynosi " + perimeter);
        System.out.println("Pole wynosi " + area);
    }

    public static void jakiTrojkatZeWzgleduNaKaty(double a, double b, double c) {
        String result;

        if (!czyToTrojkat(a, b, c)) {
            System.out.println("To nie jest trójkąt");
            return;
        }

        double[] array = new double[]{a, b, c};
        double[] sortedArray = Arrays.stream(array).sorted().toArray();
        double max = sortedArray[2];
        double mid = sortedArray[1];
        double min = sortedArray[0];

        double maxP = Math.pow(max, 2);
        double midP = Math.pow(mid, 2);
        double minP = Math.pow(min, 2);

        if (midP + minP == maxP) {
            result = "Prostokątny";
        } else if (maxP > midP + minP) {
            result = "Rozwartokątny";
        } else {
            result = "Ostrokątny";
        }

        System.out.println(result);
    }

    public static void jakiTrojkatZeWzgleduNaBoki(double a, double b, double c) {
        String result;

        if (!czyToTrojkat(a, b, c)) {
            System.out.println("To nie jest trójkąt");
            return;
        }

        if (a == b && b == c) {
            result = "Równoboczny";
        } else if (a == b || b == c) {
            result = "Równoramienny";
        } else {
            result = "Różnoboczny";
        }

        System.out.println(result);;
    }
    public static void rownanieX1iX2(double a, double b, double c) {

        String result;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "Funkcja jest tożsama";
                } else {
                    result = "Funkcja nie ma rozwiązań";
                }
            } else {
                double x = (-c) / b;
                result = String.format("Funkcja jest liniowa i ma jedno rozwiązanie: %s", x);
            }
        } else {
            double delta = delta(a, b, c);

            if (delta == 0) {
                double x = (-b) / (2 * a);
                result = String.format("Funkcja ma jedno rozwiązanie: %s", x);
            } else if (delta < 0) {
                result = "Funkcja nie ma rozwiązań";
            } else {
                double squaredDelta = Math.sqrt(delta);
                double x1 = ((-b) - squaredDelta) / (2 * a);
                double x2 = ((-b) + squaredDelta) / (2 * a);
                result = String.format("Funkcja ma dwa rozwiązania, x1:%s, x2:%s", x1, x2);
            }
        }

        System.out.println(result);
    }

    public static void liczbyPierwszeZPrzedzialu(int a, int b) {
        int lower = Math.min(a, b);
        int higher = Math.max(a, b);

        for (int i=lower; i <= higher; i+=1) {
            if (czyJestPierwsza(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean czyJestPierwsza(int num) {
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static double delta(double a, double b, double c) {
        return Math.pow(b, 2) - 4*a*c;
    }
}