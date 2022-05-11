import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정점의 개수
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 거리를 무한대 값으로 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < N; j++) {
                // 연결되어 있으면 1, 연결되어 있지 않으면 0
                int connected = Integer.parseInt(st.nextToken());
                // 연결되어 있으면 거리 1로 바꾸기
                if (connected == 1) {
                    map[i][j] = 1;
                }
            }
        }
        // 경
        for (int k = 0; k < N; k++) {
            // 출
            for (int i = 0; i < N; i++) {
                // 도
                for (int j = 0; j < N; j++) {
                    // 거리 짧으면 갱신
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 다른 곳을 거쳐서도 갈 수 없을 때
                if (map[i][j] == INF) {
                    bw.write("0 ");
                } 
                // 갈 수 있을 때
                else {
                    bw.write("1 ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}