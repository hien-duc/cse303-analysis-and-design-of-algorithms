package Week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUDEPRE {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        double start = 0;
        double end = 1;
        double n = sc.nextDouble();
        double origialPrice = sc.nextDouble();
        double residual = sc.nextDouble();
        double res = 0;

        while (end - start > Math.pow(10, -7)) {
            double mid = (start + end) / 2;
            double price = calculate(mid, n, origialPrice);
            if (price > residual) {
                start = mid;
            } else {
                end = mid;
            }
            res = mid;
        }
        System.out.print(res);
    }

    public static double calculate(double mid, double n, double origialPrice) {
        double res = origialPrice;
        for (int i = 0; i < n; i++) {
            double rate = mid - mid * i / n;
            res *= (1 - rate);
        }
        return res;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
