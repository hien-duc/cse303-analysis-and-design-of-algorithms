package Week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIMIN {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0);
        
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextInt());
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1, a2) -> a1 - a2);
        queue.addAll(tree);
        
        for (int i = 0; i < k; i++) {
            if (queue.size() == 1) {
                sb.append(0).append("\n");
            } else {
                int minus = queue.poll();
                sb.append(queue.peek() - minus).append("\n");
            }
        }
        
        System.out.println(sb);
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