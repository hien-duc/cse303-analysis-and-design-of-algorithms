import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EIUSUBSET {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        // for (int i = n - 1; i >= 0; i--) {
        // int c = arr[i];
        // int count = list.size();
        // for (int j = 0; j < count; j++) {
        // list.add(c + " " + list.get(j));
        // }
        // }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = arr[i];
            int count = list.size();
            for (int j = 0; j < count; j++) {
                if (c + list.get(j) == k) {
                    res++;
                }
                list.add(c + list.get(j));
            }
        }
        System.out.println(res);
    }
}
