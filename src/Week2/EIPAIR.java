package Week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIPAIR {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        long n = sc.nextLong();
        for (int i = 0; i < n; i++) {

            int numOfGift = sc.nextInt();
            int[] arrOfGift = new int[ numOfGift];

            for (int j = 0; j < numOfGift; j++) {
                arrOfGift[j] = sc.nextInt();
            }

            long res = ways(arrOfGift);
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }

    static long ways(int[] arr) {
        long res = 0;

        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], (long) 0) + 1);
        }

        for (long j : map.values()) {
            if (j >= 2) {
                long temp = (j*(j-1))/2;
                res += temp;
            }
        }
        return res;

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
