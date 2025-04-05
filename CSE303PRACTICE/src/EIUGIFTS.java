import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EIUGIFTS {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int i = 0;
        int j = n - 1;
        int maxSum = 0;
        int minDiff = Integer.MAX_VALUE;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum > k) {
                j--;
            } else {
                if (sum > maxSum) {
                    maxSum = sum;
                    minDiff = Math.abs(arr[i] - arr[j]);
                } else if (sum == maxSum) {
                    minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[j]));
                }
                i++;
            }
        }
        if (maxSum == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxSum + " " + minDiff);
        }
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
