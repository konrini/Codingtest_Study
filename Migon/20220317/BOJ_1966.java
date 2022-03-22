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
        for (int i = 0; i < T; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
            // 문서의 개수
            int N = Integer.parseInt(st1.nextToken());
            // 몇 번째로 인쇄되었는지 궁금한 문서가 몇 번째에 위치하고 있는지
            int M = Integer.parseInt(st1.nextToken());
            // 중요도 입력할 배열
            int[] importance = new int[N];
            StringTokenizer st2 = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < N; j++) {
                importance[j] = Integer.parseInt(st2.nextToken());
            }
            // 출력 순서
            int cnt = 0;
            // 보고 있는 인덱스
            int idx = 0;
            while (!(importance[M] == 0)) {
                idx %= N;
                // 현재 출력하려는 값이 중요도가 최대인지 확인
                boolean check = true;
                for (int k = idx + 1; k < idx + N; k++) {
                    if (importance[idx] < importance[k % N]) {
                        check = false;
                        break;
                    }
                }
                // 최대이면 출력
                if (check) {
                    importance[idx++] = 0;
                    ++cnt;
                }
                // 아니면 문서 넘기기
                else {
                    idx++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}