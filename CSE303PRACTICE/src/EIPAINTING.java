import java.util.HashMap;
import java.util.Scanner;

public class EIPAINTING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }

        int max = Integer.MIN_VALUE/2;;

        for (Integer i : map.values()) {
            max = Math.max(i, max);
        }

        System.out.println(n-max);
    }
}
