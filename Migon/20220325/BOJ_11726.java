import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] cnt = new int[n + 2];
        cnt[1] = 1;
        cnt[2] = 2;
        for (int i = 3; i <= n; i++) {
            cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 10007;
        }
        System.out.println(cnt[n]);
    }
}
