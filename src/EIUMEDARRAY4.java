import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUMEDARRAY4 {
    static InputReader scanner = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long a = scanner.nextLong();
            long p = scanner.nextLong();
            long k = scanner.nextLong();

            long kthSmallest = kthSmallest(n, a, p, k);
            sb.append(kthSmallest).append("\n");
        }
        System.out.println(sb);
    }

    static long kthSmallest(long n, long a, long p, long k) {
        long[] arr = new long[(int) n];
        arr[0] = (a * a) % p;
        for (int i = 1; i < n; i++) {
            arr[i] = (arr[i - 1] * a) % p;
        }
        long l = 0;
        long r = p;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (count(arr, mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    static long count(long[] arr, long mid) {
        long count = 0;
        for (long e : arr) {
            if (e <= mid) {
                count++;
            }
        }
        return count;
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