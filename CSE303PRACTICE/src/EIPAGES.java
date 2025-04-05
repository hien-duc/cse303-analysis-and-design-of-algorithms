import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EIPAGES {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            list.add(temp);
        }
        Collections.sort(list);

        shortenPage(list);

        System.out.println(sb);
    }

    public static void shortenPage(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {

            int start = list.get(i);

            while (i + 1 < list.size() && list.get(i) + 1 == list.get(i+1)) {
                i++;
            }

            if (sb.length() > 0) {
                sb.append(" ");
            }

            if(start == list.get(i)){
                sb.append(start);
            }else if(start == list.get(i)-1){
                sb.append(start).append(" ").append(list.get(i));
            }else{
                sb.append(start).append("-").append(list.get(i));
            }
        }
    }
}
