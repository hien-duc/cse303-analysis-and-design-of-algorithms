import java.util.Scanner;

public class examq2 {
    public static void main(String[] args) {
        int n = sc.nextInt();
        int needMeters = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        int middle = (left + right) / 2;
        while (right - left > 1) {
            long cutMeters = cutMeters(arr, middle);
            if (cutMeters < needMeters) {
                right = middle;
            } else {
                left = middle;
            }
            middle = (left + right) / 2;
        }
        System.out.println(left);
    }

    static long cutMeters(int[] arr, int minHeight) {
        long cutMeters = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minHeight) {
                cutMeters += arr[i] - minHeight;
            }
        }
        return cutMeters;
    }

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
}
