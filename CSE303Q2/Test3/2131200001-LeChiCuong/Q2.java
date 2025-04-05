import java.util.Arrays;
import java.util.Scanner;

class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        long sumA = 0;
        long sumB = 0;

        for (int i = 0; i < n; i++) {
            arrayA[i] = sc.nextInt();
            sumA += arrayA[i];
        }

        for (int i = 0; i < n; i++) {
            arrayB[i] = sc.nextInt();
            sumB += arrayB[i];
        }

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        if (Math.abs(sumA - sumB) <= k) {
            int i = 0;
            int j = 0;
            int count = 0;

            while (i < n && j < n) {
                if (arrayA[i] == arrayB[j]) {
                    i++;
                    j++;
                    count++;
                } else if (arrayA[i] < arrayB[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            if (count <= n && count >= n - 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        } else {
            System.out.println("NO");
        }
    }
}
