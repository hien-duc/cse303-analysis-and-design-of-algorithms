package Week3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIFLIP {
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            // Read the target grid
            char[][] target = new char[3][3];
            for (int i = 0; i < 3; i++) {
                target[i] = sc.nextLine().toCharArray();
            }

            // Find minimum clicks needed
            int res = findMinClicks(target);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static int findMinClicks(char[][] target) {
        int minClicks = Integer.MAX_VALUE;

        // Try all possible combinations of clicks
        for (int mask = 0; mask < 512; mask++) { // 512 = 2^9 (all possible combinations)
            // Create initial white grid
            char[][] grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(grid[i], '.');
            }

            // Count clicks and apply them
            int clicks = countAndApplyClicks(grid, mask);

            // If this combination matches target, update minimum clicks
            if (isMatch(grid, target)) {
                minClicks = Math.min(minClicks, clicks);
            }
        }

        return minClicks == Integer.MAX_VALUE ? -1 : minClicks;
    }

    static int countAndApplyClicks(char[][] grid, int mask) {
        int clicks = 0;
        for (int position = 0; position < 9; position++) {
            if ((mask & (1 << position)) != 0) {
                clicks++;
                int row = position / 3;
                int col = position % 3;
                flipCell(grid, row, col);
            }
        }
        return clicks;
    }

    static void flipCell(char[][] grid, int row, int col) {
        // Flip the clicked cell
        flip(grid, row, col);

        // Flip adjacent cells
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValidPosition(newRow, newCol)) {
                flip(grid, newRow, newCol);
            }
        }
    }

    static void flip(char[][] grid, int row, int col) {
        grid[row][col] = (grid[row][col] == '.') ? '*' : '.';
    }

    static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    static boolean isMatch(char[][] grid, char[][] target) {
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
