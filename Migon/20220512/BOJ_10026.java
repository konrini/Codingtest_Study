import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    static int N; // 지도의 크기
    static char[][] map; // 지도
    static int[][] v1; // 적록색약 아닌 사람들의 방문 처리
    static int[][] v2; // 적록색약인 사람들의 방문 처리
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 네 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 지도의 크기
        N = Integer.parseInt(br.readLine());
        // 지도
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // 방문 처리
        v1 = new int[N][N]; // 적록색약 X
        v2 = new int[N][N]; // 적록색약 O
        int cnt1 = 0; // 적록색약 X의 묶음 수
        int cnt2 = 0; // 적록색약 O의 묶음 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v1[i][j] == 0) {
                    bfs(i, j, map[i][j]);
                    cnt1++;
                }
                if (v2[i][j] == 0) {
                    daltonism(i, j, map[i][j]);
                    cnt2++;
                }
            }
        }
        // 출력
        bw.write(cnt1 + " " + cnt2);
        bw.close();
    }

    // 적록색약 X
    public static void bfs(int r, int c, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        v1[r][c] = 1;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int nr = loc[0] + dir[i][0];
                int nc = loc[1] + dir[i][1];
                // 범위 넘어갈 때
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                // 이미 방문한 곳일 때
                if (v1[nr][nc] == 1) {
                    continue;
                }
                // 색깔과 보이는 색깔이 같을 때
                if (color == map[nr][nc]) {
                    queue.add(new int[] { nr, nc });
                    v1[nr][nc] = 1;
                    continue;
                }
            }
        }
    }

    // 적록색약 O
    public static void daltonism(int r, int c, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        v2[r][c] = 1;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int nr = loc[0] + dir[i][0];
                int nc = loc[1] + dir[i][1];
                // 범위 넘어갈 때
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                // 이미 방문한 곳일 때
                if (v2[nr][nc] == 1) {
                    continue;
                }
                // 파란색일 때
                if (color == 'B') {
                    // 보이는 것이 파란색이라면
                    if (map[nr][nc] == 'B') {
                        queue.add(new int[] { nr, nc });
                        v2[nr][nc] = 1;
                    }
                    continue;
                }
                // 빨간색이나 초록색일때
                if (color == 'R' || color == 'G')
                    // 보이는 것이 빨간색이나 초록색이라면
                    if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                        queue.add(new int[] { nr, nc });
                        v2[nr][nc] = 1;
                    }
                continue;
            }
        }
    }
}