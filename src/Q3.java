import java.util.*;

class Q3 {
    private static Map<String, Integer> values;
    private static Set<String> permutations;
    private static int[] charCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String pair = input[0];
            int value = Integer.parseInt(input[1]);
            values.put(pair, value);
            values.put("" + pair.charAt(1) + pair.charAt(0), value);
        }

        charCount = new int[3];
        for (char c : S.toCharArray()) {
            charCount[c - '1']++;
        }

        permutations = new HashSet<>();
        generatePermutations(new StringBuilder(), S.length());

        long minValue = Long.MAX_VALUE;
        for (String perm : permutations) {
            long currentValue = calculateValue(perm);
            minValue = Math.min(minValue, currentValue);
        }

        System.out.println(minValue);

        sc.close();
    }

    private static void generatePermutations(StringBuilder current, int length) {
        if (current.length() == length) {
            permutations.add(current.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (charCount[i] > 0) {
                charCount[i]--;
                current.append((char) ('1' + i));
                generatePermutations(current, length);
                current.deleteCharAt(current.length() - 1);
                charCount[i]++;
            }
        }
    }

    private static long calculateValue(String s) {
        long total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String pair = s.substring(i, i + 2);
            total += values.getOrDefault(pair, 0);
        }
        return total;
    }
}
