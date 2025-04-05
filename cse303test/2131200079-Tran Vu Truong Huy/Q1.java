import java.util.*;
import java.io.*;

class Q1 {
    public static void main(String[] args) {
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        long[] arr = new long[cols];
        long sum = 0;

        for (int i = 0; i < cols; i++) {
            long input = sc.nextLong();
            arr[i] = input + sum;
            sum += input;
        }

        rows--;
        while (rows-- > 0) {
            arr[0] = arr[0] + sc.nextLong();
            for (int i = 1; i < cols; i++) {
                long input = sc.nextLong();
                arr[i] = Math.max(input + arr[i - 1], arr[i] + input);
            }
        }

        System.out.println(arr[cols - 1]);
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
}

