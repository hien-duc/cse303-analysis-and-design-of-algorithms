import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EISUBARRAY {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxSum = kadane(arr);
        System.out.println(maxSum);
    }

    static int kadane(int[] arr) {
        int posSum = 0;
        int negSum = 0;
        int resPos = 0;
        int resNeg = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            posSum += num;
            resPos = Math.max(res, posSum);
            negSum += num;
            resNeg = Math.min(res, negSum);

            if (posSum < 0) {
                posSum = 0;
            }

            if (negSum > 0) {
                negSum = 0;
            }
            resNeg = Math.abs(resNeg);
            res = Math.max(resNeg, resPos);
        }
        return res;
    }

    // static int findSubarray(int[] arr, int start, int end) {
    // int n = arr.length;
    // int[] preSum = new int[n + 1];
    // preSum[0] = 0;
    // for (int i = 1; i <= n; i++) {
    // preSum[i] = preSum[i - 1] + arr[i - 1];
    // }
    // int maxSum = Integer.MIN_VALUE;
    // for (int i = start; i <= end; i++) {
    // for (int j = i; j <= end; j++) {
    // int sum = preSum[j + 1] - preSum[i];
    // maxSum = Math.max(maxSum, sum);
    // }
    // }
    // return maxSum;
    // }

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
