import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] fibo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스의 수
        int T = sc.nextInt();
        // 각 테스트 케이스의 숫자
        int max = 0; // 최댓값
        int[] nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 0번째 인덱스 : 0 횟수, 1번째 인덱스 : 1 횟수
        fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            fibonacci(i);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(fibo[nums[i]][0] + " " + fibo[nums[i]][1]);
        }
    }

    public static void fibonacci(int n) {
        int[] temp = new int[2];
        temp[0] = fibo[n - 1][0] + fibo[n - 2][0];
        temp[1] = fibo[n - 1][1] + fibo[n - 2][1];
        fibo[n] = temp;
    }
}
