import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    // 북 동 남 서
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());
        for (int cases = 0; cases < T; cases++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
            int M = Integer.parseInt(st1.nextToken()); // 가로 길이
            int N = Integer.parseInt(st1.nextToken()); // 세로 길이
            int K = Integer.parseInt(st1.nextToken()); // 배추가 심어져 있는 위치의 개수
            // 지도 정보
            int[][] map = new int[M][N];
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine() + " ");
                int r = Integer.parseInt(st2.nextToken());
                int c = Integer.parseInt(st2.nextToken());
                map[r][c] = 1;
            }
            // 인접 배추를 살피기 위해 사용할 bfs 처리를 위한 큐 생성
            Queue<int[]> queue = new LinkedList<>();
            // 배추 무리 세기
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 아직 방문하지 않은 배추일 때
                    if (map[i][j] == 1) {
                        // 무리 카운팅
                        cnt++;
                        queue.add(new int[] { i, j });
                        while (!queue.isEmpty()) {
                            int[] loc = queue.poll();
                            // 네 방향 탐색
                            for (int d = 0; d < 4; d++) {
                                int nr = loc[0] + dir[d][0];
                                int nc = loc[1] + dir[d][1];
                                // 범위를 넘어갈 때
                                if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
                                    continue;
                                }
                                // 배추가 없거나, 이미 방문한 곳일 때
                                if (map[nr][nc] == 0) {
                                    continue;
                                }
                                // 박문철이
                                map[nr][nc] = 0;
                                queue.add(new int[] { nr, nc });
                            }
                        }
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}
