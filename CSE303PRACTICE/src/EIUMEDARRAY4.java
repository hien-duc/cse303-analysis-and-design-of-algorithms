import java.util.Scanner;

public class EIUMEDARRAY4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long a = scanner.nextLong();
            long p = scanner.nextLong();
            long k = scanner.nextLong();
            sb.append(findKSmallest(n, a, p, k)).append("\n");
        }
        System.out.println(sb);
    }

    public static long findK(long n, long a, long p, long k) {
        long[] arr = new long[(int) n];
        arr[0] = (a * a) % p;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (arr[i - 1] * a) % p;
        }

        long l = 0;
        long r = p;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (count(arr, mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // public static int count(long arr[], long mid) {
    // int res = 0;
    // for (long l : arr) {
    // if (l <= mid) {
    // res++;
    // }
    // }
    // return res;
    // }

    public static long findKSmallest(long n, long a, long p, long k) {
        long arr[] = new long[(int) n];
        arr[0] = (a * a) % p;
        for (int i = 1; i < n; i++) {
            arr[i] = (arr[i - 1] * a) % p;
        }

        long l = 0;
        long r = p;
        long mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (count(arr, mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }

    public static int count(long arr[], long mid) {
        int count = 0;
        for (long i : arr) {
            if (mid >= i) {
                count++;
            }
        }
        return count;
    }
}
