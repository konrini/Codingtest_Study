import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 2];
        dp[1] = 1; // 1 = 1^2
        dp[2] = 2; // 2 = 1^2 + 1^2
        for (int i = 3; i <= n; i++) {
            // 제곱수일 때
            if ((int) Math.sqrt(i) * Math.sqrt(i) == i) {
                dp[i] = 1;
            } else {
                // 최댓값으로 갱신
                dp[i] = 4;
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
                }
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
