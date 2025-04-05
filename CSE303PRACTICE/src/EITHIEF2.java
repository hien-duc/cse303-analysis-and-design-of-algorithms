import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EITHIEF2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int n = reader.nextInt();
        int p = reader.nextInt();

        int[] weight = new int[n];
        long[] value = new long[n];

        for (int i = 0; i < n; i++) {
            weight[i] = reader.nextInt();
            value[i] = reader.nextLong();
        }

        // long[] dp = new long[p + 1];

        // for (int i = 0; i < n; i++) {
        // for (int w = p; w >= weight[i]; w--) {
        // dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
        // }
        // }

        // System.out.print(dp[p]);

        long dp[] = new long[p + 1];
        for (int i = 0; i < n; i++) {
            for (int w = p; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[p]);

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
