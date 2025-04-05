import java.util.*;

public class cow {
    public static void main(String[] args) {
        int tc = sc.nextInt(); // Số bộ test
        while (tc-- > 0) {
            int n = sc.nextInt(); // Số chuồng bò
            int c = sc.nextInt(); // Số con bò
            int[] arr = new int[n];

            // Đọc vị trí các chuồng bò
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Sắp xếp các chuồng theo thứ tự tăng dần
            Arrays.sort(arr);

            // Tìm kiếm nhị phân trên khoảng cách nhỏ nhất giữa hai con bò
            int left = 0;
            int right = 100;
            int middle = (left + right) / 2;

            while (right - left > 1) {
                int available = availableWithDistance(middle, arr);

                if (available < c) {
                    right = middle; // Khoảng cách quá lớn, giảm xuống
                } else {
                    left = middle; // Có thể đặt được, thử khoảng cách lớn hơn
                }

                middle = (left + right) / 2;
            }

            sb.append(left + "\n"); // In ra kết quả cho từng bộ test
        }

        System.out.println(sb);
    }

    static int availableWithDistance(int distance, int[] arr) {
        int count = 1; // Đặt con bò đầu tiên vào chuồng đầu tiên
        int nextEle = arr[0] + distance; // Vị trí tiếp theo có thể đặt bò

        while (true) {
            int index = Arrays.binarySearch(arr, nextEle);
            if (index < 0) {
                index = ~index; // Chuyển index âm thành vị trí đúng
            }
            if (index < arr.length) {
                count++;
                nextEle = arr[index] + distance;
            } else {
                break;
            }
        }
        return count; // Trả về số con bò có thể đặt được
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
}
