import java.util.Scanner;

public class EIULOVE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                max = Math.max(max, arr[i]);
        }
        if(max > 0){
            System.out.println(max);
        }else{
            System.out.println("-1");
        }
    }
}
