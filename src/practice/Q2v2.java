package practice;

import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }   
        System.out.print(sb);
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    public static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        swap(arr, mid, high - 1);
        return arr[high - 1];
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
