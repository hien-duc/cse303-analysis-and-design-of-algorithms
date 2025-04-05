import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class EIEQUALS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) - 1);
            if (map.get(key) == 0) {
                map.remove(key);
            }
        }

        if (map.size() == 0) {
            System.out.println("YES");
            return;
        }

        if (map.size() != 2) {
            System.out.println("NO");
            return;
        }

        Iterator<Entry<Integer, Integer>> i = map.entrySet().iterator();

        Entry<Integer, Integer> first = i.next();

        int firstKey = first.getKey();
        int firstValue = first.getValue();

        Entry<Integer, Integer> second = i.next();

        int secondKey = second.getKey();
        int secondValue = second.getValue();

        if (firstValue == 1 && secondValue == -1 || firstValue == -1 && secondValue == 1) {
            if (Math.abs(firstKey - secondKey) <= k) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
