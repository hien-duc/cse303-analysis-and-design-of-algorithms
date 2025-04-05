import java.util.*;
import java.io.*;

class Q2 {
    public static void main(String[] args) {
        int years = sc.nextInt();
        long init = sc.nextLong();
        long res = sc.nextLong();
        int left = 0;
        int right = 10000000;
        int middle = (left + right) / 2;
        
        while (right - left > 1) {
            double remain = remain(years, init, middle * 1.0 / 10000000);
            if (remain < res) {
                right = middle;
            } else {
                left = middle;
            }
            middle = (left + right) / 2;
        }
        System.out.println(left * 1.0 / 10000000);
    }

    static double remain(int years, long init, double x) {
        int steps = 0;
        double res = init;
        while (steps < years) {
            double rate = x * (1 - steps * 1.0 / years);
            res = res * (1 - rate);
            steps++;
        }
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
}
