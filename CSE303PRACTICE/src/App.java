import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        main();
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = (start + end) >> 1;
        int mid = arr[pivot];

        while (start <= end) {
            while (arr[start] < mid) {
                start++;
            }
            while (arr[end] > mid) {
                end--;
            }

            if (start <= end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }
}
