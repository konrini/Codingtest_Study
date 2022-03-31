import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 2의 개수와 5의 개수
        int two_cnt = 0;
        int five_cnt = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (true) {
                if (num % 2 == 0) {
                    ++two_cnt;
                    num /= 2;
                    continue;
                }
                if (num % 5 == 0) {
                    ++five_cnt;
                    num /= 5;
                    continue;
                }
                // 2로도 5로도 나누어지지 않을 때 도달
                break;
            }
        }
        System.out.println(Math.min(two_cnt, five_cnt));
    }
}
