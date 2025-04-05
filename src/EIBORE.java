import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIBORE {
    public static void main(String[] args) {
        InputReader scanner = new InputReader(System.in);
        int n = scanner.nextInt();

        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            count[num]++;
        }

        long[] dp = new long[100001];
        dp[0] = 0;
        dp[1] = (long) 1 * count[1];// 2 4 6

        for (int i = 2; i <= 100000; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (long) i * count[i]);
        }

        System.out.print(dp[100000]);
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