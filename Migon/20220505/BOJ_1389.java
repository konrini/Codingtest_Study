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
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        // 유저의 수
        int N = Integer.parseInt(st.nextToken());
        // 친구 관계의 수
        int M = Integer.parseInt(st.nextToken());
        // 친구 관계
        int[][] friends = new int[N + 1][N + 1];

        // 거리 초기화
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    friends[i][j] = 0;
                } else {
                    friends[i][j] = 987654321;
                }
            }
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
            int f1 = Integer.parseInt(st1.nextToken());
            int f2 = Integer.parseInt(st1.nextToken());
            friends[f1][f2] = 1;
            friends[f2][f1] = 1;
        }

        // 플로이드 워샬 : 거쳐서 가는 것을 기준
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        // 케빈
        int kevin = N + 1;
        // 케빈 베이컨의 수
        int total = 987654321;
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            // 기준 사람으로부터 모든 사람에 대한 케빈 베이컨의 수 더하기
            for (int j = 1; j < N + 1; j++) {
                cnt += friends[i][j];
            }
            // 케빈 베이컨의 수가 작을 때
            if (cnt <= total) {
                // 값이 같으면 작은 번호의 케빈으로 갱신
                if (cnt == total) {
                    if (i < kevin) {
                        kevin = i;
                    }
                }
                // 아니면 케빈 그냥 갱신
                else {
                    total = cnt;
                    kevin = i;
                }
            }
        }
        bw.write(kevin + "");
        bw.close();
    }
}