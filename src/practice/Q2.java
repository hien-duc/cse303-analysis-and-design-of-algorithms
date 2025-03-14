package practice;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        double c = reader.nextDouble();
        double r = reader.nextDouble();

        double left = 0;
        double right = 1;

        while (right - left >= Math.pow(10, -7)) {
            double mid = (right + left) / 2;

            double remainValue = c;

            for (int k = 0; k < n; k++) {
                double x = mid - mid * k / n;
                remainValue *= (1 - x);
            }

            if (remainValue >= r) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(right);
    }

}
