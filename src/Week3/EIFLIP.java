package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIFLIP {
    static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            char[][] target = new char[3][3];
            for (int i = 0; i < 3; i++) {
                target[i] = sc.next().toCharArray();
            }
            sb.append((solve(target))).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(char[][] target) {
        int minClicks = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << 9); mask++) {
            char[][] grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(grid[i], '.');
            }

            int clicks = 0;
            for (int pos = 0; pos < 9; pos++) {
                if ((mask & (1 << pos)) != 0) {
                    clicks++;
                    int row = pos / 3;
                    int col = pos % 3;
                    flipCells(grid, row, col);
                }
            }

            if (matches(grid, target)) {
                minClicks = Math.min(minClicks, clicks);
            }
        }

        return minClicks == Integer.MAX_VALUE ? -1 : minClicks;
    }

    static void flipCells(char[][] grid, int row, int col) {
        grid[row][col] = flip(grid[row][col]);

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol)) {
                grid[newRow][newCol] = flip(grid[newRow][newCol]);
            }
        }
    }

    static char flip(char c) {
        return c == '.' ? '*' : '.';
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    static boolean matches(char[][] grid, char[][] target) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != target[i][j]) {
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
