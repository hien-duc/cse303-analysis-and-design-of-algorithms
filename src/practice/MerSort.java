package practice;

import java.util.Scanner;

class EIUMERSORT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        mergeSort(array, 0, n - 1);

        for (int num : array) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            r[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = r[j];
            j++;
            k++;
        }
    }

    static void mergesort(int[] arr, int left, int right, int mid) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (arr1[i] >= arr2[j]) {
                arr[k] = arr2[j];
                j++;
            } else {
                arr[k] = arr1[i];
                i++;
            }
            k++;
        }

        while (n1 > i) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (n2 > j) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

}
