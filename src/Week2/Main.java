package Week2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of items
        int K = sc.nextInt(); // Budget
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt(); // Read item prices
        }
        Arrays.sort(prices); // Sort the prices in ascending order

        int left = 0; // Pointer at the start
        int right = N - 1; // Pointer at the end
        int maxSum = -1; // Track the maximum sum
        int minDiff = Integer.MAX_VALUE; // Track the smallest difference

        while (left < right) {
            int sum = prices[left] + prices[right]; // Sum of the two items
            if (sum <= K) {
                // If the sum is within the budget
                if (sum > maxSum) {
                    // Update the maximum sum and minimum difference
                    maxSum = sum;
                    minDiff = Math.abs(prices[right] - prices[left]);
                } else if (sum == maxSum) {
                    // If the sum is the same, update the minimum difference
                    minDiff = Math.min(minDiff, Math.abs(prices[right] - prices[left]));
                }
                left++; // Move the left pointer to try a larger sum
            } else {
                right--; // Move the right pointer to reduce the sum
            }
        }

        // Output the result
        if (maxSum == -1) {
            System.out.println("-1 -1"); // No valid pair found
        } else {
            System.out.println(maxSum + " " + minDiff); // Output the result
        }
    }
}
