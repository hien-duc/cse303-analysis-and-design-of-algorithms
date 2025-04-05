import java.util.Scanner;
import java.util.TreeSet;

class Q1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String n = sc.next();
        TreeSet<String> treeSet1 = new TreeSet<>();
        treeSet1.add("");

        for (int i = 0; i < n.length(); i++) {
            TreeSet<String> treeSet2 = new TreeSet<>();
            for (String e : treeSet1) {
                for (int j = 0; j <= e.length(); j++) {
                    String newLine = e.substring(0, j) + n.charAt(i) + e.substring(j);
                    treeSet2.add(newLine);
                }
            }
            treeSet1 = treeSet2;
        }

        sb.append(treeSet1.size()).append("\n");
        for (String string : treeSet1) {
            sb.append(string).append("\n");
        }
        System.out.println(sb);
    }
}
