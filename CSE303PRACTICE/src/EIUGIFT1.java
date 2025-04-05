import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFT1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4 4
        // 2 3 2 4
        // 5 10 15 20

        int numGift = sc.nextInt();
        int numWrap = sc.nextInt();

        double[] arrGift = new double[numGift];
        double[] arrWrap = new double[numWrap];

        for (int i = 0; i < arrGift.length; i++) {
            arrGift[i] = sc.nextInt();
        }
        for (int i = 0; i < arrWrap.length; i++) {
            arrWrap[i] = sc.nextInt();
        }

        Arrays.sort(arrGift);
        Arrays.sort(arrWrap);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < arrGift.length && j < arrWrap.length) {
            double rate = arrWrap[j] / arrGift[i];
            if (rate >= 2 && rate <= 3) {
                count++;
                i++;
                j++;
            }
            if (rate > 3) {
                i++;
            }
            if (rate < 2) {
                j++;
            }
        }

        System.out.println(count);

    }
}
