import java.util.*;
import java.io.*;

public class EIUMERSORT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid - 1);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] l = new int[mid - start];
        int[] r = new int[end - mid + 1];

        int i = 0;
        int j = 0;
        int index = start;

        for (int k = 0; k < l.length; k++) {
            l[k] = arr[k + start];
        }

        for (int k = 0; k < r.length; k++) {
            r[k] = arr[k + mid];
        }
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                arr[index++] = l[i++];
            } else {
                arr[index++] = r[j++];
            }
        }
        while (i < l.length) {
            arr[index++] = l[i++];
        }
        while (j < r.length) {
            arr[index++] = r[j++];
        }
    }
}
