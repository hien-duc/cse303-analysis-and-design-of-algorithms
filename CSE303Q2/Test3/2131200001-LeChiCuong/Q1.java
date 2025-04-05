import java.util.HashMap;
import java.util.Scanner;

class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] stones = new int[n + 1];
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();
        }

        HashMap<Integer, Long> save = new HashMap<>();
        dp[0] = -1;
        
        for (int i = 1; i <= n; i++) {
            if (save.get(stones[i]) == null) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, save.get(stones[i]) + 1);
            }
            save.put(stones[i], dp[i]);
        }
        
        System.out.println(dp[n]);
    }
}
