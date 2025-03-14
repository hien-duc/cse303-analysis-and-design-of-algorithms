package Week1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class EIPAGESv2 {

    static InputReader scanner = new InputReader(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        List<Integer> pages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            pages.add(num);
        }
        Collections.sort(pages);
        System.out.print(shortenPageNumbers(pages));
    }

    public static String shortenPageNumbers(List<Integer> pages) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < pages.size(); i++) {
            int start = pages.get(i);

            while (i + 1 < pages.size() && pages.get(i + 1) == pages.get(i) + 1) {
                i++;
            }

            if (res.length() > 0) {
                res.append(" ");
            }
            if (start == pages.get(i)) {
                res.append(start);
            } else if (start == pages.get(i - 1)) {
                res.append(start).append(" ").append(pages.get(i));
            } else {
                res.append(start).append("-").append(pages.get(i));
            }
        }
        return res.toString();
    }

    public static String shortPage(List<Integer> pages) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < pages.size(); i++) {
            int start = pages.get(i);

            while (i + 1 < pages.size() && pages.get(i) + 1 == pages.get(i + 1)) {
                i++;
            }

            if (res.length() > 0) {
                res.append(" ");
            }

            if (start == pages.get(i)) {
                res.append(start);
            } else if (start == pages.get(-1)) {
                res.append(start).append(" ").append(pages.get(i));
            } else {
                res.append(start).append("-").append(pages.get(i));
            }
        }

        return res.toString();
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
