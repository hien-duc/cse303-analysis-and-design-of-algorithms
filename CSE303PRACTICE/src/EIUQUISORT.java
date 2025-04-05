import java.util.Scanner;

public class EIUQUISORT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long p = sc.nextLong();
            long k = sc.nextLong();

            long[] arr = new long[(int) n];
            arr[0] = (a * a) % p;
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }
            long ans = quickSort(arr, 0, (int) n - 1, k - 1);

            res.append(ans).append("\n");
        }
        System.out.println(res.toString());
    }

    public static long quickSort(long[] arr, int start, int end, long target) {
        if (start > end) {
            return -1;
        }
        int pivot = pivot(arr, start, end);
        if (pivot == target) {
            return arr[(int) target];
        } else if (pivot < target) {
            return quickSort(arr, pivot + 1, end, target);
        } else {
            return quickSort(arr, start, pivot - 1, target);
        }
    }

    public static int pivot(long[] arr, int start, int end) {

        int mid = (int) arr[(start + end) / 2];

        int i = start;
        int j = end;

        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                int temp = (int) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;

    }
}
