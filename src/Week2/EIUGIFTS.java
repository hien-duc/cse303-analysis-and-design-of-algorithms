package Week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFTS {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long maxPrice = sc.nextLong();

        int[] arrOfGift = new int[n];

        for (int i = 0; i < n; i++) {
            arrOfGift[i] = sc.nextInt();
        }
        Arrays.sort(arrOfGift);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        int right = n - 1;
        int left = 0;
        int count = 0;

        while (left < right) {
            if (arrOfGift[left] + arrOfGift[right] <= maxPrice) {
                if (res < arrOfGift[left] + arrOfGift[right]) {
                    res = arrOfGift[left] + arrOfGift[right];
                    minDiff = Math.abs(arrOfGift[left] - arrOfGift[right]);
                } else if (res == arrOfGift[left] + arrOfGift[right]
                        && minDiff > Math.abs(arrOfGift[left] - arrOfGift[right])) {
                    minDiff = Math.abs(arrOfGift[left] - arrOfGift[right]);
                }
                if (arrOfGift[left] + arrOfGift[right] == maxPrice) {
                    right--;
                }
                left++;
                count++;
            } else {
                right--;
            }
        }

        if (count == 0) {
            System.out.println("-1 -1");
          } else {
            System.out.println(res + " " + minDiff);
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
