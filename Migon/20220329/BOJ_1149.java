import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N번째 줄의 R, G, B로 색칠하는 가격
        int[][] RGB = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 비용
        int[][] total = new int[N + 1][3];
        // 초기값 저장
        total[1][0] = RGB[1][0];
        total[1][1] = RGB[1][1];
        total[1][2] = RGB[1][2];
        // 직전까지 비용의 최솟값 + 자기자신
        for (int i = 2; i <= N; i++) {
            total[i][0] = Math.min(total[i - 1][1], total[i - 1][2]) + RGB[i][0];
            total[i][1] = Math.min(total[i - 1][0], total[i - 1][2]) + RGB[i][1];
            total[i][2] = Math.min(total[i - 1][0], total[i - 1][1]) + RGB[i][2];
        }
        // 최솟값 출력
        int answer = 1000 * 1000;
        answer = Math.min(total[N][0], total[N][1]);
        answer = Math.min(total[N][2], answer);
        System.out.println(answer);
    }
}
