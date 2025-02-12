package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class EIEQUALS {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            map.put(number, map.getOrDefault(number, 0) - 1);
            if (map.get(number) == 0) {
                map.remove(number);
            }
        }

        if (map.size() == 0) {
            System.out.println("YES");
            return;
        }

        if (map.size() != 2) {
            System.out.println("NO");
            return;
        }

        Iterator<Entry<Integer, Integer>> i = map.entrySet().iterator();
        Entry<Integer, Integer> first = i.next();
        Entry<Integer, Integer> second = i.next();

        int firstKey = first.getKey();
        int secondKey = second.getKey();

        int firstValue = first.getValue();
        int secondValue = second.getValue();

        if (firstValue == 1 && secondValue == -1 || firstValue == -1 && secondValue == 1) {
            if (Math.abs(firstKey - secondKey) <= k) {
                System.out.println("YES");
                return;
            }
        }
        
        System.out.println("NO");

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
