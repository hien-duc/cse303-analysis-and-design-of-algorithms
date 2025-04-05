import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3Simple {
    // Stores pair values and the minimum value found
    private static Map<String, Integer> pairs;
    private static long minValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        pairs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String pair = input[0];
            int value = Integer.parseInt(input[1]);
            pairs.put(pair, value);
            pairs.put("" + pair.charAt(1) + pair.charAt(0), value);
        }

        int[] counts = new int[3];
        for (char c : S.toCharArray()) {
            counts[c - '1']++;
        }

        minValue = Long.MAX_VALUE;
        findMin(new StringBuilder(), S.length(), counts, 0);

        System.out.println(minValue);
        sc.close();
    }

    private static void findMin(StringBuilder current, int length, int[] counts,
            long value) {
        if (current.length() == length) {
            minValue = Math.min(minValue, value);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (counts[i] > 0) {
                counts[i]--;
                current.append((char) ('1' + i));

                long newValue = value;
                if (current.length() >= 2) {
                    String pair = current.substring(current.length() - 2);
                    newValue += pairs.getOrDefault(pair, 0);
                }

                if (newValue < minValue) {
                    findMin(current, length, counts, newValue);
                }

                current.deleteCharAt(current.length() - 1);
                counts[i]++;
            }
        }
    }

    
}