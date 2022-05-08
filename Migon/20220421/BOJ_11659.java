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
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        // 시작점
        int N = Integer.parseInt(st1.nextToken());
        // 끝점
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N + 1]; // 숫자 담을 배열
        int[] dp = new int[N + 1]; // 숫자 합 담을 배열
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 숫자 받고
            arr[i] = Integer.parseInt(st2.nextToken());
            // 그 전까지의 합과 더하기
            dp[i] = dp[i - 1] + arr[i];
        }
        for (int c = 0; c < M; c++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st3.nextToken());
            int j = Integer.parseInt(st3.nextToken());
            // 구간 합 구하기
            bw.write(dp[j] - dp[i - 1] + "\n");
        }
        bw.close();
    }
}