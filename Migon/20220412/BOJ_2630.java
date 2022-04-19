import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 한 변의 길이
        int N = Integer.parseInt(br.readLine());
        // 색종이 입력
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, N);
        bw.write(count[0] + "\n" + count[1]);
        bw.close();
    }

    public static void cut(int r, int c, int size) {
        // 하얀색(0)인지 파란색(1)인지
        int color = arr[r][c];
        boolean check = true;
        statement: for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != color) {
                    check = false;
                    break statement;
                }
            }
        }
        // 색깔이 모두 같을 때
        if (check) {
            count[color] += 1;
            return;
        }
        // 사이즈 절반으로 줄이기
        for (int i = r; i < r + size; i += size / 2) {
            for (int j = c; j < c + size; j += size / 2) {
                cut(i, j, size / 2);
            }
        }
    }
}
