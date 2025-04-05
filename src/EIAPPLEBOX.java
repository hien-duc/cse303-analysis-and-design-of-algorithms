import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIAPPLEBOX {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int t = reader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = reader.nextInt();
            long a = reader.nextLong();
            long p = reader.nextLong();

            long[] array = new long[n];
            array[0] = (a * a) % p;
            for (int j = 1; j < n; j++) {
                array[j] = (array[j - 1] * a) % p;
            }

            System.out.println(sort(array, 0, n - 1));
        }
    }

    static long merge(long[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        long[] left = new long[n1];
        long[] right = new long[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = nums[start + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = nums[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = start;
        long count = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
                count += left.length - i;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = right[j];
            j++;
            k++;
        }

        return count;
    }

    static long sort(long[] array, int start, int end) {
        long count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += sort(array, start, mid);
            count += sort(array, mid + 1, end);
            count += merge(array, start, mid, end);
        }
        return count;
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