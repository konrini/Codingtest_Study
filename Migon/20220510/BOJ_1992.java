import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static char[][] map;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 영상의 크기
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        quadtree(0, 0, N);
        bw.close();
    }

    // r : 행, c : 열, size : 크기
    public static void quadtree(int r, int c, int size) throws IOException {
        // 더이상 쪼개지지 않을 때
        if (size == 1) {
            bw.write(map[r][c]);
            return;
        }
        // 색깔
        char color = map[r][c];
        st: for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                // 색깔 다르면
                if (map[i][j] != color) {
                    color = '2';
                    break st;
                }
            }
        }
        // 색깔 모두 일치할 때
        if (color != '2') {
            bw.write(color);
            return;
        }
        // 같은 사이즈가 한 묶음
        bw.write("(");
        for (int i = r; i < r + size; i += size / 2) {
            for (int j = c; j < c + size; j += size / 2) {
                quadtree(i, j, size / 2);
            }
        }
        // 같은 사이즈 끝
        bw.write(")");
    }
}