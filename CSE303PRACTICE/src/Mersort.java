import java.util.Scanner;

public class Mersort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }

    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int l = mid - start + 1;
        int r = end - mid;

        int left[] = new int[l];
        int right[] = new int[r];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i + start];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i + mid + 1];
        }

        int i = 0;
        int j = 0;
        int index = start;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[index] = left[i];
                i++;
            } else {
                arr[index] = right[j];
                j++;
            }
            index++;
        }

        while (i < left.length) {
            arr[index] = left[i];
            i++;
            index++;
        }
        while (j < right.length) {
            arr[index] = right[j];
            j++;
            index++;
        }

    }
}
