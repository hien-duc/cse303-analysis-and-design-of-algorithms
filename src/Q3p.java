import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3p {

    private static Map<String, Integer> pairs;
    private static long minValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();

        pairs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");

            String pair = temp[0];

            int value = Integer.parseInt(temp[1]);

            pairs.put(pair, value);

            pairs.put("" + pair.charAt(1) + pair.charAt(0), value);
        }

        int[] count = new int[3];

        for (char c : s.toCharArray()) {
            count[c - '1']++;
        }
        minValue = Long.MAX_VALUE;
        findMin(new StringBuilder(), s.length(), count, 0);

        System.out.println(minValue);
    }

    public static void findMin(StringBuilder current, int length, int[] count,
            long value) {
        if (current.length() == length) {
            minValue = Math.min(minValue, value);
            return;
        }

        // for (int i = 0; i < 3; i++) {
        // if (count[i] > 0) {
        // count[i]--;
        // current.append((char)('1' + i));

        // long newValue = value;

        // if (current.length() >= 2) {
        // String pair = current.substring(current.length() - 2);
        // newValue += pairs.getOrDefault(pair, 0);
        // }

        // if (newValue < minValue) {
        // findMin(current, length, count, newValue);
        // }

        // current.deleteCharAt(current.length() - 1);

        // count[i]++;
        // }
        // }

        for (int i = 0; i < 3; i++) {
            if (count[i] > 0) {
                count[i]--;
                current.append((char) ('1' + i));

                long newValue = value;

                if (current.length() >= 2) {
                    String pair = current.substring(current.length() - 2);
                    newValue += pairs.getOrDefault(pair, 0);
                }

                if (newValue < minValue) {
                    findMin(current, length, count, newValue);
                }

                current.deleteCharAt(current.length() - 1);
                count[i]++;
            }
        }
    }
}
