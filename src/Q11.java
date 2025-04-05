import java.util.Scanner;
import java.util.TreeSet;

public class Q11 {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // String s = sc.nextLine();

        // char[] c = s.toCharArray();

        // TreeSet<String> list = new TreeSet<>();

        // list.add("");

        // for (int i = 0; i < s.length(); i++) {
        // char letter = c[i];

        // TreeSet<String> temp = new TreeSet<>();
        // for (String ans : list) {
        // int count = ans.length();

        // for (int j = 0; j <= count; j++) {
        // String newAns = (ans.substring(0, j) + letter + ans.substring(j));
        // temp.add(newAns);
        // }

        // }

        // list = temp;

        // }
        // for (String ans : list){
        // sb.append(ans).append("\n");
        // }

        // System.out.println(sb);

        String s = sc.nextLine();

        char[] c = s.toCharArray();

        TreeSet<String> list = new TreeSet<>();

        list.add("");

        for (int i = 0; i < s.length(); i++) {
            char letter = c[i];
            TreeSet<String> temp = new TreeSet<>();

            for (String ans : list) {
                int count = ans.length();
                for (int j = 0; j <= count; j++) {
                    String newAns = (ans.substring(0, j) + letter + ans.substring(j));
                    temp.add(newAns);
                }
            }

            list = temp;
        }
        sb.append(list.size()).append("\n");
        for (String ans : list){
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}
