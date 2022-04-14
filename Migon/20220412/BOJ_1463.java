import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 정수 X
        int X = sc.nextInt();
        int[] dp = new int[X + 3];
        dp[1] = 0; // 1
        dp[2] = 1; // 2 - 1
        dp[3] = 1; // 3 / 3
        int num = 4;
        while (num <= X) {
            // 둘 다 나눠지면 셋 중 작은 값
            if (num % 3 == 0 && num % 2 == 0) {
                dp[num] = Math.min(Math.min(dp[num / 3], dp[num / 2]), dp[num - 1]) + 1;
            }
            // 3으로 나눠지거나 하나 뺀 것 중 작은 값
            else if (num % 3 == 0) {
                dp[num] = Math.min(dp[num / 3], dp[num - 1]) + 1;
            }
            // 2로 나눠지거나 하나 뺀 것 중 작은 값
            else if (num % 2 == 0) {
                dp[num] = Math.min(dp[num / 2], dp[num - 1]) + 1;
            }
            // 하나 뺀 것 + 1회
            else if (num % 3 != 0 && num % 2 != 0) {
                dp[num] = dp[num - 1] + 1;
            }
            num++;
        }
        System.out.println(dp[X]);
    }
}