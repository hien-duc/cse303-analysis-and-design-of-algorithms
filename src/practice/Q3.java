package practice;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of devices
        int n = sc.nextInt();
        long[] energy = new long[n];
        long[] cost = new long[n];

        // Read the energy values
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextLong();
        }

        // Read the cost values
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextLong();
        }

        // Solve the problem using dynamic programming
        if (n == 1) {
            // If there's only one device, choose it if its net energy is positive
            System.out.println(Math.max(0, energy[0] - cost[0]));
            return;
        }

        // dp[i] represents the maximum net energy we can collect up to device i
        long[] dp = new long[n];

        // Base cases
        dp[0] = Math.max(0, energy[0] - cost[0]);
        dp[1] = Math.max(dp[0], energy[1] - cost[1]);

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            long netEnergy = energy[i] - cost[i];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + netEnergy);
        }

        // The answer is the maximum net energy we can collect from all devices
        System.out.println(dp[n - 1]);
    }
}