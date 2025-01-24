package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIUQBHV {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        String n = sc.nextLine();

        char arr[] = n.toCharArray();

        ArrayList<String> answer = new ArrayList<String>();
        answer.add("");
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            ArrayList<String> temp = new ArrayList<String>();
            for (String ans : answer) {
                for (int j = 0; j < ans.length(); j++) {
                    String newAns = ans.substring(0, j) + c + ans.substring(j);
                    temp.add(newAns);
                }
            }
            answer = temp;
        }
        
        sb.append(answer.size()).append("\n");

        for (String res : answer) {
            sb.append(res).append("\n");
        }
        System.out.print(sb.toString());
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
