import java.io.*;
import java.util.*;

public class exam {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            long[][] floor = new long[h + 1][w + 1];
            
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    floor[i][j] = sc.nextInt();
                }
            }
            
            long max = -1;
            long[][] dp = new long[h + 1][w + 1];
            
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    long a = dp[i - 1][j];
                    long b = (j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                    long c = (j + 1 <= w) ? dp[i - 1][j + 1] : 0;
                    dp[i][j] = Math.max(a, Math.max(b, c)) + floor[i][j];
                    max = Math.max(dp[i][j], max);
                }
            }
            
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
