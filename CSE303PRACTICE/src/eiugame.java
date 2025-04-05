import java.util.Arrays;
import java.util.Scanner;

public class eiugame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long arr[] = new long[m + 1];

        Arrays.fill(arr, Integer.MIN_VALUE);

        arr[0] = 0;
        arr[1] = 0;

        int mod = 1000000;

        long ways[] = new long[m + 1];
        Arrays.fill(ways, 1);

        for (int i = 1; i <= n; i++) {
            arr[1] += sc.nextInt();
            for (int j = 2; j <= m; j++) {

                int current = sc.nextInt();
                long way = ways[j];
                if (arr[j] == arr[j - 1]) {
                    ways[j] = (ways[j - 1] + way) % mod;
                } else if (ways[j] < ways[j - 1]) {
                    ways[j] = ways[j - 1];
                }
                arr[j] = Math.max(arr[j], arr[j - 1]) + current;
            }
        }

        System.out.println(arr[m] + " " + ways[m]);
    }
}
