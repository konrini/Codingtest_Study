import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        // M이상 N이하의 소수 출력
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 1 지우기
        if (M == 1) {
            ++M;
        }
        // 숫자 담을 배열
        int[] prime = new int[N - M + 1];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = M++;
        }
        for (int num : prime) {
            // 소수 체크
            boolean check = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                bw.write(num + "\n");
            }
        }
        bw.close();
    }
}