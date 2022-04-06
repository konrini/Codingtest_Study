import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 듣도 못한 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 보도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());
        // 듣도 못한 사람
        HashSet<String> hear = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hear.add(br.readLine());
        }
        // 보도 못한 사람
        HashSet<String> see = new HashSet<>();
        for (int i = 0; i < M; i++) {
            see.add(br.readLine());
        }
        // 교집합
        hear.retainAll(see);
        // set -> list
        List<String> list = new ArrayList<>(hear);
        list.sort(null);
        // 듣보잡의 수
        bw.write(list.size() + "\n");
        for (String item : list) {
            bw.write(item + "\n");
        }
        br.close();
        bw.close();
    }
}
