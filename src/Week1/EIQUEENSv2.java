package Week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIQUEENSv2 {

    static InputReader scanner = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[][] board = new char[8][8];

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            board[i] = line.toCharArray();

            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    list.add(new int[] { i, j });
                }
            }
        }

        if (list.size() != 8) {
            System.out.println("invalid");
            return;
        }

        if (checkQueen(list)){
            System.out.println("valid");
        }else{
            System.out.println("invalid");
        }

    }

    public static boolean checkQueen(List<int[]> queens) {

        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                int[] queen1 = queens.get(i);
                int[] queen2 = queens.get(j);

                if (queen1[0] == queen2[0] || queen1[1] == queen2[1]) {
                    return false;
                }
                if (Math.abs(queen1[0] - queen2[0]) == Math.abs(queen1[1] - queen2[1])) {
                    return false;
                }
            }
        }
        return true;
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
