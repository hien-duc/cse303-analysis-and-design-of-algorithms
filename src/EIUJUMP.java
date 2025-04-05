
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class EIUJUMP {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);

        int n = sc.nextInt();

        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = sc.nextInt();
        }
        System.out.println(getMinJumps(n, colors));

    }

    private static int getMinJumps(int n, int[] colors) {
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        Map<Integer, Integer> last = new HashMap<>(n);
        last.put(colors[1], 1);

        for (int i = 2; i <= n; i++) {
            
            dp[i] = dp[i - 1] + 1; //2

            int curr = colors[i]; //8
            if (last.get(curr) != null) {
                int pre = last.get(curr);
                dp[i] = Math.min(dp[i], dp[pre] + 1);
            }

            last.put(curr, i);
        }

        return dp[n];
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
