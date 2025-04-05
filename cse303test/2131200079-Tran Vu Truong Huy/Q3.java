import java.util.*;
import java.io.*;

class Q3 {
    public static void main(String[] args) {
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int left = 0;
            int right = Integer.MAX_VALUE;
            int middle = (left + right) / 2;
            
            while (right - left > 1) {
                int available = availableWithDistance(middle, arr);
                if (available < c) {
                    right = middle;
                } else {
                    left = middle;
                }
                middle = (left + right) / 2;
            }
            sb.append(left + "\n");
        }
        System.out.println(sb);
    }

    static int availableWithDistance(int distance, int[] arr) {
        int count = 1;
        int nextEle = arr[0] + distance;
        while (true) {
            int index = Arrays.binarySearch(arr, nextEle);
            if (index < 0) {
                index = ~index;
            }
            if (index < arr.length) {
                count++;
                nextEle = arr[index] + distance;
            } else {
                break;
            }
        }
        return count;
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
}
