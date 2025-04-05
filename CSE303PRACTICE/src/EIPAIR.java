import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EIPAIR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int key = sc.nextInt();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            List<Integer> list = new ArrayList<>(map.values());
            sb.append(ways(list)).append("\n");
        }

        System.out.println(sb);
    }

    public static int ways(List<Integer> list) {
        int res = 0;
        for (Integer way : list) {
            res += way * (way - 1) / 2;
        }
        return res;

    }
}
