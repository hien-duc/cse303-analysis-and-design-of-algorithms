import java.util.Scanner;

public class EISUBARRAY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(kadane(arr));

    }

    public static int kadane(int[] arr) {

        int posRes = 0;
        int negRes = 0;

        int posSum = 0;
        int negSum = 0;

        for (int i = 0; i < arr.length; i++) {
            posSum += arr[i];
            negSum += arr[i];

            if (posSum < 0) {
                posSum = 0;
            }
            if (negSum > 0) {
                negSum = 0;
            }

            posRes = Math.max(posRes, posSum);
            negRes = Math.min(negRes, negSum);
        }

        return Math.max(posRes, Math.abs(negRes));

    }
}
