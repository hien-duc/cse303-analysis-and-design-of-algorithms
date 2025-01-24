package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EIEQUALS {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        
        System.out.println(canMakePermutation(a, b, k) ? "YES" : "NO");
    }
    
    public static boolean canMakePermutation(int[] a, int[] b, int k) {
        int n = a.length;
        
        if (isPermutation(a, b)) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            int[] modified = Arrays.copyOf(a, n);       
            
            for (int value : b) {
                if (Math.abs(value - a[i]) <= k) {
                    modified[i] = value;
                    if (isPermutation(modified, b)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static boolean isPermutation(int[] a, int[] b) {
        Map<Integer, Integer> freqA = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();
        
        for (int num : a) {
            freqA.put(num, freqA.getOrDefault(num, 0) + 1);
        }
        
        for (int num : b) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }
        
        return freqA.equals(freqB);
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
