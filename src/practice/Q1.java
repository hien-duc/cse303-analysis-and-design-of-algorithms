package practice;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();
        int beosMoney = sc.nextInt();

        int[] price = new int[item];
        for (int i = 0; i < item; i++) {
            price[i] = sc.nextInt();
        }

        Arrays.sort(price);

        int highestPrice = -1;
        int mindiff = -1;
        int left = 0;
        int right = item - 1;

        while (left < right) {
            int sum = price[left] + price[right];
            int diff = Math.abs(price[left] - price[right]);
            if (sum <= beosMoney) {
                if (sum > highestPrice || sum == highestPrice && diff < mindiff) {
                    mindiff = diff;
                    highestPrice = sum;
                }
                left++;
            } else {
                right--;
            }

        }

        if (highestPrice == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(highestPrice + " " + mindiff);
        }

    }

}
