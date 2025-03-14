package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIDIVIDE {

    public static void main(String[] args) {
        InputReader scanner = new InputReader(System.in);
        long n = scanner.nextLong();
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        long result = countOnes(n, l, r);
        System.out.println(result);
    }

    public static long getLength(long n) {
        if (n <= 1) {
            return 1;
        }
        return 2 * getLength(n / 2) + 1;
    }

    public static long countOnes(long n, long l, long r) {
        if (n <= 1) {
            return n == 1 ? Math.min(r - l + 1, 1) : 0;
        }
        long midLength = getLength(n / 2);
        long midValue = n % 2;
        long total = 0;
        if (l <= midLength) {
            total += countOnes(n / 2, l, Math.min(r, midLength));
        }
        if (l <= midLength + 1 && r >= midLength + 1) {
            total += midValue;
        }
        if (r > midLength + 1) {
            total += countOnes(n / 2, Math.max(1, l - midLength - 1), r - midLength - 1);
        }
        return total;
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
