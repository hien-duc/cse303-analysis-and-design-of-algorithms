import java.io.*;
import java.util.*;

public class countInvertion {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int T = reader.nextInt();
		for (int i = 0; i < T; i++) {
			int N = reader.nextInt();
			long A = reader.nextLong();
			long P = reader.nextLong();

			long[] array = new long[N];

			array[0] = ((A * A) % P);
			for (int j = 1; j < N; j++) {
				array[j] = (array[j - 1] * A % P);
			}

			System.out.println(sort(array, 0, N - 1));
		}

	}

	static long merge(long nums[], int from, int mid, int to) {

		int n1 = mid - from + 1;
		int n2 = to - mid;

		long L[] = new long[n1];
		long R[] = new long[n2];

		for (int i = 0; i < n1; ++i) {
			L[i] = nums[from + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = nums[mid + 1 + j];
		}

		int i = 0; 
		int j = 0;
		int k = from;
		int count = 0;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				nums[k] = L[i];
				i++;
			} else {
				nums[k] = R[j];
				j++;
				count += (mid + 1) - (from + i);
			}
			k++;
		}

		while (i < n1) {
			nums[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			nums[k] = R[j];
			j++;
			k++;
		}

		return count;

	}

	static long sort(long[] array, int from, int to) {
		long count = 0;
		if (from < to) {
			int mid = (from + to) / 2;
			count += sort(array, from, mid);
			count += sort(array, mid + 1, to);
			count += merge(array, from, mid, to);

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
