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
        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            int M = Integer.parseInt(st.nextToken()); // x의 마지막 해
            int N = Integer.parseInt(st.nextToken()); // y의 마지막 해
            int x = Integer.parseInt(st.nextToken()); // x의 target 연도
            int y = Integer.parseInt(st.nextToken()); // y의 target 연도
            int a = x; // 무조건 target 연도 맞다고 가정
            int b = x % N; // 이에 따른 y의 연도 맞춰줄 것임
            if (b == 0) {
                b = N;
            }
            int[] b_check = new int[N + 1]; // y가 target 연도에 도달하기까지의 지나온 연도들
            b_check[b] = 1;
            boolean check = true; // 표현될 수 있는지 체크용
            while (b != y) {
                a += M; // 무조건 target 연도 맞춰줌
                b = a % N; // 이에 따른 y의 연도
                if (b == 0) {
                    b = N;
                }
                // 만약 y가 target 연도에 도달하면
                if (b == y) {
                    break;
                }
                // 만약 y의 도달한 연도가 반복된다면
                if (b_check[b] == 1) {
                    check = false;
                    break;
                }
                // 박문철이
                b_check[b] = 1;
            }
            if (check) {
                bw.write(a + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.close();
    }
}