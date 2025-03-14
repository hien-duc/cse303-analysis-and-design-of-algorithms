package practice;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] gifts = new int[n];
        int[] wrappingPaper = new int[m];
        for (int i = 0; i < gifts.length; i++) {
            gifts[i] = sc.nextInt();
        }
        for (int i = 0; i < wrappingPaper.length; i++) {
            wrappingPaper[i] = sc.nextInt();
        }
        Arrays.sort(gifts);
        Arrays.sort(wrappingPaper);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n && j < m) {
            if (wrappingPaper[j] >= gifts[i] * 2 && wrappingPaper[j] <= gifts[i] * 3) {
                i++;
                j++;
                count++;
            } else if (wrappingPaper[j] < gifts[i] * 2) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
