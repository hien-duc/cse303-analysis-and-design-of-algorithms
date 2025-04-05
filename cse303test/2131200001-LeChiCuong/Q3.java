import java.util.Arrays;
import java.util.Scanner;

class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int numBeacons = sc.nextInt();

            int[] beacons = new int[n];
            for (int j = 0; j < n; j++) {
                beacons[j] = sc.nextInt();
            }

            Arrays.sort(beacons);

            int max = beacons[n - 1] - beacons[0];
            int l = 0;
            int r = max;
            int min = Integer.MAX_VALUE;
            
            while (l <= r) {
                int middle = (l + r) / 2;
                int count = count(beacons, middle, n, numBeacons);
                
                if (count > numBeacons) {
                    r = middle - 1;
                } else if (count < numBeacons) {
                    l = middle + 1;
                } else {
                    min = Math.min(min, middle);
                    r = middle - 1;
                }
            }
            output.append(min).append("\n");
        }
        System.out.println(output);
    }

    public static int count(int[] beacons, int maxGap, int n, int num) {
        int count = 0;
        int[] counts = new int[n];
        counts[0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (beacons[i] - maxGap <= beacons[i - 1]) {
                counts[i] = counts[i - 1] + 1;
            } else {
                counts[i] = 1;
            }
            count = Math.max(count, counts[i]);
            if (count == num) return count;
        }
        return count;
    }
}
