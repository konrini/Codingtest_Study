import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        // 저장된 사이트 주소의 수
        int N = Integer.parseInt(st.nextToken());
        // 비밀번호 찾으려는 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken());
        // key : 사이트, value : 비밀번호
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine() + " ");
            map.put(st1.nextToken(), st1.nextToken());
        }
        for (int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }
        br.close();
        bw.close();
    }
}
