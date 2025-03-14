package Week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFT1v2 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int n = sc.nextInt();

        int m = sc.nextInt();

        double[] arrGift = new double[n];

        double[] arrWrapper = new double[m];

        for (int i = 0; i < n; i++) {
            arrGift[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arrWrapper[i] = sc.nextInt();
        }

        Arrays.sort(arrGift);
        Arrays.sort(arrWrapper);

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < arrGift.length && j < arrWrapper.length) {
            double rate = arrWrapper[j] / arrGift[i];
            if (rate >= 2 && rate <= 3) {
                res++;
                i++;
                j++;
            } else {
                if (rate > 3) {
                    i++;
                }
                if (rate < 2) {
                    j++;
                }
            }
        }
        System.out.println(res);
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
