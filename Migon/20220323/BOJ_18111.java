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
        StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
        // N개의 행
        int N = Integer.parseInt(st1.nextToken());
        // M개의 열
        int M = Integer.parseInt(st1.nextToken());
        // 인벤토리에 있는 블럭의 개수
        int B = Integer.parseInt(st1.nextToken());
        // 높이의 정보를 담은 배열
        int[] height = new int[N * M];
        // 높이 최댓값
        int max = 0;
        // 높이 최솟값
        int min = 256;
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < M; j++) {
                height[i * M + j] = Integer.parseInt(st2.nextToken());
                if (height[i * M + j] > max) {
                    max = height[i * M + j];
                }
                if (height[i * M + j] < min) {
                    min = height[i * M + j];
                }

            }
        }
        // 총 작업 시간
        int time = Integer.MAX_VALUE;
        // 그 때 땅의 높이
        int ans = 0;
        // 높이를 h로 맞춰줄 때
        for (int h = min; h <= max; h++) {
            // 블록 제거할 때 작업 시간
            int cut = 0;
            // 블록 놓을 때 작업 시간
            int put = 0;
            // 인벤토리에 있는 블록 수
            int block = B;
            for (int i = 0; i < height.length; i++) {
                // 블록 제거
                if (height[i] > h) {
                    int diff = height[i] - h;
                    cut += 2 * diff;
                    block += diff;
                }
                // 블록 놓기
                else if (height[i] < h) {
                    int diff = h - height[i];
                    put += diff;
                    block -= diff;
                }
            }
            // 정상적인 작업이었을 때
            // 답이 여러 개라면, 그 중에서 땅의 높이가 가장 높은 것
            if (block >= 0) {
                if (cut + put <= time) {
                    time = cut + put;
                    ans = h;
                }
            }
        }
        bw.write(time + " " + ans);
        bw.close();
    }
}
