import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수의 개수
        int N = Integer.parseInt(br.readLine());
        // 최솟값
        int min = 4000;
        // 최댓값
        int max = -4000;
        // 중앙값
        int[] mid = new int[N];
        // 최빈값
        int[] freq = new int[8001];
        // 산술 평균을 위한 합계
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            mid[i] = num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            ++freq[num + 4000];
        }
        // 산술 평균
        bw.write(Math.round((double) sum / N) + "\n");
        // 중앙값
        Arrays.sort(mid);
        bw.write(mid[N / 2] + "\n");
        // 최빈값
        int f_idx = 0;
        int cnt = 1;
        int[] dup = { 0, 0 };
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > dup[0]) {
                dup[0] = freq[i];
                cnt = 1;
                f_idx = i;
            } else if (freq[i] == dup[0] && cnt == 1) {
                ++cnt;
                f_idx = i;
            }
        }
        bw.write(f_idx - 4000 + "\n");
        // 범위
        bw.write(max - min + "");
        bw.close();
    }
}
