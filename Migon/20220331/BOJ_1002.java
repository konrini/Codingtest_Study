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
        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            // 원1의 중심과 반지름
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            // 원2의 중심과 반지름
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int answer = 0;
            // 무한대 (일치)
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                answer = -1;
            }
            // 만나지 않을 때
            // 1) 아예 떨어져있음
            else if (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) > Math.pow(r1 + r2, 2)) {
                answer = 0;
            }
            // 2) 원이 다른 하나를 포함
            else if (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(r1 - r2, 2)) {
                answer = 0;
            }
            // 접할 때
            // 1) 외접
            else if (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) == Math.pow(r1 + r2, 2)) {
                answer = 1;
            }
            // 2) 내접
            else if (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) == Math.pow(r1 - r2, 2)) {
                answer = 1;
            }
            // 두 점에서 만날 때
            else {
                answer = 2;
            }
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}