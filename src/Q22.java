import java.util.Arrays;
import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // int m = sc.nextInt();

        // long arr[] = new long[m + 1];

        // Arrays.fill(arr, Integer.MIN_VALUE);

        // arr[0] = 0;
        // arr[1] = 0;

        // long ways[] = new long[m + 1];

        // Arrays.fill(ways, 1);

        // long mod = 10000000;
        // for (int i = 1; i <= n; i++) {
        // arr[1] += sc.nextLong();

        // for (int j = 2; j <= m; j++) {
        // long current = sc.nextLong();

        // long currentWays = ways[j];
        // if (arr[j] == arr[j-1]){
        // ways[j] += ways[j-1] % mod;
        // }else if (arr[j] < arr[j-1]){
        // ways[j] = ways[j-1];
        // }

        // arr[j] = Math.max(arr[j], arr[j-1]) + current;
        // }
        // }
        // System.out.println(arr[m] + " " + ways[m]);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[m + 1];

        Arrays.fill(arr, Integer.MIN_VALUE);

        long[] ways = new long[m + 1];

        Arrays.fill(ways, 1);
        int mod = 1000000;
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 1; i <= n; i++) {
            arr[1] += sc.nextLong();

            for (int j = 2; j <= m; j++) {
                long current = sc.nextLong();
                long currentWays = ways[j];
                if(arr[j] == arr[j-1]){
                    ways[j] = ways[j-1] + currentWays % mod;
                }else if (arr[j] < arr[j-1]){
                    ways[j] = ways[j-1];
                }
                arr[j] = Math.max(arr[j], arr[j - 1]) + current;
            }

        }
        System.out.println(arr[m] +" " + ways[m]);
    }
}
