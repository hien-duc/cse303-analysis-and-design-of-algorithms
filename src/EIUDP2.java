import java.util.Scanner;

public class EIUDP2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[] earnings = new int[n];
            for (int j = 0; j < n; j++) {
                earnings[j] = scanner.nextInt();
            }
            
            sb.append(maxEarnings(n, k, earnings)).append("\n");
        }
        System.out.println(sb);
    }
    
    public static long maxEarnings(int n, int k, int[] a) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            
            long sum = 0;
            for (int j = i; j > i - k && j > 0; j--) {
                sum += a[j - 1];
                
                if (j - k - 1 >= 0) {
                    dp[i] = Math.max(dp[i], dp[j - k - 1] + sum);
                } else {
                    dp[i] = Math.max(dp[i], sum);
                }
            }
        }
        
        return dp[n];
    }
}
