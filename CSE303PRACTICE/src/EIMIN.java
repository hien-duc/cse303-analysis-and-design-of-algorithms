import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class EIMIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(0);
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextInt());
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((s1, s2) -> (s1 - s2));

        queue.addAll(tree);

        for (int i = 0; i < k; i++) {
            if (queue.size() == 1) {
                sb.append(0).append("\n");
            } else {
                int minus = queue.poll();
                sb.append(queue.peek() - minus).append("\n");
            }
        }
        System.out.println(sb);
    }
}
