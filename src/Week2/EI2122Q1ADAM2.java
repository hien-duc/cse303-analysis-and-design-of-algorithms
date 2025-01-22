package Week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EI2122Q1ADAM2 {
    static int res  = Integer.MAX_VALUE;


    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[] men = new int[n];
        for (int i = 0; i < n; i++) {
            men[i] = sc.nextInt();
        }

        int[] women = new int[m];
        for (int i = 0; i < m; i++) {
            women[i] = sc.nextInt();
        }
        findMinimumDifference(n, m, x, men, women);

        System.out.println(res);

    }

    public static void findMinimumDifference(int n, int M, int X, int[] men, int[] women) {
        Arrays.sort(men);
        Arrays.sort(women);

        int left = 0;
        int right = Math.max(Math.abs(men[n - 1] - women[0]), women[n - 1] - men[0]);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMatch(men, women, X, mid)) {
                right = mid - 1;
                res = Math.min(res, mid);
            } else {
                left = mid + 1;
            }
        }

    }

    private static boolean canMatch(int[] men, int[] women, int X, int maxDiff) {
        int n = men.length;
        int m = women.length;
        int pairs = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (Math.abs(men[i] - women[j]) <= maxDiff) {
                pairs++;
                i++;
                j++;
            } else if (men[i] > women[j]) {
                j++;
            } else {
                i++;
            }
        }

        return pairs >= X;
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
