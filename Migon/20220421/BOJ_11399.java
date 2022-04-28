import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 사람의 수
        int N = Integer.parseInt(br.readLine());
        // 필요한 시간의 정보를 담은 배열
        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순으로 정렬
        Arrays.sort(time);
        // 필요한 시간의 합의 최솟값
        int sum = time[0];
        for (int i = 1; i < N; i++) {
            // 전 시간을 더하기
            time[i] += time[i - 1];
            sum += time[i];
        }
        bw.write(sum + "");
        bw.close();
    }
}
